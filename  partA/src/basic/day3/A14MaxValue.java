package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        int n1 =5;
        int n2 =4;
        int n3 =3;
        int max=0;

        // 나가 짠코드
        // if(n1>n2){
        //     System.out.println("n1>n2");
        //     max = n1;
        //     System.out.println("최대값은 : "+ ((n3>n1)? (max=n3):(max=n1))+"입니다.");
        // }
        // else{
        //     System.out.println("n2>n1");
        //     max =n2;
        //     System.out.println("최대값은 : "+ ((n3>n2)? (max=n3):(max=n2))+"입니다.");
        // }


        //선생님  if문
         
          if(n1>n2){    // 참/거짓 각각 실행명령어가 다르다.
           max=n1;
          }else{
           max=n2;
          }
          if(max<n3){   // 참일때만 실행하는 명령어 
           max=n3;
          }
           System.out.println("최대값은 : "+max+"입니다.");
        
          //  삼항연산자
        
          max = 0; // 초기화
          max = (n1>n2? n1:n2);
          max = (max<n3? n3:max);
          System.out.println("최대값은 : "+max+"입니다.");
         

        

    }
}
