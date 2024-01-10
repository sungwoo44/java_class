package day9;

import java.util.Arrays;

public class C24MemberCompareTest {
    
    //Member 객체를 비교하고 Member 배열정렬도 할수 있음.
    public static void main(String[] args) {
        
        Member momo = new Member("momo", 23);
        Member sana = new Member("sana", 22);
        Member dahy = new Member("dahy", 21);
        Member nana = new Member( "nana", 20);
        
        Member[] members = new Member[4];
        members[0] = momo;
        members[1] = sana;
        members[2] = dahy;
        members[3] = nana;

        System.out.println("초  기 member 배열 : \n" + Arrays.toString(members));
        Arrays.sort(members);           //배열 요소  member객체가  compareto 메소드가 있으므로 정렬가능
        System.out.println("정렬후 member 배열 : \n" + Arrays.toString(members));


        System.out.println("momo & nana age compare!");
        System.out.println("\t"+momo.compareTo(nana)+ "--> 양수라면 momo가 nana보다 나이가 많습니다.");
    }
}
