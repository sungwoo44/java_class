package basic.day3;

import basic.day1.string;

public class A17ForWhileExam {
    public static void main(String[] args) {
        // 반복문 for가 활용되는 예시
        String message = "Hello, World~ Hoi";

        System.out.println("1.문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
           // System.out.print(" " + temp);
            System.out.println("i=" + i + ",문자=" + temp);
        }


        int k=0;
        //while문으로 변경 해보기 
        while (k<message.length()) {
            char temp= message.charAt(k);
            System.out.println("k=" + (k++) + ",문자=" + temp);
            //k++;
            
        }

        // 문자열 길이만큼 반복문 실행하면서 if 조건문으로 문자열 검사하기

        System.out.println("\n 2. 문자열 길이 만큼 반복문 실행하면서 if 조건문으로 문자열 검사하기");
        System.out.println("\t 문자열에서 알파펫 o 의 갯수를 구해봅시다.");

        int count = 0;
        char searchWord= 'o';
         for (int i = 0; i < message.length(); i++) {
            if(message.charAt(i)==searchWord){
                count ++;
            }
            
           
        }System.out.print(String.format(" 문자열 %s 안에 찾는문자 %c 는 %d개 있습니다. ",message,searchWord,count));
    }
}
