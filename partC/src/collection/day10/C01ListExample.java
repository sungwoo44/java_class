package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01ListExample {
    public static void main(String[] args) {
        
        List<String> strlist = new ArrayList<>();
        //List 인터페이스 구현한 클래스가  ArrayList 입니다.
        
        List<String> boylist = new ArrayList<>();


        strlist.add("트와이스");
        strlist.add("잇지");
        strlist.add("아이브");
        strlist.add("원더걸스");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");
        boylist.add("BTS");
        boylist.add("Wanna One");
        boylist.add("투바투");
        boylist.add("NCT");
        boylist.add("세븐틴");
        boylist.add("비투비");

        System.out.println("문자열 LIST strlist size: "+ strlist.size());           
        System.out.println("\n 데이터추가");
        strlist.add("르세라핌");
        System.out.println("항목 추가 후 리스트 "+ strlist);            //ArrayList 클래스의 toString  메소드 실행

        System.out.println("\n 데이터 삭제 ");                      
        strlist.remove("원더걸스");                              //remove 메소드 오버로딩
        System.out.println("항목 삭제 후 리스트: "+ strlist);
        strlist.remove(1);                                  //메소드 인자 타입이 int 와 String(요소의 타입) 2가지로 동작
        System.out.println("항목 삭제 후 리스트: "+ strlist);


        //아래 2개 메소드 비교 
        System.out.println("\n 데이터 추가");
        strlist.add(3,"블랙핑크");                       // add : 중간 삽입
        System.out.println("항목 추가 후 리스트 "+ strlist);            //ArrayList 클래스의 toString  메소드 실행
        strlist.set(2, "아이들");                        //set : 수정
        System.out.println("항목 추가 후 리스트 "+ strlist);            //ArrayList 클래스의 toString  메소드 실행


        System.out.println("\n특정 인덱스 요소값 가져오기");
        System.out.println("strlist.get(0) "+strlist.get(0));
        System.out.println("strlist.get(5) "+strlist.get(5));        
       // System.out.println("strlist.get(7) "+strlist.get(7));        //없는 인덱스 오류!


        // 해보기 
        // addAll
        // contains
        // indexof
        // lastIndexOf

        strlist.addAll(boylist);
        System.out.println("항목 추가 후 리스트 "+ strlist);            //ArrayList 클래스의 toString  메소드 실행

        //중복값 다시 저장가능한지 확인 
        System.out.println("중복되는 데이터 추가 삽입");
        strlist.add("아이브");
        System.out.println("항목 추가 후 리스트 "+ strlist);            //중복값 허용  

        // 리스트에서 요소를 찾는 조회기능 
        strlist.contains(boylist);
        System.out.println("항목 추가 후 리스트 "+ strlist.contains("블랙핑크"));            //ArrayList 클래스의 toString  메소드 실행

       strlist.indexOf(1);
       System.out.println("항목 추가 후 리스트 "+ strlist.indexOf("아이브"));            //ArrayList 클래스의 toString  메소드 실행

       strlist.lastIndexOf(1);
       System.out.println("항목 추가 후 리스트 "+ strlist.lastIndexOf("BTS"));

       System.out.println("\n\n리스트에서 항목 찾기");
       System.out.println("\t 리스트에 처음 `아이브` 어디 있음? " + strlist.indexOf("아이브"));
       System.out.println("\t 리스트에 마지막 `아이브` 어디 있음? " + strlist.lastIndexOf("아이브"));
       System.out.println("\t 리스트에 `뉴진스` 있음? " + strlist.contains("뉴진스"));
       System.out.println("\t 리스트에 `뉴진스` 어디 있음? " + strlist.indexOf("뉴진스"));


        strlist.sort(null);
        System.out.println("정렬 후 리스트 "+ strlist);     

        strlist.removeAll(boylist);
        System.out.println("항목 추가 후 리스트 "+ strlist);            
        strlist.clear();
        System.out.println("항목 추가 후 리스트 "+ strlist);            


              

    }
}

/* List 구현 클래스 특징 :   인덱스가 있어서 데이터의 순서가 있다.
                            배열처럼 인덱스를 갖습니다 배열에 없는 삭제기능
 *                          조회와 조작 관련된 다양한 기능 
 */