package jdbc.day2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import project.vo2.CustomVo;

public class SelectDMLTest {

        public static void main(String[] args) {
            // 테이블 select결과를 메소드 실행하여 받으면 
            //          콘솔에서 출력,브라우저화면 출력,다른목적으로 사용할수 있으므로 따로 출력문 X

            List<CustomVo> result = selectAll_4();

            System.out.println("전체 회원 조회 결과");
            System.out.println(result);




        }



public static List<CustomVo> selectAll_4() {
    //4) 레코드 행 1개를 자바 객체와 1:1로 매핑하기 --> 레코드 행이 많다면 List 에 저장하기 
    List<CustomVo> list = new ArrayList<>();

    Connection connection = OracleConnectionUtil.getConnection();
    String sql ="select * from tbl_custom";
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();


         while(rs.next()){
           CustomVo vo =new CustomVo(rs.getString(1),
                                     rs.getString(2), 
                                     rs.getString(3), 
                                    rs.getInt(4),
                                    rs.getDate(5));   

           list.add(vo);
        }
        

    } catch (SQLException e) {
        System.out.println("select 쿼리 실행 예외 발생"+ e.getMessage());
        e.printStackTrace();
    }
    return list;            //select 조회 결과를 자바 객체 List 와 매핑하여 리턴. 

}











public static void selectAll_3() {
    //3) 레코드 행을 자바 객체와 1:1로 매핑하기 
    //조회 결과를 자바 객체로 만들어야 프로그램을 개발할수 있다 .


    Connection connection = OracleConnectionUtil.getConnection();
    String sql ="select * from tbl_custom";


    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();


        int count=1;
        while(rs.next()){
           CustomVo vo =new CustomVo(rs.getString(1),
                                     rs.getString(2), 
                                     rs.getString(3), 
                                    rs.getInt(4),
                                    rs.getDate(5));   

           System.out.println(vo);
        }
 

    } catch (SQLException e) {
        System.out.println("select 쿼리 실행 예외 발생"+ e.getMessage());
        e.printStackTrace();
    }




}








public static void selectAll_2() {
    //2) rs.next()를 반복해서 레코드 끝까지 위치 이동 확인하기 
    Connection connection = OracleConnectionUtil.getConnection();

    String sql ="select * from tbl_custom";
    
    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            int count=1;
            while(rs.next()){
                System.out.println("====================================");
                System.out.println("no : " + (count++)+ "번째 레코드");
                System.out.println(rs.getString("custom_id"));    
                System.out.println(rs.getString("name"));    
                System.out.println(rs.getString("email"));    
                System.out.println(rs.getInt("age"));    
                System.out.println(rs.getDate("reg_date"));    
                System.out.println(rs.getTimestamp("reg_date"));    

            }
            System.out.println("====================================");
            System.out.println("total : " + (--count)+ "번째 레코드");

        } catch (SQLException e) {
            System.out.println("select 쿼리 실행 예외 발생"+ e.getMessage());
            e.printStackTrace();
        }

}

//1)rs.next()로 결과 행 집합안에서 레코드 위치 파악
public static void selectAll_1() { 
         Connection connection = OracleConnectionUtil.getConnection();

         String sql ="select * from tbl_custom";
         try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

                ResultSet rs = pstmt.executeQuery();        //쿼리실행후 결과행 집합을 처리하는 인터페이스 :ResultSet
                                                            //next 메소드는 rs객체의 다음행을 접근 할수 있게 포인터를 이동합니다. 
                rs.next(); // 결과 행집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야하는 메소드
                System.out.println(rs.getString(1));    // 1번 인덱스 컬럼값 가져오기
                System.out.println(rs.getString(2));    // 2번 인덱스 컬럼값 가져오기
                System.out.println(rs.getString(3));    // 3번 인덱스 컬럼값 가져오기
                System.out.println(rs.getInt(4));    // 4번 인덱스 컬럼값 가져오기
                System.out.println(rs.getDate(5));    // 5번 인덱스 컬럼값 가져오기
                System.out.println(rs.getTimestamp(5));    // 5번 인덱스 컬럼값 가져오기


                rs.next(); // 결과 행집합의 첫번째 행을 접근하기 위해 꼭 한번은 실행해야하는 메소드
                System.out.println(rs.getString(1));    // 1번 인덱스 컬럼값 가져오기
                System.out.println(rs.getString(2));    // 2번 인덱스 컬럼값 가져오기
                System.out.println(rs.getString(3));    // 3번 인덱스 컬럼값 가져오기
                System.out.println(rs.getInt(4));    // 4번 인덱스 컬럼값 가져오기
                System.out.println(rs.getDate(5));    // 5번 인덱스 컬럼값 가져오기
                System.out.println(rs.getTimestamp(5));    // 5번 
                
        } catch (SQLException e) {
                System.out.println("select 쿼리 실행 예외 발생"+ e.getMessage());

        }{

         }
         
    }
}
