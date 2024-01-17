package day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        
        long start = System.nanoTime();         //나노세컨드 10억분의 1
         copyByByteArray();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end-start)));
        System.out.println();
        long start2 = System.nanoTime();         //나노세컨드 10억분의 1
        copyByByte();
        long end2 = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end2-start2)));
        System.out.println();

        long start3 = System.nanoTime();         //나노세컨드 10억분의 1
        copyByBuffer();
        long end3 = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ns",(end3-start3)));



    }
    
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("D:\\upload\\고윤정1.jpg");
            fos = new FileOutputStream("고윤정5.jpg");
            
            while((b=fis.read()) != -1){      //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ fis.close(); fos.close();}
            catch(IOException e) {}
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    // count : 1325184
    // 소요시간 : 30,395,863,100 ns

    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024]; // 바이트 배열을 이용해서 1024 바이트씩 입출력
        // try  with resources  - try ()안에 close 해야할 자원(리소스, 파일입출력스트림)을 선언하면
                                // -  finally  없이 close자동으로 한다. 이때 자원은 "Closeable" 인터페이스 구현체이어야 한다.
        try
        (
            FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\고윤정.jpg");
            FileOutputStream fos = new FileOutputStream("고윤정2.jpg")
        ){
            while((b=fis.read(buffer,0,buffer.length)) != -1){              //read(배열이름, 시작위치, 길이 ) //리터값 b 는 실제 읽어온 바이트수 
                // 1024 바이트가 아닐수 있으므로 실제 바이트수를 알아야 처리가능.
                fos.write(buffer,0,b);      // write(  배열이름, 시작인덱스, 출력길이)
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
        //     복사한 파일 크기 : 1,325,184 바이트
        // 소요시간 : 63,614,900 ns

    


        public static void copyByBuffer(){          //바이트 배열을 이용해서 1024바이트씩 입출력
            int b; int count=0;                     //              -> 버퍼에서 사용, 버퍼입출력스트림      ex)택배기사 2명 1층-10층 짐나르기)
            byte[] buffer = new byte[1024]; 
            try
            (
                FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\고윤정.jpg");
                FileOutputStream fos = new FileOutputStream("고윤정3.jpg");
                BufferedInputStream bis = new BufferedInputStream(fis);             //보조 버퍼입력 스트림
                BufferedOutputStream bos = new BufferedOutputStream(fos);           //보도 버퍼출력 스트림
            ){
                while((b=bis.read(buffer,0,buffer.length)) != -1){              
                    bos.write(buffer,0,b);     
                    count+=b;
                }
            }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
            }
            System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
        }
}
