package collection.day10;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.naming.LinkException;

public class C06TodayMenuVote {
    


    /**
     * @param args
     */
    public static void main(String[] args) {
        
        String menu ="치킨,스파게티,불고기,순두부,순대국";
        Map<String,Integer>map = new LinkedHashMap<>();
        // map.put("치킨", 0);
        // map.put("스파게티", 0);
        // map.put("불고기", 0);
        // map.put("곱창", 0);
        // map.put("순대국", 0);

        System.out.println("오늘의 메뉴 투표합니다.");
        System.out.println("메뉴:" + menu);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" 메뉴 이름 입력 >>>");
            String key = sc.nextLine();
            
            if(key.equals("end"))break;
             
            if(map.containsKey(key)){// 입력한 key의 value를 가져와서 +1 연산을 한결과로 다시 value에 저장
                map.put(key,map.get(key)+1);
                System.out.println("당신이 입력한 메뉴 ="+key);
            }
            else{
                System.out.println("없는 메뉴입니다.");
                //응용 없는 메뉴입력시 리스트에 추가
                map.put(key, 1);
                menu+= key;
            }
            
           }
          
           
           System.out.println("투표가 종료 되었습니다.");
           System.out.println(map);
           System.out.println(Collections.max(map.keySet()));   //key 중의 최대값
           System.out.println(Collections.max(map.values()));   // valuse 중의 최대값
           // value 최대값의 key 는 무없?? // key,value 를 한쌍으로 만드는 타입이 Entry

           //추가 고급버전
           Comparator<Entry<String,Integer>> Comparator = new Comparator<Entry<String,Integer>>(){
            @Override
            public int compare(Entry<String,Integer> o1, Entry<String,Integer>o2){
                return o1.getValue()-o2.getValue();
            }
           };
           Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),Comparator);
           System.out.println("결과");
           System.out.println("메뉴이름 : " + maxEntry.getKey());
           System.out.println("투표수   : " + maxEntry.getValue());
           
           sc.close();
           };
        }







    

