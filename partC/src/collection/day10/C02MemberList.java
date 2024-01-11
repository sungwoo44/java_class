package collection.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C02MemberList {
    public static void main(String[] args) {
        

        List<Member> list = new ArrayList<>();
        

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 22));
        list.add(new Member("momo", 25));
        list.add(new Member("dahy", 21));
        list.add(new Member("sana", 26));



        //Member 클래스 안에 hashCode,equals 메소드 정의하기 전/후 를 비교하세요
        // 컴파일러는 객체의 1) hashCode 가 같으면 2) equals 검사를 실행하여 둘다 만족시 동일한 객체로 결정.
                                // ㄴ remove,indexOf 메소드에 동일 객체 검사 할때 사용한다. 


        System.out.println("현재 리스트 내용 : " + list);
        System.out.println("현재 리스트 내용 : " + list.size());
        list.remove(new Member("momo", 23));
        System.out.println("삭제후 리스트 내용 : " + list);
        System.out.println("삭제후 리스트 내용 : " + list.size());


        System.out.println("특정 멤버 조회 : "  + list.indexOf(new Member("momo", 25)));
        
        
        
        //new Member("momo", 23) 에서 인스턴스 필드 값이 같다고 동일한 객체가 아닙니다. 
        //remove, indexOf 등의 메소드는 동일한 개체를 찾아서 삭제하거나 조회합니다. 
        // TIP : String은 문자열 리터럴이 같으면 주소가 같다. 

        // 일반적으로 만들어진 클래스는 hashcode 로 메모리의 참조 위치가 결정되므로 
        //                            인스턴스 필드 내용이 같으면 hashcode를 동일하게 만들도록 재정의합니다. 


        //정렬 나이 오름차순
        list.sort(new Comparator<Member>() {
            
            @Override
            public int compare( Member o1,  Member o2) {
                return o1.getAge()-  o2.getAge();
            }
       

        });
        System.out.println("정렬나이 오름차순 후 리스트 "+ list);         

        //정렬 이름 오름차순
        list.sort(new Comparator<Member>() {
            
            @Override
            public int compare( Member o1,  Member o2) {
                return o1.getName().compareTo(o2.getName());
            }
       

        });
        System.out.println("정렬이름 오름차순 후 리스트 "+ list);         
    // 정렬 람다식 나이 내림차순
       list.sort((o1 , o2)-> {return o2.getAge()-o1.getAge();});
        System.out.println("정렬나이 내림차순 후 리스트 "+ list);         
    
        // 정렬 람다식 이름 내림차순
       list.sort((o1 , o2)-> {return o2.getName().compareTo(o1.getName());});
        System.out.println("정렬 이름 내림차순 후 리스트 "+ list);         


    //List 의 static  메소드 
    // ㄴ 테스트용 리스트 만들 떄 사용한다.  불변객체  
    List<String> names = List.of("momo","dahy","nana","sana");
    System.out.println( "names " + names);
    //names.add("xxxyyyy");       //Immutable (불변의) Collections 오류!



        


    }
}
