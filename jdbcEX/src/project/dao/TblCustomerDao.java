package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import oracle.net.nt.ConnOption;
import project.vo.CustomVo;

public class TblCustomerDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원가입
    public void join(CustomVo vo) {

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date)" +
                "values(?,?,?,?,sysdate)"; // insert
        try ( // auto close
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());
            // 매개변수 바인딩
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // close 는 자동
        }
    }

    // 회원정보수정
    public void modify(CustomVo vo) {
        String sql = "UPDATE TBL_CUSTOM SET EMAIL =?,age=? WHERE CUSTOM_ID =?";

        try ( // auto close
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());

            // 매개변수 바인딩
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // close 는 자동
        }

    }

    // 회원 탈퇴
    public void delete(String custom_Id) {
        String sql = " DELETE FROM TBL_CUSTOM tc WHERE custom_id = ?";

        try ( // auto close
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, custom_Id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            // close 는 자동
        }

    }
//          ★pk 조회결과 행의 개수는 ? 1개 or 0개  rs.next()도 한개만 돌리면되네
    // 회원 정보조회 select * from tbl_custome where custom_id=?
    //                  조회결과가 있다면 only 1개!!!

    public CustomVo getCustomVo(String customerId) {
        
        CustomVo vo = null;
        String sql = "select * from tbl_custom where custom_id=?";
        
        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){ // 조회결과가 있으면 true, 없으면 false
                //할일 : 객채 만들기 vo 변수에 참조시키기 
                 vo =new CustomVo(rs.getString(1),
                                    rs.getString(2), 
                                    rs.getString(3), 
                                    rs.getInt(4),
                                    rs.getDate(5));   
            };
            
            

    } catch (SQLException e) {
        System.out.println("select 쿼리 실행 예외 발생" + e.getMessage());
        e.printStackTrace();
    }

        return vo;

    }

    // 관리자를 위한 기능: 모든 회원정보 조회 select * from tbl_custome
    public List<CustomVo> allCustom() {

        List<CustomVo> list = new ArrayList<>();
        String sql = "select * from tbl_custom";

        
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
            ) {
                ResultSet rs = pstmt.executeQuery();

                 while (rs.next()) { 
                    list.add(new CustomVo(rs.getString(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getInt(4),
                                      rs.getDate(5)));
                }

        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }
}
