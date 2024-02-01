package jdbc.day4;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import jdbc.day1.OracleConnectionUtil;
import oracle.jdbc.driver.OracleConnection;

public class StoredProcTest {
    
    public static void main(String[] args) {
        // exec_max_customer();
        exec_money_of_day();
    }

    private static void exec_money_of_day(){
        System.out.println("고객ID 와 날짜를 입력하면 총 구매금액을 조회합니다.");
        System.out.println("고객ID 입력 ___");
        String customid = System.console().readLine();
        System.out.println("구매날짜 입력 ___");
        String buydate = System.console().readLine();

        Connection connection = OracleConnectionUtil.getConnection();
        String sql = "{call money_of_day(?,?,?)}";

        try (
            CallableStatement cstmt = connection.prepareCall(sql)            
            ) {
                //프로시저 IN 매개변수 전달
                cstmt.setString(1, customid);
                cstmt.setString(2, buydate);

                //프로시저 OUT 매개변수 타입 설정
                cstmt.registerOutParameter(3, Types.NUMERIC);
                cstmt.executeUpdate();

                String result = String.format("%s 고객님\n구매날짜 : %s\n총 구매금액 : %,8d", customid,buydate,cstmt.getInt(3));
                System.out.println(result);

        } catch (Exception e) {
                System.out.println("money_of_day 프로시저 실행 예외 발생 "+e.getMessage());
        }


    }





    private static void exec_max_customer(){

        Connection connection = OracleConnectionUtil.getConnection();
        String sql ="{call max_custom(?,?)}"; //프로시저 sql 형식 : "{call 프로시저이름 (매개변수 ?,?....)}"

        try (
                CallableStatement cstmt= connection.prepareCall(sql); 
                // 프로시저 싱행 및 관리 인터페이스 CallableStatement의 메소드 prepareCall 로 객채 생성하기 

        ) {
            //프로시저 실행 결과 out 파라키터 1번 인덱스의 오라클 데이터 타입 지정하기 - 고객이름
            cstmt.registerOutParameter(1, Types.VARCHAR);
            //프로시저 실행 결과 out 파라키터 2번 인덱스의 오라클 데이터 타입 지정하기 - 고객나이
            cstmt.registerOutParameter(2, Types.NUMERIC);
            cstmt.executeUpdate();
            

            //프로시저 실행결과 out 파라미터 값은  cstmt 객체에 저장됩니다. 
            //일반사용자가 원하는 정보 ↓ 
            System.out.println("구매 수량이 가장 많은 고객 정보 조회한 결과입니다.");
            // 인덱스 1번 out 실행 결과값 가져오기
            System.out.println("고객 이름:"+cstmt.getString(1));
            // 인덱스 2번 out 실행 결과값 가져오기
            System.out.println("고객 나이:"+cstmt.getInt(2));
            
        } catch (SQLException e) {
            System.out.println("max_customer 프로시저 실행 예외" +e.getMessage());
        }
    }

    



}
