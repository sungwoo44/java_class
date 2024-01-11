package collection.day10;

import java.util.ArrayList;
import java.util.List;

import java.util.Iterator;

public class C03MemberListPrint {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        
        List<Member> list = new ArrayList<>();
        

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));    

        //toString 재정의된 출력인 아닌 직접 Member 이름,나이를 모두 출력
        System.out.println("============================");
        System.out.println("012345678901234567890123456789");
        System.out.println(String.format("%s\t %s\t %s\t %s ", "이름1","나이1","이름2","나이2"));
        System.out.println("============================");


        for(int i =0; i<list.size();i++){
            Member temp = list.get(i);
            System.out.print(String.format("%s\t %d\t",temp.getName(),temp.getAge()));

            System.out.println(String.format("%s\t %d",list.get(i).getName(),list.get(i).getAge()));
        }
        System.out.println("============================");
        System.out.println();
        


        //컬렉션에서는 반복자(Iterator) 로 데이터에 접근합니다.     - 인덱스가 없는 자료구조에서 반복자를 사용한다
        //반복자를 이용한 출력 
        
        System.out.println("====반복자를 이용한 출력====");
        Iterator<Member> iterator = list.iterator();            //list 로 선언된 자료구조에 접근할 반복자 선언
        int count =0;
        while (iterator.hasNext()) {                            //반복자가 접근할 다음 데이터가 있으면 참.
            Member temp =iterator.next();                       //반복자가 다음 데이터를 가져옵니다. 
            System.out.println("count = "+ count++ +",요소 =" + temp);
            
        }   
        // iterator 로 동작하는 for   // 동작방법 ctrl + space "iter" 선택!
        System.out.println();
        System.out.println("~~~iterator 로 for문 출력~~~");
        count =0;
        for (Member temp : list) {
            System.out.println("count = "+ count++ +",요소 =" + temp);
            }



    }   
}
