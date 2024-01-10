package day9;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class C21ArraySortTest {
    public static void main(String[] args) {
        
        int[] number = {67,34,65,89,54};
        System.out.println("초기 숫자:"+ Arrays.toString(number));
        Arrays.sort(number);
        System.out.println("정렬 후:"+ Arrays.toString(number));

        String[] name = {"모모","나연","다연","쯔위"};
        System.out.println("초기 name:"+ Arrays.toString(name));
        Arrays.sort(name);
        System.out.println("정렬 name:"+ Arrays.toString(name));



        // Arrays.sort (배열변수) : 기본형 배열 String 배열의 오름차순 정렬가능
        // -> 내림 차순 정렬 또는 다른 참조타입에 대한 정렬은 
        // 메소드 두번째 인자로 정렬에대한 기준 공식을 줘야함
        //                               ↑↑↑↑↑ 인터페이스로 전달!


        //순차정렬 알고리즘 : 가장 심플

        // 내림차순 정렬 - Comparator 는 <> 제너릭 타입에 기본형을 사용하지 못함. 
        //              기본형은 Wrapper 클래스를 사용한다.

        Integer[] number2 = {67,34,77,89,82};
        
        //일반 스타일 ver.1
        Arrays.sort(number2,new Comparator<Integer>() {
        
            @Override
            public int compare(Integer o1,Integer o2){
                //내림차순 리턴 수식을 만드세요.
                return o2-o1;
                //대입문 또는 수식에서 Interger 타입과  int 타입 사이의 캐스팅은 자동입니다. 
            }
        });

        //람다식    ver.2
        Arrays.sort(number2,(o1,o2)-> {return o2-o1;});



         System.out.println("정렬 후:"+ Arrays.toString(number2));
    }
}
