package collection.day10;
/* 
 * set: 수학시간에 배운 집합
 * 순서(인덱스)가 없다. 
 * 중복값이 없다. 
 * Map의 구성 요소 : Key,value 중에서  Key는 Set의 성질을 가짐. 
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04SetExample {
    public static void main(String[] args) {
        
        //무작위 (컴파일러 내부의 기준) 
        Set<String> set1 = new HashSet<>();
        set1.add("트와이스");
        set1.add("아이브");
        set1.add("잇지");
        set1.add("뉴진스");
        set1.add("트와이스");
        set1.add("르세라핌");
     
        System.out.println("set1 : " + set1);
        System.out.println("set size : " + set1.size());

        //set 인덱스 없음!!!
        //so for (int i=0;i<set.size();i++)와 같은 방식 사용불가!
        //Iterator
        
        
        //본래set은 순서가 없으므로 무작위 접근 
        // Linked 는 다음 입력데이터의 참조값을 저장하여 입력 순서대로 접근하도록 합니다. 
        Set<String> set2 = new LinkedHashSet<>();
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스");
        set2.add("르세라핌");
        System.out.println("set2 : " + set2);
        System.out.println("set size : " + set2.size());
        
        
        //이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근합니다.
        Set<String> set3 = new TreeSet<>();
        set3.add("트와이스");
        set3.add("123");
        set3.add("#$%");
        set3.add("ASDF");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스");
        set3.add("르세라핌");
        
        System.out.println("set3 : " + set3);
        System.out.println("set size : " + set3.size());
        
        
        
        
        
        
    }
}
