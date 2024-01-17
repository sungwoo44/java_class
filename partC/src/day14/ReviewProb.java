
/* 
1. 파일장치로 데이터를 저장하는 것은 입력스트림을 사용한다.( O X )
답: x (파일장치로 데이터를 저장하는 것은 출력)

2. 데이터 전송 단위에 따라 바이트기반과 문자기반으로 분류된다. ( O X ) 답: o

3. 1) FileReader 클래스의 부모 클래스는 Reader 클래스이다. ( O X ) 답: o
설명 : 문자기반 입출력 부모(상위) 클래스는 모두 Reader클래스 

2) FileReader 클래스는 문자기반으로 InputStream 의 자식 클래스이다. ( O X ) 답 x
설명 : InputStream은 바이트기반 클래스의 상위클래스

3) BufferWriter 클래스는 단독으로 사용되는 출력스트림으로 라인단위 처리가 가능하다. ( O X )답 x
설명 : 보조스트림으로 기본입출력스트림과 같이 사용해야함

※문자기반은 ___Reader    ※바이트 기반 ___Stream
___Writer     			

4. 바이트 기반의 입력스트림을 처리 속도 향상을 위해 사용할 수 있는 방법은? (2가지)
1)  byte 배열로 일정크기의 바이트 단위로 입출력
2) 보조스트림 BufferedInputStream 또는 BufferedOutputStream  사용

5. 입출력스트림의 메소드 대부분이 처리가 필요한 예외는? 답 IOException

6. 예외처리를 강요하는 것은 언체크드 익셉션이다. ( O X )답 x
설명 : 강요하는 것은 체크드 익셉션
※ 언체크드 익셉션은 대체로 강요하진 않지만 실행중에 발생하는 RuntimeException의
하위클래스들 이다.

7. 예외처리를 직접(try-catch) 하지 않고 호출한 메소드로 위임하는 키워드는? 답 throws 예외이름1, 예외이름2,....


8. 개발자는 throw 명령으로 조건이 만족되지 않은 경우 예외를 발생시킬 수 있다. ( O X ) 답 o
설명 : JavaWordList.java 적용, ReviewProb.java에서 테스트

9. 입출력스트림으로 사용된 객체는 반드시 자원해제를 해야한다. ( O X )o
※ 자동으로 자원해제되는 try 구문 형식에는 명시적인 close() 안썼습니다.

10. System.in 표준입출력만 사용하여 최대 20바이트의 문자열을 입력받을 수 있는 코드를 작성해보세요.
입력받은 내용은 출력으로 확인도 합니다. 총 라인수 3~4 줄 (ReviewProb.java)


*/

package day14;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import collection.day10.myapp.JavaWord;
import day13.io.JavaWordList;

public class ReviewProb {
    public static void main(String[] args) {

        // Porb_8();

        Porb_10();
    }

    // 8번 문제
    public static void Porb_8() {
        JavaWordList words = new JavaWordList("단어장.txt");
        words.fileLoad();
        // words.remove(-9);
        words.add(new JavaWord("null", "비어있는", 1));
        // 개발자가 만든 예외 : 1) 예외가 발생되는 문법 오류, 실행오류는 없지만 값의 범위를 제한하기 위해 예외를 일부러 발생시킴
        // 2) 기존의 발생하는 예외를 새로운 내용으로 변경하고자 할때

    }

    // 10번 문제
    public static void Porb_10(){

        //System.in VS Scanner 의 장점
                        //1)사용자로부터 얼마나 받을지 알수 없기떄문에 배열선언에 에로사항
                        //2) 배열을 따로 생성하지 않아도 스캐너는 사용가능하다.
        byte[] inputBytes = new byte[20];
        try {
            int b;
            System.out.println("최대 20바이트 문자열 입력받기");
            // System.in.read(inputBytes, 0, 20);
            b= System.in.read(inputBytes, 0, 20);
            System.out.println(" 입력한 바이트 수 : " + b); 
            // System.out.println("입력받은 내용: " + new String(inputBytes));
            System.out.println("입력한 문자열 정수 변환: "+ Integer.parseInt(new String(inputBytes).trim()));



                // TIP_)  논리적 OR : || (2개)   비트단위 OR : | (1개)
        } catch (IOException | NumberFormatException e) {

            e.printStackTrace(); ///  예외 원인을 추척해서 출력!!
           /*  Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
                at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
                at java.base/java.lang.Integer.parseInt(Integer.java:668)
                at java.base/java.lang.Integer.parseInt(Integer.java:786)
                at day14.ReviewProb.Porb_10(ReviewProb.java:89)
                at day14.ReviewProb.main(ReviewProb.java:61)
        
        */
        }

    }
}
