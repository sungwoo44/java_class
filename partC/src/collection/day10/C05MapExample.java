package collection.day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/* 
 * Map <K,V> : Key 값으로 value 를 가져오기. key&value는 모든 타입 object입니다. 
 *             Key 는 중복된 값을 가질 수 없습니다.  Key와 value 모두 순서가 없습니다. 
 *             ㄴ Map에 입력된 순서대로 접근해야 한다면 LinkedHashMap 
 *             ㄴ 정렬된 방식(key기준)으로 접근 : TreeMap
 * Map 의 구성요소 : key, value 중에서 key는 set  특성을 갖고 있다 .
 * 
 * 
 * 
 */
public class C05MapExample {
    public static void main(String[] args) {
    Map<String,String> map = new TreeMap<>();
      map.put("tw", "트와이스");
      map.put("nu", "뉴진스");
      map.put("as", "에스파");
      map.put("gr", "소녀시대");
      map.put("tw", "원더걸스");            //tw Key값에 원더걸스 오버라이딩
      map.put("js", "뉴진스");
      System.out.println("map 의 크기 = " + map.size());
      System.out.println("map 에 저장된 문자열 = " + map);
  
  
    System.out.println("~~~Map 의 get 메소드 테스트 ~~~");
    Scanner sc = new Scanner(System.in);


    while(true){   
            System.out.print("찾을 값에 대한 key 입력하세요>>> ");;
            String key = sc.nextLine();
            if(key.equals("end"))
                break;
            System.out.println("당신이 원하는 key 의 값 = " + map.get(key));
    }

      System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
      System.out.println("\t map.keySet()?"+ map.keySet());                     // map의 key만 가져와서 set을 생성
      Iterator<String> mapIterator = map.keySet().iterator();                   //key 값으로 반복자를 생성합니다. 
      int cnt =0;

      while(mapIterator.hasNext()) {
         String temp =mapIterator.next();                                       //반복자가 가져온 값은 key 입니다. 
         System.out.println(String.format("count=%d , key= %s , value=%s", cnt++,temp,map.get(temp)));
        }
        
        
        System.out.println("==for 반복자로 출력하기 ");
        for (String key : map.keySet()) {           //map 의 key 값들로 반복자 실행하기 

            System.out.println(String.format("count=%d , key= %s , value=%s", cnt++,key,map.get(key)));
            
      }

      System.out.println("map.values()="+map.values());
      System.out.println("map.containsKey(\"tt\")="+map.containsKey("tt"));
      System.out.println("map.containsValue(\"js\")"+map.containsValue("에스파"));
      

    }
}
