package jdbc.day1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.Scanner;

import project.vo2.CustomVo;

public class InsertDMLTest {
    public static void main(String[] args) {

       System.out.println("쇼핑몰 [회원가입] welcome~");
       System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");
       System.out.println("아이디를 입력하세요! :____");
       String customId = System.console().readLine();
       System.out.println("이름을 입력하세요! :____");
       String name= System.console().readLine();
       System.out.println("이메일을 입력하세요! :____");
       String email=System.console().readLine();
       System.out.println("나이를 입력하세요! :____");
       int age=Integer.parseInt(System.console().readLine());

       CustomVo vo = new CustomVo(customId,name, email, age, null);
       insert(vo);
       //정리 : tbl_custom 테이블은 회원정보를 저장합니다. 
       //       개발 프로그램은 '회원가입(insert)','로그인(select)','회원정보수정(update)','회원탈퇴(delete)'
       //          tbl_custom 테이블에 대해 갖게됩니다. 
       //          --> 필요한 기능에 처리해야할 sql 실행 메소드 DAO(Data Access Object) 클래스에 모두 모아서 만듭니다. 
    }

    //최종적으로 사용될 insert 메소드
    public static void insert(CustomVo vo){// 메소드 실행 인자는 insert 매개변수에 전달될 값
        Connection conn = OracleConnectionUtil.getConnection();
        if(conn != null) System.out.println("데이터베이스 연결 성공!");

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date)"+  
                "values(?,?,?,?,sysdate)";
               

                try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
                        pstmt.setString(1, vo.getCustomId());
                        pstmt.setString(2, vo.getName());
                        pstmt.setString(3, vo.getEmail());
                        pstmt.setInt(4, vo.getAge());

                        pstmt.executeUpdate();
                

        } catch (Exception e) {
            System.out.println("SQL 실행 예외 발생 :\n\t" +e.getMessage());
        }finally{
            OracleConnectionUtil.close(conn);
        }

    }


    //2) insert SQl 파라미터로 입력 예시 
    public static void param_data(){
        Connection conn = OracleConnectionUtil.getConnection();
        if(conn != null) System.out.println("데이터베이스 연결 성공!");

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date)"+  
                "values(?,?,?,?,sysdate)";
                // PreparedStatement는 매개변수를 ?로 표기하고 sql 을 미리 컴파일합니다.
                //    매개변수 ?에  대입되는(바인딩) 값은 sql execute 메소드 이전에 설정합니다.

                try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
                        // ?는 순서대로 인덱스를 갖습니다. 시작값1
                        // 응용프로그램에서 매개변수에 저장될 값은 사용자 입력값!
                        pstmt.setString(1, "sana");
                        pstmt.setString(2, "최사나");
                        pstmt.setString(3, "sana@naver.com");
                        pstmt.setInt(4, 26);

                        pstmt.executeUpdate();  // 리턴값 int는 반영된 행의 개수를 리턴.

                

        } catch (Exception e) {
            System.out.println("SQL 실행 예외 발생 :\n\t" +e.getMessage());
        }finally{
            OracleConnectionUtil.close(conn);
        }
    }



    //1) insert  데이터 값이 고정된 예시 
    public static void fixed_data(){
        
        Connection conn = OracleConnectionUtil.getConnection();
        if(conn != null) System.out.println("데이터베이스 연결 성공!");

        String sql = "insert into tbl_custom(custom_id,name,email,age,reg_date)"+  
                "values('nayeon3','박나연3','na@gmail.com',28,sysdate)";

        // auto close 위한 try 형식 - pstmt.close()필요하므로 try-with -resources tkdyd
        try (PreparedStatement pstmt = conn.prepareStatement(sql)){
            
           // pstmt.execute();        //sql 실행 메소드
            pstmt.executeUpdate();  // 리턴값 int는 반영된 행의 개수를 리턴.

        } catch (Exception e) {
            System.out.println("SQL 실행 예외 발생 :\n\t" +e.getMessage());
        }finally{
            OracleConnectionUtil.close(conn);
        }
    }
}
