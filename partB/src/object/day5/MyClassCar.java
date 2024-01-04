package object.day5;

import java.util.Arrays;

public class MyClassCar {
    public static void main(String[] args) {
        
        MyClassPractice car1 = new MyClassPractice();
        MyClassPractice car2 = new MyClassPractice();
        MyClassPractice ani1 = new MyClassPractice();
        MyClassPractice ani2 = new MyClassPractice();


        car1.carName="ferrari";
        car1.carSpeed=300;
        car1.carCode=new double[]{1234,5678};
        car2.carName="maserati";
        car2.carSpeed=250;
        car2.carCode=new double[]{4852,0415};

        ani1.setAniName("dog");
        ani1.setAniAge(4);
        ani1.setAniCode(new double[]{655468,468684});
        ani2.setAniName("cat");
        ani2.setAniAge(2);
        ani2.setAniCode(new double[]{112342,140923});

        System.out.println(car1.carName);
        System.out.println(car1.carSpeed);
        System.out.println(Arrays.toString(car1.carCode));

        System.out.println(car2.carName);
        System.out.println(car2.carSpeed);
        System.out.println(Arrays.toString(car2.carCode));

        System.out.println(ani1.getAniName());
        System.out.println(ani1.getAniAge());
        System.out.println(Arrays.toString(ani1.getAniCode()));

        System.out.println(ani2.getAniName());
        System.out.println(ani2.getAniAge());
        System.out.println(Arrays.toString(ani2.getAniCode()));


    }
}
// 오늘 새로배운 내용
/*
 *  1.  객체만들기 
 *  2.  객체는 인스턴스 필드와 인스턴스 메소드를 갖고 있으며 
 *      이것들은 객체가 주인되어 실행되어야 합니다. 
 *      
 *      객체 변수가 momo일때 , momo.getField1() 에서
 *      getField1()는 인스턴스 메소드입니다. 
 * 
 *  3.  객체의 인스턴스 필드는 private 으로 접근을 제한하는 것이 객체지향의 특징
 *              값을 읽어오는 get___(), 값을 저장하는 Set___()메소드 만들기 
 * 
 *  4.  인스턴스 필드가 참조변수 일때에는 '주소'의 개념을 꼭 먼저 생각하기 
 *              getter, setter 메소드의 인자와 리턴값이 주소입니다. 
 */