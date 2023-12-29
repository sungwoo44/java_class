package basic.day2;

public class A06PrefixPostfix_minus_Test {

    public static void main(String[] args) {
        int start = 100;

        System.out.println("== postfix 확인 (출력 후에 -1)==");
        System.out.println(start--);
        System.out.println(start--);
        System.out.println(start--);
        System.out.println(start--);
        System.out.println(start--);

        System.out.println(); // 줄 띄우기
        System.out.println(); // 줄 띄우기

        start = 100;
        System.out.println("== prefix 확인 (-1 후에 출력) ==");
        System.out.println(--start);
        System.out.println(--start);
        System.out.println(--start);
        System.out.println(--start);
        System.out.println(--start);
    }
}
