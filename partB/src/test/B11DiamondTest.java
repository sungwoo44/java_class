package test;

import day7.Diamond;


public class B11DiamondTest {
    public static void main(String[] args) {

        // Diamond 클래스에 extends Shape 외에는 코드가 없음.  but 아래 메소드가 실행가능함.
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 이름 : "+ diamond.getShapeName());
        System.out.println("다이아몬드 높이 : "+ diamond.getHeight());
        System.out.println("다이아몬드 너비 : "+ diamond.getWidth());
        System.out.println("다이아몬드 넓이 : "+ diamond.calculateArea());
        diamond.print();

        //  상속받은 필드값 저장하는 setter 생성가능한지 확인!


        //접근 한정자 확인하기! 모두오류!!!!
        

        // diamond.accessModifier =0;                                      //B11DiamondTest 는 상속받은 자식 클래스가 아님.
        // diamond.etc="접근한정자테스트";                                   // Shape 과 같은 패키지가 아님.
        // System.out.println("변경된 내용 확인 :"+diamond.accessModifier);
        // System.out.println("변경된 내용 확인 :"+diamond.etc);
        // diamond.border=4;
    }
}
