package basic.day4;

import basic.day1.string;

public class A24StaticMethod {
    // 프로그램을 실행시키는 main 이 static이므로 여기서 같이 사용할 수 있는
    // 다른 static 메소드 연습을 해봅시다.
                        //메소드를 만드는 목적은 처리 기능을 main 에서 따로 분리 하기 위함.(구조화-간결한코딩)
                        //한번 만들어진 메소드는 여러번 필요시 호출해서 실행시킬수 있다.(재사용)
                        //메소드는 클래스에 구성요소

    // 1) 인자값 없는 메소드
    // 2) 인자가 1개 있는 메소드
    // 3) 인자가 2개 있는 메소드 //인자로 선언된 () 안에 변수는 지역변수

    // 4) 리턴값이 정수인 메소드
    // 5) 리턴값이 boolean인 메소드
    // 6) 리턴값이 string인 메소드
    // 7) 리턴값이 char 인 메소드
    public static void main(String[] args) {
        argumentTest(); // 메소드 호출. 이름과 형식이 맞는 메소드를 찾아서 실행함.+
        argumentTest(123);
        argumentTest(123, 456); // 123,456은 실매개변수!!!!
        // 메소드가 실행될 때 실매개 변수값이 형식매개 변수로 전달, 저장됩니다.

        int a = 100, b = 200;
        argumentTest(a, b); // a,b 도 실매개변수!!!!!

        System.out.println("resultBooleanTest() 호출: "+resultBooleanTest());
        System.out.println("resultIntTest() 호출 :"+resultIntTest());
        System.out.println("resultStringTest() 호출 :"+resultStringTest());
        System.out.println("resultCharTest() 호출: "+resultCharTest());



        System.out.println("add(1,2,3)호출 : "+add(1,2,3));
        System.out.println(String.format("add(1.0,2.0,3.0호출 : %f ",add(1.0,2.0,3.0)));
        System.out.println(String.format("add(100000000,200000000,300000000)호출 : %,d ",add(1000000000l,2000000000l,3000000000l)));
        



    }

    // 1) 인자값 없는 메소드
    public static void argumentTest() {
        System.out.println("인자값이 없는 메소드.");
    }

    // 2) 인자가 1개 있는 메소드
    public static void argumentTest(int i) { // int i 는 형식 매개변수!!!!
        System.out.println("인자가 1개 입니다. : " + i);
    }

    // 3) 인자가 2개 있는 메소드
    public static void argumentTest(int i, int j) {
        System.out.println("인자가 2개 입니다. : " + i + "," + j);
        System.out.println("i+j=" + (i + j));
    }

    // 4) 리턴값이 정수인 메소드
    public static int resultIntTest() {
        return 999;
    }

     // 5) 리턴값이 boolean인 메소드
    public static boolean resultBooleanTest() {
        return true;
    }

    // 6) 리턴값이 string인 메소드
    public static String resultStringTest() {
        return "Hello";
    }

    // 7) 리턴값이 char 인 메소드
    public static char resultCharTest() {
        return 'A';
    }



    //인자와 리턴값을 모두 갖는 메소드 

    public static int add(int a, int b, int c){
        return a+b+c;
    }

    public static double add(double a, double b, double c){
        return a+b+c;
    }
    public static long add(long a, long b, long c){
        return a+b+c;
    }

    



}
