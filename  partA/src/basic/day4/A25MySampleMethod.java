package basic.day4;

public class A25MySampleMethod {
    // A25 소스파일은 구들드라이브에 올려주세요.
    // A22번 1~5번 을 각각 메소드로 정의해 보기 -메소드안에서 출력문 만들지 않기
    // 1) sum1ToN 2)multiply1ToN 3) sumMToN 4) multiplyMToN 5)multiplyNof2
    // 6) 구구단 출력하는 메소드 리턴은 void. printGuguDan
    public static void main(String[] args) {

        System.out.println("sum1ToN(5):" + sum1ToN(5));
        System.out.println("multiply1ToN(5):" + multiply1ToN(5));
        System.out.println("sumMToN(5,10):" + sumMToN(5, 10));
        System.out.println("multiplyMToN(5,10):" + multiplyMToN(5, 10));
        System.out.println("multiplyNof2(5):" + multiplyNof2(5));
        printGuguDan();
        int result1 = addMToN(2,5);
        int result2 = checkJumsu(67);


    }

    private static int checkJumsu(int i) {
        return 0;
    }

    private static int addMToN(int i, int j) {
        return 0;
    }

    public static int sum1ToN(int a) {

        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        return sum;

    }

    public static long multiply1ToN(long a) {

        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;

    }

    public static int sumMToN(int a, int b) {

        int sum = 0;
        for (int i = a; i <= b; i++) {
            sum += i;
        }
        return sum;

    }

    public static long multiplyMToN(long a, long b) {

        long result = 1;
        for (long i = a; i <= b; i++) {
            result *= i;
        }
        return result;

    }

    public static long multiplyNof2(long a) {

        long result = 1;
        for (long i = 1; i <= a; i++) {
            result *= 2;
        }
        return result;
    }

    public static void printGuguDan() {

        for (int j = 1; j < 10; j++) {
            System.out.println(String.format("======%d 단======", j));
            for (int i = 1; i < 10; i++) {
                System.out.println(String.format("%3d x %3d = %3d", j, i, i * j));
            }

        }

    }

}
