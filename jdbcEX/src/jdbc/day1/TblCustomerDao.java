package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import oracle.net.nt.ConnOption;

public class TblCustomerDao {
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    //회원가입
    public void join(CustomVo vo){

       String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date)"+  
                "values(?,?,?,?,sysdate)";    //insert
        try(    //auto close
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ){
                        pstmt.setString(1, vo.getCustomId());
                        pstmt.setString(2, vo.getName());
                        pstmt.setString(3, vo.getEmail());
                        pstmt.setInt(4, vo.getAge());
                //매개변수 바인딩
                pstmt.executeUpdate();
        }catch (SQLException e){
            //close 는 자동
        }
    }


    //회원정보수정
    public void modify(CustomVo vo){
        String sql="UPDATE TBL_CUSTOM SET EMAIL =?,age=? WHERE CUSTOM_ID =?"; 
                

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
                    pstmt.setString(1, vo.getEmail());
                    pstmt.setInt(2, vo.getAge());
                    pstmt.setString(3, vo.getCustomId());

            //매개변수 바인딩
            pstmt.executeUpdate();
    }catch (SQLException e){
        //close 는 자동
    }



    }


    //회원 탈퇴
    public void delete(String custom_Id){
        String sql=" DELETE FROM TBL_CUSTOM tc WHERE custom_id = ?";

        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){       
            pstmt.setString(1, custom_Id);
            pstmt.executeUpdate();

    }catch (SQLException e){
        //close 는 자동
    }


    }

    //회원 정보조회 select * from tbl_custome where custom_id=?
    public CustomVo geCustomVo(String customerId){
        String sql="select * from tbl_custome where custom_id=?"; 
            //----------------------------------------    









        //-----------------------------------------------
        try(    //auto close
        Connection connection = getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ){
                    pstmt.setString(1, customerId);
                

            //매개변수 바인딩
            pstmt.executeUpdate();
    }catch (SQLException e){
        //close 는 자동
    }
        
        return geCustomVo(customerId);
    }


    //관리자를 위한 기능: 모든 회원정보 조회 select * from tbl_custome 
    public List<CustomVo> allCustom(){
        
        return null;
    }
}

