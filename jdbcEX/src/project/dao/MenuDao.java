package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.vo.MenuVo;

public class MenuDao {
    public static final String URL="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";

private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    //1) 특정 Mcode에 대한 상품 목록 보여주기
    public List<MenuVo> selectByMcode(String Mcode){
        List<MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_menu  WHERE mcode = ? order by mname";
        

        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, Mcode);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MenuVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getInt(3),
                                    rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectByMcode 예외 발생" + e.getMessage());
        }
        return list;
    }
    //2) 특정 Mname에 대한 상품 목록 보여주기 & 상품명 유사(like) 검색
    public List<MenuVo> selectByMname(String Mname){
        List<MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_menu  WHERE mname like '%'||?||'%' order by mname";
        

        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1, Mname);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MenuVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getInt(3),
                                    rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectByMname 예외 발생" + e.getMessage());
        }
        return list;
    }
    //3) 특정 가격에 대한 상품 목록 보여주기
    public List<MenuVo> selectByMprice(int mprice){
        List<MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_menu  WHERE mprice = ? order by mname";
        

        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setInt(1, mprice);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new MenuVo(rs.getString(1), 
                                    rs.getString(2), 
                                    rs.getInt(3),
                                    rs.getString(4)));
            }
        } catch (SQLException e) {
            System.out.println("selectByMprice 예외 발생" + e.getMessage());
        }
        return list;
    }

    public Map<String, Integer> getMpriceTable(){
        Map<String, Integer> map = new HashMap<>();
        String sql ="SELECT mcode,mprice from tbl_menu";

        try (
            Connection conn = getConnection();
            PreparedStatement psmt = conn.prepareStatement(sql)
        ) {
            ResultSet rs = psmt.executeQuery();
            while(rs.next()){
                map.put(rs.getString(1),rs.getInt(2));            }
            
        } catch (SQLException e) {
            System.out.println("getMPriceTable 예외발생 : "+e.getMessage());
            e.printStackTrace();
        }
        return map;

    }
    

}
