package basic.day5;

import java.util.Arrays;

public class A29ArrayVarTest {
    public static void main(String[] args) {
    int[] iArray = { 1, 2, 3, 4, 5 };
    double[] dArray = new double[5];
    char[] cArray = new char[5];
    cArray[0] = 'j';        
    cArray[1] = 'a';       
    cArray[2] = 'v';       
    cArray[3] = 'a';       
    cArray[4] = '!';
             // '' 안에 비어있으면 오류, 반드시 1글자 필요함
             // iArray, dArray,cArray 배열 이름으로 출력하면 배열과 관련된 정보
            //                          그 정보에 참조값(식별값)이 포함됩니다. 

    
    System.out.print("\n1.  ");
    System.out.println(iArray);
    System.out.print("\n2.  ");
    System.out.println(dArray);
    System.out.print("\n3.  ");
    System.out.println(cArray);

    int[] temp;
    temp = iArray;                          //  iArray 의 주소 (참조값)를 temp 변수에 저장
    System.out.print("\n4.  ");
    System.out.println(temp);
    

    System.out.println("\n5. 참조값을 전달받은 temp 배열 확인");
    temp[3]=999;
    System.out.println("temp[3]:"+ temp[3]);

    System.out.println("\n6. iArray도  확인");
    System.out.println("iArray[3]:"+ iArray[3]);
    System.out.println("iArray 배열의 값 : "+ Arrays.toString(iArray));

    iArray[1]=1234;
    System.out.println("\n7. temp 와 iArray은 하나의 배열을 가리킴");
    System.out.println("temp6 배열의 값 : "+ Arrays.toString(temp));
    System.out.println("iArray 배열의 값 : "+ Arrays.toString(iArray));


        // 기본형과 참조형 비교 
        int age = 123;
        int myage;
        myage=age;
        age=321;

        //myage는 123 일까? 321 일까? 변하니?? 



    }
    
}