package basic.day2;

import basic.day1.string;

public class A10StringVariable {
    public static void main(String[] args) {
       
        //String 은 문자열 : 문자('')의 집합
        //char imo1 ='😁'; //char 2바이트 이모지는 4바이트로 저장됨
        String imo2 ="😄"; //char 2바이트 이모지는 4바이트로 저장됨 & 이모지는 문자열로 저장한다. 

        String message = "Wellcome to koreaIT";
        System.out.println("메세지 : "+ message+"의 길이"+message.length());
        System.out.println(imo2);

        message = "        welcome~  java   world!!!!";
        System.out.println("메세지 : "+ message+"의 길이"+message.length());

        //String 으로 선언됩 변수는 '객체'입니다.
        //자바 String의 중요한 메소드 7가지씩 조사해서 테스트 해보기 
        String a = "123";
         
        System.out.println("chars(): "+message.chars());
        
        System.out.println("indexOf(): "+message.indexOf(5));
      
        System.out.println("stubstring(): "+message.substring(2,9));
       
        System.out.println("concat()"+message.concat("Today i wanna talk about~~blahblah"));
    
        System.out.println("isBlank(): "+message.isBlank());
       
        System.out.println("toUpperCase(): "+message.toUpperCase());
        
        System.out.println("trim(): "+message.trim());
        
        System.out.println("valueOf(): "+message.valueOf(1));
       
        System.out.println("getBytes(): "+message.getBytes()); 
        
        System.out.println("hashCode(): "+message.hashCode());

        
    }
}
