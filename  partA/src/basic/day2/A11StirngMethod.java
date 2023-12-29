package basic.day2;

public class A11StirngMethod {
    public static void main(String[] args) {
        //메소드는 이름뒤에 괄호가 따라나온다~! and 괄호안의 값들은 메소드 처리에 필요한 입력데이터(메소드의 인자! = argument)
        //                                                      메소드가 처리한 결과는 출력데이터 (리턴(반환)값)
        String message = "Hello World";
        //1. 메소드 괄호안에 아무것도 없는 것.
       System.out.println("message.length() : "+message.length());
       System.out.println("message.isEmpty() : "+message.isEmpty());
       System.out.println("message.toUpperCase() : "+message.toUpperCase());
       System.out.println("message.toLowerCase() : "+message.toLowerCase());

        //2. 메소드 괄호안에 정수 1개를 쓰는 것.
        System.out.println("message.charAt() : "+message.charAt(0));
        System.out.println("message.charAt() : "+message.charAt(1));
        System.out.println("message.charAt() : "+message.charAt(2));
        System.out.println("message.charAt() : "+message.charAt(3));

        //3. 메소드 괄호안에 문자열 1개를 쓰는 것. 
        System.out.println("message.concat() : "+message.concat("\"message\""));
        System.out.println("message.startsWith() : "+message.startsWith("Hell"));
        System.out.println("message.startsWith() : "+message.startsWith("hell"));
        System.out.println("message.endsWith() : "+message.endsWith("world"));
        System.out.println("message.endsWith() : "+message.endsWith("orld"));
        System.out.println("message.indexOf() : "+message.indexOf(3)); // 단어가 없으면 결과값은 -1
        System.out.println("message.indexOf() : "+message.indexOf("world"));
        System.out.println("message.indexOf() : "+message.indexOf("World"));


        //4. 메소드 괄호안에 정수 2개를 쓰는 것. 
        System.out.println("message.substring() : "+message.substring(0,5));
        System.out.println("message.substring() : "+message.substring(1,5));
        System.out.println("message.substring() : "+message.substring(3,4));
        System.out.println("message.substring() : "+message.substring(5,8));

        message= "hello";
        System.out.println("message.equals(): "+message.equals("hello"));
        System.out.println("message.equals(): "+message.equals("Hello"));

        //5. 메소드 괄호안에 문자 또는 문자열 2개를 쓰는 것.
        System.out.println("message.replace : "+message.replace("ll", "**"));
        
    }
        // 리턴 값 형식을 기준으로 정리하기 
        //boolean:      equals(),endsWith(),isEmpty()
        //String:       concat(),replace()
        //int:          indexOf(),length(),hashCode(),compareTo()
        //char:         charAt()

        /* 
            1) 메소드의 리턴타입에 따라 결과를 저장할 변수를 일치하는 형식으로 선언하기 
            String temp = message.toUpperCase().substring();

            2) 문자열  리턴값으로 또 메소드 실행할수 있음

        .     int len = message.length();
              char ch = messgage.charAt();
         */
}
