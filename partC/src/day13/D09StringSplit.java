package day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptContext;

public class D09StringSplit {
    // 전역변수 : 모든 메소드에서 사용할 수 있습니다.
   private static String filePath = "score.txt";

    public static void main(String[] args) {

        List<Score> list = makeList();
        // System.out.println(list); // 리턴 받은 리스트 내용을 출력
        for(int i=0; i<list.size();i++){
            System.out.println("i="+i+"score object = "+ list.get(i));
        }

        for(Score temp : list){
            System.out.println(temp);           // list.get(i)  똑같음
        }


    }

    

/*       1) score.txt  에서 모든 데이터를 읽어오고  Score 객체로 변환하여 리스트에 담고 리턴.
         2) score 객체로 변환
         3) 리스트에 담기
         4) 리턴. 
 */ 
    public static List<Score> makeList(){
        //★☆☆☆☆ int count = 0;
        List<Score> scorelist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                //★★☆☆☆ String[] temp = line.split(",");
                //★★☆☆☆ Score stu = new Score(temp[0].trim(),
                //★★☆☆☆ Integer.parseInt(temp[1].trim()),
                //★★☆☆☆ Integer.parseInt(temp[2].trim()),
                //★★☆☆☆ Integer.parseInt(temp[3].trim()));
                                //★★★☆☆ Score stu = makeScore(line);
                                //★★★☆☆ scorelist.add(stu);
                                
                        //★★★★☆ 
                        scorelist.add(makeScore(line));


                
                //★☆☆☆☆ System.out.println(String.format("count=%d , score object = %s", count, stu));
                //★☆☆☆☆ count++;
            }

            
        } catch (IOException e) {
            System.out.println("파일 입력 오류: " + e.getMessage());
        }
        System.out.println(" 리스트 생성 완료 ");
   
        return scorelist;
    }






    // BufferReader 클래스는 파일에서 1줄씩 읽어올 수 있습니다.
    // 1줄 읽고-> Score 객체 만들기 --> 4개 객체 (변수명 모두 stu 로 참조하고 출력하기)
    public static void split_test2() {
        int count = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                // String[] temp = line.split(",");
                // Score stu = new Score(temp[0],
                // Integer.parseInt(temp[1]),
                // Integer.parseInt(temp[2]),
                // Integer.parseInt(temp[3]));
        
                // 아래에서 메소드 생성해서 호출 ↓
                Score stu = makeScore(line);
                
                
                System.out.println(String.format("count=%d , score object = %s", count, stu));
                count++;
            }
            
        } catch (IOException e) {
            System.out.println("파일 입력 오류: " + e.getMessage());
        }
        
        System.out.println("Score 객체: " + count + "개 생성 완료!!");
        
    }
    
    public static Score makeScore(String line){
        String[] temp = line.split(",");
        Score stu = new Score(temp[0],
        Integer.parseInt(temp[1]),
        Integer.parseInt(temp[2]),
        Integer.parseInt(temp[3]));

        return stu;
    }


    public static void split_test1() {
        String stu = "김모모,67,77,88";
    
        // Split 메소드는 지정된 구분자(기분기호)를 이용해서 문자열을 분리하고
        // 배열에 저장해서 리턴.
    
        String[] temp = stu.split(",");
        System.out.println("1. split 실행결과 문자열 배열");
        // System.out.println(Arrays.toString(temp));
        // 같은내용 ↑
        for (String t : temp) {
            System.out.println("배열요소 = " + t);
    
            System.out.println("2. 분리된 객체로 Score 배열 만들기");
            // temp[0] 이름
            // temp[1]~[3] : 점수 문자열 --> 정수형으로 변화
    
            Score score = new Score(temp[0],
                    Integer.parseInt(temp[1]),
                    Integer.parseInt(temp[2]),
                    Integer.parseInt(temp[3]));
    
            System.out.println("Score 출력1: " + score.datas());
            System.out.println("Score 출력1: " + score); // toString 생략
        }
    }
}
