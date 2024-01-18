package day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import collection.day10.myapp.JavaWord;

public class D08FileReader {

    public static void main(String[] args) {
        long start = System.currentTimeMillis(); // 1000분의 1초
        // readByChar(); // 267ms
        // readByCharArray(); //49ms
        // readByCharBuffer(); //52ms
        readByScanner();
        readByScanner2();
        long end = System.currentTimeMillis();
        System.out.println(String.format("소요시간 : %,d ms", (end - start)));
    }

    public static void readByChar() { // 267ms
        String filePath = "C:\\Windows\\PFRO.log";
        // 문자열 저장하고 변경할수 있는 가변객체
        StringBuilder content = new StringBuilder();
        int charValue;
        int count = 0;

        try (FileReader fr = new FileReader(filePath)) {

            while ((charValue = fr.read()) != -1) { // read는 문자단위로 입력// 문자를 1개씩 읽음(입력)
                // int 값을 char로 변환하여 StringBuilder에 추가
                System.out.print((char) charValue);
                // 문자단위이기 때문에 표준출력 가능 // 이전 테스트는 바이트 단위였기때문에 write()사용
                content.append((char) charValue);
                count++;
            }
        } catch (Exception e) {
        }
        // FileReader 닫기
        System.out.println();
        // 파일에서 읽은 내용 출력
        System.out.println(content.toString());
        System.out.println("읽은 문자수 : " + count);
    }

    public static void readByCharArray() { // 49ms
        // String filePath = "단어장.txt";
        String filePath = "C:\\Windows\\PFRO.log";
        // ★★☆☆☆ StringBuilder content = new StringBuilder();
        char[] charValues = new char[256];
        int count = 0;
        int charCount = 0;
        int b;

        try (FileReader fr = new FileReader(filePath)) {

            while ((b = fr.read(charValues, 0, 256)) != -1) { // read(배열이름, 시작위치, 최대문자길이)
                // 읽은 문자의 개수는 리턴, b에 저장
                System.out.print(new String(charValues, 0, b)); // new String(배열이름 ,시작위치, 길이 ) --> (생성자) 문자열 생성
                // int 값을 char로 변환하여 StringBuilder에 추가
                // ★★☆☆☆ content.append(charValues,0,b);
                charCount += b; // 문자의 개수
                count++; // while 반복횟수
            }
        } catch (Exception e) {
        }
        // FileReader 닫기

        // 파일에서 읽은 내용 출력
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        // ★★☆☆☆ System.out.println(content.toString());
        System.out.println("반복 횟수 : " + count);
        System.out.println("읽은 문자수 : " + charCount);
    }

    // 라인단위로 읽기//문자기반 버퍼스트림은 라인(줄) 단위로 입출력 기능이 있다.
    public static void readByCharBuffer() {
        String filePath = "C:\\Windows\\PFRO.log";      // TIP_한줄이 256문자보다 많이 적으면 위에  char 배열보다 시간은 더 소요될수 있다.
        int count = 0; // 읽은 줄수

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line; 
            while((line = br.readLine()) != null){

                System.out.println(line);
                count++;
            }
            

        } catch (IOException e) {
            System.out.println("파일입력예외 : " + e.getMessage());
            System.out.println();
        }
        System.out.println("읽어온 라인 수 : "+ count);

    }


    public static void readByScanner(){
        String filePath = "단어장.txt";
        int count=0;


        //Scanner 클래스 :  1) 한줄씩 읽어오는 nextLine() 메소드, 
        //                  2) 구분기로호 분리해서 읽어오는 방법
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n");   // 구분기호(delimiter)를 ,또는(|)  엔터

            // 파일의 끝까지 반복
            while (fc.hasNext()) {          // 구분기호로 분리된 데이터가 있으면
                String token = fc.next();   // next 메소드로 가져오기
                System.out.println(token.trim());
                count++;
            }

    } catch (Exception e) { }

        System.out.println("읽은 토큰수 : "+count);
    }
    public static void readByScanner2(){
        String filePath = "단어장.txt";
        int count=0;
        List<JavaWord> list = new ArrayList<>();

        //Scanner 클래스 :  1) 한줄씩 읽어오는 nextLine() 메소드, 
        //                  2) 구분기로호 분리해서 읽어오는 방법
        try( Scanner fc = new Scanner(new FileReader(filePath))){

            fc.useDelimiter(",|\\n");   // 구분기호(delimiter)를 ,또는(|)  엔터

            // 파일의 끝까지 반복
            while (fc.hasNext()) {          // 구분기호로 분리된 데이터가 있으면

                list.add(new JavaWord(fc.next().trim(),
                                    fc.next().trim(), 
                                    Integer.parseInt(fc.next().trim())));

                // String token = fc.next();   // next 메소드로 가져오기
                // System.out.println(token.trim());
                count++;
            }
            System.out.println(list);

    } catch (Exception e) { }

        System.out.println("읽은 객체수 : "+count);

        for(JavaWord word :list) System.out.println("생성된 객체: "+word);
    }
}
