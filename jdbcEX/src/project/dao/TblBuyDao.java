package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.BuyVo;
import project.vo.CustomBuyVo;

public class TblBuyDao {
    
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";


    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }


    //1)구매하기
    public void buy(BuyVo vo){
        String sql = "insert into tbl_buy(buy_idx,customid,pcode,quantity,buy_date)"+  
                "values(tbl_buy_pk_seq.nextval,?,?,?,sysdate)";  

        try (
            Connection connection = getConnection(); 
            PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
                
                pstmt.setString(1,vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());

                pstmt.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //2)구매취소   특정 행을 수정하려면 where 조건컬럼 buy_idx(pk)
    public void delete(int buy_idx){
        String sql=" DELETE FROM TBL_BUY tc WHERE BUY_IDX = ?";

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){       
            pstmt.setInt(1,buy_idx );
            pstmt.executeUpdate();

    }catch (SQLException e){
        //close 는 자동
    }

    }

    //3)구매수량 변경 Pk는 행 식별. 특정 행을 수정하려면 where 조건컬럼 buy_idx(pk)
    public void modify(BuyVo vo){
        String sql="UPDATE TBL_BUY SET QUANTITY =? WHERE BUY_IDX =?"; 
                

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
                   
                    pstmt.setInt(1, vo.getQuantity());
                    pstmt.setInt(2, vo.getBuy_idx());

            //매개변수 바인딩
            pstmt.executeUpdate();
    }catch(SQLException e){

    }

    //4)구매 종료
    }
    //mypage 기능 메소드 
    public List<CustomBuyVo> selectCustomBuy(String customid){
        List<CustomBuyVo> list = new ArrayList<>();
        String sql = "SELECT buy_idx,tb.PCODE,pname,price,QUANTITY ,BUY_DATE" + 
        " FROM TBL_BUY tb" + 
        " JOIN TBL_PRODUCT tp" +
        " ON tb.PCODE = tp.PCODE"+ 
        " WHERE tb.CUSTOMID = ? ";

        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
            ) {
                pstmt.setString(1, customid);
                ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                list.add(new CustomBuyVo(rs.getInt(1),
                                        rs.getString(2),
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5) ,
                                        rs.getTimestamp(6)));
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;

    

}
}
