package day8;

import day7.Diamond;
import day7.Shape;
import day7.Triangle;
import test.Square;

/*
 * 모든 자바 클래스의 부모는 object 타입
 */
public class B14ObjectTest {

    public static void main(String[] args) {
        
        //Object 타입으로 업캐스팅
         Object ob1 = new String("hello!!");
         Object ob2 = new Diamond();
         Object ob3 = 3;    //3은 int정수 --> Integer 객체로 변경 --> Object로 참조.
            // 기본형 타입은 ★Wrapper★ 클래스로 객체로 변경되어 Obejct로 업캐스팅
            //                 ㄴByte, Character,Short, Integer,Long ,Float,Double

            // Object 클래스의 메소드 = 모든 자바클래스가 상속받고 있다. 
            //                       ㄴ getClass , toString, hashcode,equals
            //                       ㄴ string 클래스 equals는 object  메소드 재정의 (오버라이드)
            //                       ㄴ ** 다른자료구조 List Map Set 등은 객체(클래스) 타입만 다룹니다. **

        System.out.println("getClass는 클래스의 타입 정보를 리턴합니다.");
        //getName 은 클래스 타입정보 중 클래스 이름 리턴
        System.out.println("\tob1 getClass = " + ob1.getClass().getName());
        System.out.println("\tob2 getClass = " + ob2.getClass().getName());
        System.out.println("\tob3 getClass = " + ob3.getClass().getName());


        System.out.println("hashcode() 는 객체의 참조값(식별값)을 리턴함");
        System.out.println("\tob1.hashCode()="+ob1.hashCode()+","+Integer.toHexString(ob1.hashCode()));
        System.out.println("\tob1.hashCode()="+ob2.hashCode()+","+Integer.toHexString(ob2.hashCode()));
        System.out.println("\tob1.hashCode()="+ob3.hashCode()+","+Integer.toHexString(ob3.hashCode()));
        // 
        System.out.println("toString 확인 참조변수를 출력할때 문자열 표현값 리턴");
        System.out.println("\tob1.toString()="+ob1.toString()); // String 은 toString 재정의
        System.out.println("\tob2.toString()="+ob2.toString()); // Object toString 의 기본값 출력
        System.out.println("\tob3.toString()="+ob3.toString()); // Integer 는 toString 재정의
        System.out.println("\tob1.toString()="+ob1);// toString 메소드 생략됨.
        System.out.println("\tob2.toString()="+ob2);
        System.out.println("\tob3.toString()="+ob3);


        System.out.println("day8 객체를 toString 재정의 확인");
        Shape sh2= new Shape();
        Shape diamond = new Diamond();  // 인스턴스 필드는 초기값 0
        Shape square = new Square();
        Triangle triangle = new Triangle("삼각형", 20, 3, 60);


        System.out.println("\tsh2"+sh2);
        System.out.println("\tdiamond"+diamond);            // 자식 클래스 Diamond  가 정의한 toString 
        System.out.println("\tsquare"+square);              // 부모 Shape 가 정의한 toString
        System.out.println("\ttriangle"+triangle);          // 부모 Shape 가 정의한 toString
        

    }
}
