package basic.day5;

public class A30HashCodeTest {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        String message= "Hello World~~";

        //hashcode 는 참조값(식별값)을 만들기 위해 '해쉬함수' 로 생성된 결과입니다. 
        System.out.println(iArray);                 //배열의 식별값을 보여줍니다 (16진수 8자리)
        System.out.println(" 초기 해시코드 " +iArray.hashCode());      //해쉬코드값을 보여줍니다 (10진수)
        System.out.println(Integer.toHexString(iArray.hashCode()));  //10진수를 16진수로 변환

        iArray[3]=99;
         System.out.println(" 배열요소값 변경후 해시코드 "+iArray.hashCode());  
         System.out.println("결론 : 배열 값이 변경되어도 메모리의 위치는 동일");
         
         System.out.println("\n String 배열 message의 해시코드 값 : "+ message.hashCode());
         message+="good!";
         System.out.println("\n 변경후  message의 해시코드 값 : "+ message.hashCode());
         System.out.println("결론 : 문자열은 내용이 변경되면 메모리의 위치가 변경된다.");// 계속 변경되면 계속 메모리가 변경되기떄문에 문자열은 다른걸 사용한다.


         /*객체란? 여러종류의 데이터가 모여있는 데이터 덩어리 (기본형은 데이터의 최소단위) 
          *객체는 참조형 변수를 사용합니다.(변수가 주소를 저장한다.)
          *객체를 메모리에 저장~ ---> 초기 저장 데이터 바꿀수 있다.(배열)     -> 가변객체
                               ---> 초기 저장 데이터 바꿀수 없다.(String)   -> 불변객체
          


         */

         





    }
}
