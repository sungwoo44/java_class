package object.day5;

import java.util.Arrays;

public class B01MyClassMain {
    public static void main(String[] args) {
        //정의된 클래스 MyClass1으로 객체를 만듭니다. - new 연산 사용하기 

        MyClass1 my1 = new MyClass1();
        // 객체란 데이터 덩어리. new 연산으로 MyClass1 객체를 저장할 메모리 할당
                           //MyClass1() 는 생성자 메소드, 무조건 클래스 이름과 같다.
                                        // ㄴ 메모리에 저장공간을 확보하면서 동시에 실행.


        System.out.println("my1.field1:"+my1.field1);
        System.out.println("my1.field2:"+my1.field2);
        System.out.println("my1.field3:"+my1.field3);
        ` 
        
        my1.field1="hi";
        my1.field2=123;
        my1.field3=new double[5];
        
        System.out.println("my1.field1:"+my1.field1);
        System.out.println("my1.field2:"+my1.field2);
        System.out.println("my1.field3:"+my1.field3);
        System.out.println("my1.field3 배열의 크기:"+my1.field3.length);
        System.out.println("my1.field3 배열의 요소값:"+Arrays.toString(my1.field3));
        System.out.println("my1.field3 해시코드:"+my1.hashCode());


         MyClass1 my2 = new MyClass1();

         my2.field1="안녕";
         my2.field2=987;
         my2.field3=new double[]{34,12.54,7.3};


         System.out.println("my2.field1:"+my2.field1);
         System.out.println("my2.field2:"+my2.field2);
         System.out.println("my2.field3 배열의 요소값:"+Arrays.toString(my2.field3));
         System.out.println("my2.field3 해시코드:"+my2.hashCode());


    } 
}
