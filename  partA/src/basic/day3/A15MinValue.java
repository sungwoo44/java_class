package basic.day3;

public class A15MinValue {
    public static void main(String[] args) {
        int n1 = 5;
        int n2 = 4;
        int n3 = 3;
        int min = 0;

        // 내가 짠코드
        if (n1 < n2) {
            System.out.println("n1<n2");
            min = n1;
            System.out.println("최소값은 : " + ((n3 < n1) ? (min = n3) : (min = n1)) + "입니다.");
        } else {
            System.out.println("n2<n1");
            min = n2;
            System.out.println("최소값은 : " + ((n3 < n2) ? (min = n3) : (min = n2)) + "입니다.");
        }

        // 선생님 if문

        if (n1 < n2) { // 참/거짓 각각 실행명령어가 다르다.
            min = n1;
        } else {
            min = n2;
        }
        if (min > n3) { // 참일때만 실행하는 명령어
            min = n3;
        }
        System.out.println("최소값은 : " + min + "입니다.");

        // 삼항연산자

        min = 0; // 초기화
        min = (n1 < n2 ? n1 : n2);
        min = (min > n3 ? n3 : min);
        System.out.println("최소값은 : " + min + "입니다.");

    }
}
