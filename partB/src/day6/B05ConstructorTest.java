package day6;

import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {

        MyClass4 my = new MyClass4();
        System.out.println("기본생성자 실행");
        System.out.println("\tfield2:"+my.getField2());




        System.out.println("인자1개 커스텀 생성자 실행");
        MyClass4 my1= new MyClass4(999);
        System.out.println("\tmy1 field2:"+my1.getField2());
        MyClass4 my2= new MyClass4("hello");
        System.out.println("\tmy2 field2:"+my2.getField1());
        MyClass4 my3= new MyClass4("java",123);
        System.out.println("\tmy3 field3:"+my3.getField1());
        System.out.println("\tmy3 field3:"+my3.getField2());
        MyClass4 my4= new MyClass4("tiki",456,new double[3]);
        System.out.println("\tmy4 field4:"+my4.getField1());
        System.out.println("\tmy4 field4:"+my4.getField2());
        System.out.println("\tmy4 field4:"+Arrays.toString(my4.getField3()));


        //기본생성자와  setter 가 없는 MyClass5 객체 생성
        MyClass5 my5 = new MyClass5("language", 1111, new double[3]);
        //MyClass5 my6 = new MyClass5();
        
        System.out.println("\tmy5 field5:"+my5.getField1());
        System.out.println("\tmy5 field5:"+my5.getField2());
        System.out.println("\tmy5 field5:"+Arrays.toString(my5.getField3()));

        MyClass3 test = new MyClass3();
        test.setField1("파이썬");
        test.setField2(1234);
        test.setField3(new double[]{123,123,414});

        //기본 생성자는 set 메소드로 직접 값을 초기화하는 것이 조금 불편함
        //              -> 초기화를 위해서는 커스텀 생성자가 좋다.


        //결론 : MyClass3 과 같이 생성자 메소드가 직접 정의된 것이 없으면 기본생성자만 사용가능
        //      MyClass5  와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본생성자는 사용 못함.
        //               사용하고 싶으면 직접 정의해야한다.
        //              ㄴ *public MyClass5(){}*


    }
}
