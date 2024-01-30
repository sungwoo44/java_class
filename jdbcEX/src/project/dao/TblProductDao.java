package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.vo.CustomVo;
import project.vo.ProductVo;

public class TblProductDao {

    public static final String URL="jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "1234";
    

    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    //1) 특정 타케고리에 대해 상품 목록 보여주기 
    public List<ProductVo> selectByCategory(String category){
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT tp WHERE CATEGORY = ? order by pname";
        
        try (
                Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)
            ) {
                pstmt.setString(1,category);
                 ResultSet rs = pstmt.executeQuery();
                   while (rs.next()) {  //  조회결과는 n행 가능성 예측
                    list.add(new ProductVo(rs.getString(1),
                                      rs.getString(2),
                                      rs.getString(3),
                                      rs.getInt(4)));
                }
        } catch (SQLException e) {
            System.out.println("selectByCategory 예외 발생" + e.getMessage());
        }
        return list;
    }


    //2) 상품명 유사(like) 검색
    public List<ProductVo> selectByPname(String pname){
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT tp WHERE PNAME LIKE '%'||?||'%' order by category";

        try (
            Connection connection = getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)
        ) {
            pstmt.setString(1,pname);
             ResultSet rs = pstmt.executeQuery();
               while (rs.next()) { 

                list.add(new ProductVo(rs.getString(1),
                                  rs.getString(2),
                                  rs.getString(3),
                                  rs.getInt(4)
                                  ));
            }
    } catch (SQLException e) {
        System.out.println("select 쿼리 실행 예외 발생" + e.getMessage());
        e.printStackTrace();   
    }
    return list;
    }










}
