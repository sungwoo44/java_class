package basic.day3;

//조건식을 사용하는 if문
public class A14IfElseTest {
    public static void main(String[] args) {
      
      int point=69;                     //    2)vip 회원이면 이벤트 포인트 100 포인트 추가, 일반회원 50 포인트 추가
     System.out.println("이벤트기간이므로 모든 회원분들께 포인트를 추가로 적립해 드립니다.");
      if(point >=70) {
         System.out.println("Vip 회원이십니다.💕💕"); // 원도우 명령창 인코딩을 유니코드 UTF-8  로 변경해야 합니다 
         point += 100;                                  // chcp 65001
      }else {      //   point < 70 일때 실행
         System.out.println("일반 회원이십니다.🤞🤞");
         point +=50; 
      }
      
       System.out.println("고객님의 최종 포인트는 " + point + " 입니다.");

       // 조건식? 참일때 (실행명령 또는 값): 거짓 일때 (실행명령 또는 값) => 연산부분이 3가지 즉 삼항연산이라고 함. 
       System.out.println("고객님의 최종 포인트는 " + (point>150? (point=point+200):(point +=100)) + " 입니다.");
    }
}
