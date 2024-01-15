package IOday11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//파일 입력 스트림으로 이미지 파일 읽어오기
// ==> 파일 출력스트림으로  파일 내용을  출력(파일복사)
public class D06FileCopyTest {

    
    public static void main(String[] args) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
             fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\고윤정.jpg");
             fos = new FileOutputStream("고윤정1.jpg");
             int b;
             int count =0;
             while ((b=fis.read()) !=-1 ) {     //1바이트 씩 복사하기 (파일 fis 에서 파일fos 로)
                fos.write(b);
                count ++;
             }
             System.out.println("총 입력 바이트수 : "+ count);


        } catch (IOException e) {
            System.out.println("예외: "+ e.getMessage());
            
        }finally{
            try {fis.close();fos.close();
            } catch (IOException e) {
            }

        }

    }
}
