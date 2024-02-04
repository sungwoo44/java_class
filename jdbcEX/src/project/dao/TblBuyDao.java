package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomBuyVo;

public class TblBuyDao {

    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 1)구매하기
    public int buy(BuyVo vo) {
        String sql = "insert into tbl_buy(buy_idx,customid,pcode,quantity,buy_date)" +
                "values(buy_pk_seq.nextval,?,?,?,sysdate)";
        int result = 0;
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, vo.getCustomid());
            pstmt.setString(2, vo.getPcode());
            pstmt.setInt(3, vo.getQuantity());

            result = pstmt.executeUpdate(); // DML이 쿼리가 조건에맞는 행이 참조테이블에 있다면 1 리턴,
            // 참조테이블에 없으면 0 리턴

        } catch (SQLException e) { // customid와 pcode는 참조테이블에 존재하는 값이 아니라면 무결성 위반 오류
            System.out.println("구매하기 실행 예외 발생");
            e.printStackTrace();
        }
        return result;
    }

    // 2)구매취소 특정 행을 수정하려면 where 조건컬럼 buy_idx(pk)
    public int delete(int buy_idx) {
        String sql = " DELETE FROM TBL_BUY tc WHERE BUY_IDX = ?";
        int result = 0;
        try ( // auto close
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) 
        
                {
            pstmt.setInt(1, buy_idx);
            result = pstmt.executeUpdate();

        } catch (SQLException e) {// buy_idx가 참조테이블에 없는 데이터 라면 오류가 아니라 delete 반영 행의 갯수가 0
            System.out.println("구매취소 실행 예외 발생");

            // close 는 자동
        }
        return result;

    }

    // 3)구매수량 변경 Pk는 행 식별. 특정 행을 수정하려면 where 조건컬럼 buy_idx(pk)
    public int modify(BuyVo vo) {
        String sql = "UPDATE TBL_BUY SET QUANTITY =? WHERE BUY_IDX =?";

        int result = 0;
        try ( // auto close
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setInt(1, vo.getQuantity());
            pstmt.setInt(2, vo.getBuy_idx());

            // 매개변수 바인딩
            result = pstmt.executeUpdate();
        } catch (SQLException e) { // buy_idx가 참조테이블에 없는 데이터 라면 오류가 아니라 update반영 행의 갯수가 0

        }
        return result;

        // 4)구매 종료
    }

    // mypage 기능 메소드
    public List<CustomBuyVo> selectCustomBuy(String customid) {
        List<CustomBuyVo> list = new ArrayList<>();
        String sql = "SELECT buy_idx,tb.PCODE,pname,price,QUANTITY ,BUY_DATE" +
                " FROM TBL_BUY tb" +
                " JOIN TBL_PRODUCT tp" +
                " ON tb.PCODE = tp.PCODE" +
                " WHERE tb.CUSTOMID = ? ";

        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, customid);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new CustomBuyVo(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getTimestamp(6)));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

public int money_of_dayByCustomer(String customid,String buydate){
        String sql = "{ call money_of_day(?,?,?) }";
        int money=0;
        try (
            Connection connection = getConnection();
            CallableStatement cstmt = connection.prepareCall(sql)
            ) {
            //프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            //프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate();      //프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);
            
        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }


    // 장바구니 모두 구매 
    // ㄴ batch : 일괄 처리 : 실행 할 insert,update,delete 등의 데이터 저장 DML을 여러개 모아 두었다가 
    //                          한번에 실행시킵니다. 
    // ㄴ 트랜젝션: 특정 요구사항에 대한 기능을 실행 할 여러 sql 명령들로 구성된 "작업단위"
    //              ㄴ예시) 카트에 저장된 상품중 하나라도 참조값이 없는 Pcode 가 있으면 rollback,
    //                                         모두 정상이면 commit
    public int insertMany(List<BuyVo> cart) { //여러번 (cart 크기)의 insert를 실행          
        String sql = "insert into tbl_buy values(buy_pk_seq.nextval,?,?,?,sysdate)";
        Connection connection = null;
        PreparedStatement pstmt = null;
        int count = 0;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(sql);
            connection.setAutoCommit(false);        // auto commit모드 해제 
            for (BuyVo vo : cart) {
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch();                               //sql 을 메모리에 모아두기 .insert sql 에 대입되는 매개변수는 매번 다르겠네 다른상품을 구매하면..
                count++;
            }
            pstmt.executeBatch();                              //sql 을 일괄 실행하기. 실행중 무결성 오류발생시
            connection.commit();                                //catch 에서 rollback!
        } catch (SQLException e) { // 예외발생 : 트랜젝션 처리 

            try {
                connection.rollback();

            } catch (SQLException e1) {
            }
            count = -1;
            System.out.println("구매불가능한 상품이 있습니다.");
            System.out.println("장바구니 구매 실행 에외 발생" + e.getMessage());
        } finally { // 정상실행, 예외 모두에 대해 자원실행
            try { // 트랜젝션 처리를 위해 connection 을 사용해야 하모르 직접 close
                pstmt.close();
                connection.close();
            } catch (Exception e1) {
            }
        }
        return count;
    }

    

}
