package object.day5;

import java.util.Arrays;

public class B02GetterSetterTest {
    public static void main(String[] args) {

        MyClass2 momo = new MyClass2();

        System.out.println("MyClass2의 field1값 (전) : "+ momo.getFild1());
        momo.setFiled1("i'm momo!");
        System.out.println("MyClass2의 field1값 (후1) : "+ momo.getFild1());
        String message ="hello";
        momo.setFiled1(message);
        System.out.println("MyClass2의 field1값 (후2) : "+ momo.getFild1());
        System.out.println();

        System.out.println("MyClass2의 field2값 (전): "+ momo.getFild2());
        momo.setFiled2(123);
        System.out.println("MyClass2의 field2값 (후1): "+ momo.getFild2());
        int number = 456;
        momo.setFiled2(number);
        System.out.println("MyClass2의 field2값 (후2): "+ momo.getFild2());
        System.out.println();
        momo.printDate();

        double test[] = new double[]{1,4};
        System.out.println("~~~~~~~~~~~field3은 double배열 타입!!!!!");

        System.out.println("MyClass2의 field3값 (전): "+ momo.getFild3());
        double[] dArray = momo.getFild3();
        momo.setFiled3(new double[5]);
        System.out.println("field3="+dArray);
        System.out.println(Arrays.toString(momo.getFild3()));
       
        System.out.println("MyClass2의 field3값 (후1): "+ momo.getFild3());
        
        
        momo.setFiled3(test);
        momo.printDate();

        System.out.println("MyClass2의 field3값 (후2): "+Arrays.toString( momo.getFild3()));
        test[1]=3.1415;
        momo.printDate();


    }

}
