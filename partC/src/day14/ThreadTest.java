package day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest {

    public static void main(String[] args) {
        
      

        // 실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        // ㄴ  1초마다 . 출력하기 --> 새로운 쓰레드로 만듭니다. (메인은 파일 받아오는중)
        //  -방법-
        //  1) Thread  클래스 상속받기      2)Runnable 인터페이스 구현하기 
        // 

        //쓰레드가 할일을 인터페이스 활용하여 정의합니다. --> 익명클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() { //쓰레드가 할일을 여기에 코딩

                boolean run = true;
                while (run){
                    System.out.print(".");
                    try {
                        Thread.sleep(10);          //0.01초
                    } catch (InterruptedException e) {
                        run = false;
                        System.out.println();
                    }
                }
                
            }
        };


        //쓰레드 생성하기 .할일은 생성자 인자로 전달.
        Thread thread = new Thread(runnable);
        
        
        
        
        
        long start2 = System.nanoTime();         //나노세컨드 10억분의 1
        //쓰레드 실행하기 
        thread.start();

        copyByByte();   //main 쓰레드 실행

        // 쓰레드 종료 인터럽트 발생
        thread.interrupt();

        long end2 = System.nanoTime();
        System.out.print(String.format("소요시간 : %,d ns",(end2-start2)));




    }
    
    public static void copyByByte() {
        int b; int count=0;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("D:\\upload\\Liverpool1.jpg");
            fos = new FileOutputStream("Liverpool.jpg");
            
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
        System.out.print(String.format("\n복사한 파일 크기 : %,d 바이트",count));
    }
    // count : 1325184
    // 소요시간 : 30,395,863,100 ns

    
    


        
}
