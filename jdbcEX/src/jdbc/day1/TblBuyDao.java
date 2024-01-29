package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //2)구매취소
    public void buyCancel(int vo){
        String sql=" DELETE FROM TBL_BUY tc WHERE BUY_IDX = ?";

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){       
            pstmt.setInt(1,vo );
            pstmt.executeUpdate();

    }catch (SQLException e){
        //close 는 자동
    }

    }

    //3)구매수량 변경 
    public void changeQuntity(BuyVo vo){
        String sql="UPDATE TBL_BUY SET CUSTOMID =?,PCODE =?,QUANTITY =? WHERE BUY_IDX =?"; 
                

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
                    pstmt.setString(1, vo.getCustomid());
                    pstmt.setString(2, vo.getPcode());
                    pstmt.setInt(3, vo.getQuantity());
                    pstmt.setInt(4, vo.getBuy_idx());

            //매개변수 바인딩
            pstmt.executeUpdate();
    }

    //4)구매 종료


}
