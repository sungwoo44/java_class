package IOday11;

import java.io.FileOutputStream;
import java.io.IOException;

// 표준입출력 테스트 
// 키보드 입력 : new Scanner(System.in) or System.console)().readLine()
public class D03StandardIOTest {

    public static void main(String[] args) {
        
        int b; 
        System.out.println("입력하세요. ▼");
        FileOutputStream fos = null;
        // 표준입출력은 모든 글자가 2바이트 --> 윈도우 터미널 인코딩 방식
        try{
            fos = new FileOutputStream("note.txt");             // 인자로 파일명을 전달합니다.

            int count =0; 
            while((b=System.in.read()) != -1){  // -1은 (ctrl + z) ==> 입력끝
                // b = System.in.read();           //원초적 입력
                // System.out.println(b);       // 문자 인코딩 안하고 정수값 출력
                //System.in.read()로 입력받은 정수값을 문자로 인코딩하는 메소드
                // System.out.write(b);            //표준출력
                 fos.write(b);                      // 파일출력스트림으로 데이터 보내기 
                count++;
            }
            System.out.println("총 입력 바이트수 : "+ count);
            
            

        } catch(IOException e){
            System.out.println("예외 :"+e.getMessage());
        }finally{   // 입출력 자원해제는 여기서 함. 예외 발생 상관없이 처리할 명령어 
            try {fos.close();
            } catch (IOException e) {}
        }
    }
    
}
//File Input  --> 화면(표준) 출력
//File Input  --> File Output       (파일 복사)
//바이트기반 스트림은 문자형식의 파일이 아닐때 
//문자기반 스트림 : 문자단위 입출력.
//