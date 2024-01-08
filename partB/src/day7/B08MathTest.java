package day7;


/*
 * 자바의 기본 패키지는 java.lang입니다.
 * 지금 테스트할  Math 클래스는 java.lang에 속하여 import 필요없음
 * Scanner 클래스와 같이 java.util  등 다른 패키지의 속한 클래스는 import 를해야함.
 *          ㄴ import 를 통해서 이 프로그램에서 사용할 클래스를 메모리에 올림.
 * 
 *   Math 클래스 메소드 오버로딩 확인하기
 */
public class B08MathTest {
    public static void main(String[] args) {
        System.out.println("1.최대값 max, 최소값 min 구하기");
        System.out.println("Math.max(56,12) ="+ Math.max(56,12));               // 인자와 리턴타입이 정수
        System.out.println("Math.max(56.34,99.123)="+ Math.max(56.34,99.123)); // 인자와 리턴타입이 실수
        int min = Math.min(45, 56);
        //double dmin = Math.min(45, 56);   //자동 캐스팅
        double dmin = Math.min(56.78, 111.44);
        //int imin = (int)Math.min(56.78, 111.44);      //강제 캐스팅
        
        System.out.println("min = "+min);
        System.out.println("dmin = "+dmin);


        System.out.println("메소드를 이용해 정수 3개 최대,최소값 구하기");
        System.out.println("Math.max(Math.max(56, 12),12)"+ Math.max(123,Math.max(56, 34)));  
        System.out.println("Math.min(Math.min(56, 12),12)"+ Math.min(Math.min(56, 34),12));  


        //  Math  클래스에는 기본 수학 공식을 해결하는 메소드를 제공함
        // Static 메소드는 클래스의 객체를 생성하지 않고 바로 클래스 이름으로 실행되는 메소드 
    
        
    }
}
