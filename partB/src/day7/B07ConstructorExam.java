package day7;

import java.util.Scanner;

/*자바 클래스의 생성자를 이용해 메소드 오버로딩 알아보기 
 * 
 *  - String 클래스
 *  Scanner 클래스의 생성자와 메소드 확인하기 
 * 
 */
public class B07ConstructorExam {
    public static void main(String[] args) {
        // 문자열 리터럴을 message 변수로 참조     
        String message = "Hello~"; 
        String temp = "Hello~";

        //문자열 객체 생성하기 
        //1) 메소드 오버로딩: 메소드 이름과 리턴타입이 같으면서 리턴타입과 인자의 개수와 형식이 다르게 정의됨.
        String str1 = new String();                                                 //생성자 인자 없음
        String str2 = new String("Hello~");                                 // 생성자 인자가 문자열 리터럴
        String str3 = new String(new char[]{'h','e','l','l','o','~'});              // 생성자 인자가 문자 배열


        System.out.println("new 연산으로 생성된 String  객체 출력해보기");
        System.out.println("str1 = "+ (str1));
        System.out.println("str2 = "+ (str2));
        System.out.println("str3 = "+ (str3));
        
        //2) 문자열 리터럴 특징 : 문자열 내용이 같다면 메모리에 새로 저장하지 않음.
        //      ㄴ   message 가 참조하는 "Hello~" 와 동일한 리터럴을 temp 가 참조할때,
        //           "Hello~"를 또 저장하지 않고 이미 저장되어 있는 것을 참조.
        //              so, message == temp --> true   
        System.out.println("message == temp? "+ (message == temp));  // 참조값 비교!         true!!
        System.out.println("message == str2? "+ (message == str2));  //'new' 연산으로 생성된 객체는 메모리를 새로 할당!     false!!!

        // 문자열 내용 비교 : equals 메소드
        System.out.println("message.equals(temp)"+message.equals(temp)); //내용비교!
        System.out.println("message.equals(str2)"+message.equals(str2));

        
        //다른 클래스 생성자

        Scanner sc = new Scanner(System.in); // Inputstream 클래스로 만들어진 객체 System.in 을 생성자 인자로 하여 객체를 생성
                                            // System.in은 키보드 입력을 원초적인 방식으로 처리함. So
                                            // 키보드 입력값을 다양하게 처리하기 위해 Scanner 클래스를 사용

        int num = sc.nextInt();             // 입력값을 정수 형식으로 변환
        double pi = sc.nextDouble(); 
                                            //          실수 형식으로 변환
        sc.nextLine();                      //          키보드 입력을 저장하는 버퍼에서 실수입력의 숫자 뒤에 엔터가 남아있으므로 **** 그래서 너무 불편하니깐 우리 이걸로 써볼까???
        String name = sc.nextLine();        //          문자열로 변환

        System.out.println(num);
        System.out.println(pi);
        System.out.println(name);


        System.out.println("키보드 입력을 저장하는 버퍼에서 실수입력의 숫자 뒤에 엔터가 남아있으므로(nextInt,nextLine) **** 그래서 너무 불편하니깐 우리 이걸로 써볼까???");
        System.out.println("nextInt, nextLine 대신 ======> ");

        System.out.print("정수입력.....");
        temp = sc.nextLine();
        num = Integer.parseInt(temp);               // 문자열을 int 로 변환하는 메소드 사용.
        System.out.print("실수입력.....");
        temp = sc.nextLine();
        pi = Double.parseDouble(temp);              // 문자열 do7uble 로 변환하는 메소드 사용.
        System.out.print("문자열입력.....");
        name = sc.nextLine();

        System.out.println(num);
        System.out.println(pi);
        System.out.println(name);


    }
}
