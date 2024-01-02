package basic.day3;

public class A16MaxMinValue {
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 4;
        int n3 = 3;
        int min = 0;
        int max;

        if (n1 < n2) { // 참/거짓 각각 실행명령어가 다르다.
            min = n1;
            max = n2;
        } else {
            min = n2;
            max = n1;
        }
        
        // 참 또는 거짓일때 실행하는 명령문이 1개이면 {} 생략하고 간단히 한줄로 해라
        if (min > n3) { // 참일때만 실행하는 명령어
            min = n3;
        }
        if (max < n3) max = n3;
        

        System.out.println("최소값은 : " + min + "입니다.");
        System.out.println("최대값은 : " + max + "입니다.");

    }
}
