package IOday11;

import java.io.File;
import java.io.IOException;

// file 클래스 :  운영체제의 파일시스템 클래스
public class D02CheckedExceptionTest {

    public static void main(String[] args) {
        // 생성하려는 파일의 이름으로 File객체를 정의
        // (TIP)디렉토리를 지정하지 않을시 프로젝트와 같은 폴더에 생성됨.
        // File file = new File("F:\\테스트.md"); <== 없는 드라이브 지정 <- 예외발생 오류!!오류!!
        File file = new File("테스트.md");

        // 새로운 파일을 생성하는 메소드
        try {
            // if (file.exists()) // 파일 존재여부?!
            System.out.println("파일이 존재합니까: " + file.exists());
            file.createNewFile(); // 메소드는 처리해야할 예외가 있다.
            System.out.println("파일의 길이 : " + file.length());
        } catch (IOException e) { // ==> 예외 객체는 변수 e 로 참조 // IOException 처리 : 대표적인 체크 인섹션.
            System.out.println("파일생성 오류!!! 오류!!!");
            System.out.println(e.getMessage());// 오류 원인

        }
    }
}
