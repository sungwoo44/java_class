package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {
        //A25MySampleMethod 클래스에서 만든 메소드 사용하기 

        int result = A25MySampleMethod.sum1ToN(10);
        System.out.println(result);
        //A25MySampleMethod.checkJumsu(67);// 메소드가 private으로 정의되면 다른 크랠스에서 사용불가.

        //자바 (또는 다른 프로그래밍언어)로 코딩할떄
        //1. 자바에서 제공하는 크랠스와 메소드를 잘 활용하기 
        //2. 필요에 따라 여러분은 개발자가 직접 잘 만들어서 사용하기 

        Scanner sc = new Scanner(System.in); 
        
        System.out.println("시작값 입력하세요 >>>");
        int start =sc.nextInt();
        
        System.out.println("마지막값 입력하세요 >>>");
        int end =sc.nextInt();

        System.out.println(start+"~"+end+ "까지의 곱하기 결과:"+ A25MySampleMethod.multiplyMToN(start, end));

        

    }
}
