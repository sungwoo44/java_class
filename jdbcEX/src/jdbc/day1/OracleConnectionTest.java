package jdbc.day1;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnectionTest {
    

    public static void main(String[] args) {
        //1) ojdbc11.jar 라이브러리 프로젝트 추가
         Connection conn = null;
         String driver ="oracle.jdbc.driver.OracleDriver";
         String url="jdbc:oracle:thin:@//192.168.30.25:1521/XE";        //실무에서는 localhost는 서버의 ip가 되겠죠?!!
        //  String url="jdbc:oracle:thin:@//localhost:1521/XE";        //예도 가능
         String user = "C##idev";
         String password = "1234";

         try {
            //2) ojdbc.jar 라이브러리에 포함된 드라이버 클래스를 메모리에 로드
            Class.forName(driver); //런타임 시점에 지정된 클래스 이름 로드
                                                //ClassNotFoundException 체크드 익셉션 -> 처리 필요.

            //3)  Connetcion  구현 객체를 생성 -DriverManger는 드라이버 관리하는 유틸리티
            conn = DriverManager.getConnection(url, user, password);    
                                                //SQLException 예외 처리가 필요 
            //Connection 은 인터페이스에 대한구현은 드라이버에 따라 정해짐.
            System.out.println("데이터베이스 연결 객체"+conn);
            if(conn != null){
                System.out.println("Connection  객체의 구현 클래스:"+ conn.getClass().getName()); //Connection 구현 클래스 이름 확인
                                                                                //oracle.jdbc.driver.T4CConnection는 오라클의 Connection 구현 클래스 
                System.out.println("오라클 데이터베이스 연결 성공");
            }
        }catch(Exception e){
                System.out.println("오라클 데이터베이스 연결 실패");
                System.out.println("예외 발생 : " + e);

         }finally{

            try {
                if(conn !=null)conn.close();
            } catch (Exception e) {}
         }
         
    }
}
