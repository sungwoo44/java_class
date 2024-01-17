package day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//socket.png  그림 참고 : 클라이언트와 서버 각각 실행하는 메소드가 다릅니다. 
                        // 서버와 클라이언트 연결 과정이 다르기 때문에
//          프로그램 실행은 서버가 먼저 실행하기
public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        InputStream is = null;
        DataInputStream dis = null;
        try {
                //서버 소켓 생성
                server = new ServerSocket();
                
                //서버 연결 정보 IP / Port 설정
                //1)★bind
                server.bind(new InetSocketAddress("192.168.30.25",5050));
                System.out.println("[서버프로그램 시작]: 연결 요청을 기다리는 중입니다.");
                
                //클라이언트 요청에 대한 수락
                //3)★accept
                socket = server.accept();        // 입출력 스트림을 만들 소켓
                System.out.println("_연결 수락");                  //accept 정상 완료 되면 실행.

                //서버 --> 클라이언트 데이터 보내기 : 출력 스트림
                // 서버--클라이언트 연결된 소켓으로 출력 스트림 생성
                os = socket.getOutputStream();     
                //정수,실수,문자열 보내는 스트림
                dos = new DataOutputStream(os);    // 보조스트림
                dos.writeUTF("\tFrom 서버 >> 환영합니다 welcome!!.");  

                //서버<== 클라이언트 데이터 받기 : 출력 스트림
                is = socket.getInputStream();
                dis = new DataInputStream(is);
                String message = dis.readUTF();
                System.out.println(message);

                //클라이언트에서 보낸 이미지 받기  파일명은 "d:\\고윤정.jfif"   다운로드 위치는 d 드라이브
                //클라이언트가 보내준 파일명으로 저장하기 (d 드라이브 또는 다운르도 폴더)
                String fileName = dis.readUTF();
                System.out.println("\t클라이언트 업로드 파일명 : " + fileName);
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\upload\\"+fileName));

                int b ; int count =0;
                while ((b=dis.read())!=-1) {
                    bos.write(b);               //버퍼스트림 이용한 바이트 단위 출력
                    count++;
                }
                System.out.println("파일 받기 완료/ 총 바이트 수:"+count );




            
        } catch (IOException e) {
            e.printStackTrace(); // 예외 발생했을 때 코드 수정하려면 필요.

        }finally{
            //자원해제. close 처리
            try {server.close(); socket.close();os.close();dos.close();is.close();dis.close();} catch (IOException e) {
            }
        }
    }
    
}
