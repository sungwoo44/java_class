package day6;

public class random {
    public static void main(String[] args) {


        int start=11;
        int end=99;
        System.out.println(" 난수(컴퓨터가 만들어주는 임의 값) - random");
        System.out.println(" 난수값을 만들어주는 방법은 Math.random()");
        System.out.println(" 0~1 사이의 double 실수를 무작위로 만들어줍니다.");
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + Math.random());
        System.out.println("Math.random() = " + (int)(Math.random()*(end-start+1)));
        System.out.println("Math.random() = " + (int)(Math.random()*(end-start+1))+start);
        // 0 < 난수 < 1 => 로또 값처럼 1 <= 로또번호 <= 45
        // 원래 난수값 범위에 *45를 하고 0 < 난수*45 < 45
        // 그 값에 다시 +1 하면 됩니다. 1 < 난수*45+1 < 46
        // 난수의 범위를 start ~ end 범위로 조정하려면
        // (int)(Math.random()*(end-start+1))+start
    }
}
