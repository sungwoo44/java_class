package day7;

//대표적인 자바클래스 static  필드 확인!!

public class B13SaticFieldExam {
    public static void main(String[] args) {

        // Wrapper 클래스 : 기본 자료형을 클래스 타입, 즉 객채로 다룰수 있게 해줌.

        // Integer
        System.out.println("Integer.MAX_VALUE = " + Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
        System.out.println("Integer.SIZE = " + Integer.SIZE); // 비트 단위)(32bit)
        System.out.println("Integer.BYTES = " + Integer.BYTES); // 바이트 단위(4byte)

        // long
        System.out.println("long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("long.MIN_VALUE = " + Long.MIN_VALUE);
        System.out.println("long.SIZE = " + Long.SIZE); // 비트 단위)(64bit)
        System.out.println("long.BYTES = " + Long.BYTES); // 바이트 단위(8byte)

        // Double
        System.out.println("Double.MAX_VALUE = " + Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE = " + Double.MIN_VALUE);
        System.out.println("Double.SIZE = " + Double.SIZE); // 비트 단위)(64bit)
        System.out.println("Double.BYTES = " + Double.BYTES); // 바이트 단위(8byte)

        // Character
        System.out.println("Character.MAX_VALUE = " + Character.MAX_VALUE);
        System.out.println("Character.MAX_VALUE = " + (int)Character.MAX_VALUE);
        System.out.println("Character.MIN_VALUE = " + Character.MIN_VALUE);
        System.out.println("Character.SIZE = " + (int)Character.SIZE); // 비트 단위)(16bit)
        System.out.println("Character.SIZE = " + Character.SIZE); // 비트 단위)(16bit)
        System.out.println("Character.BYTES = " + Character.BYTES); // 바이트 단위(2byte)

        System.out.println("Shape.MAX_WIDTH = " + Shape.MAX_WIDTH);
        System.out.println("Diamond.MAX_WIDTH = " + Diamond.MAX_WIDTH);
        System.out.println("Triangle.MAX_WIDTH = " + Triangle.MAX_WIDTH);


            /*
             * 
             * 위의 필드 모두  public static final  : 영원히 고정되는 값에 대해 기호를 부여하는 '상수'의 개념 
             *                                                                                ㄴ 상수는 모두 대문자!!!
             * public : 모두공개
             * static : 객체없이 사용할 수 잇는 필드 또는 값. 정적인.. 메모리 공유영역에 모여서 저장됨.
             * final : 값 변경 불가. // 오버라이딩 불가(재정의 불가)
             */

    }
}
