package day11;

import java.util.ArrayList;
import java.util.List;

import collection.day10.myapp.*;

public class JavaWordApp_V1 {
    // private : 현재 클래스에서만 사용할 목적으로 접근 제한
    private List<JavaWord> words = new ArrayList<>();

    //프로그램 시작
    private void start(){
        initialize();// words 리스트 요소를 몇개만 미리 저장해서 초기화(테스트용)
        //단어 등록,목록,검색,삭제 기능을 메뉴로 구현합니다.
        System.out.println("단어장 프로그램 시작합니다~ "+"~".repeat(20));
        while(true){
            System.out.println("\t<<<메뉴를 선택하세요>>>");
            System.out.println("\t1.단어 등록");
            System.out.println("\t2.단어 목록 조회");
            System.out.println("\t3.단어 검색");
            System.out.println("\t4.단어 삭제");
            System.out.println("\t5.프로그램 종료");
            System.out.print("\t선택>>");         // 메소드에 입력기능이 있을때는 Scanner관리가 불편

            int select = Integer.parseInt(System.console().readLine());//-> (키보드 입력 문자열) 정수형
            //System.console(): 시스템의 콘솔(표준입출력장치) 객체를 리턴, readline() 입력메소드 실행
            switch (select) {
                case 1:
                    addWord();      //단어 등록 메소드 실행
                    break;
                case 2:
                    listWord();     // 단어 목록 조회메소드 실행
                    break;
                case 3:
                    serchWord();    // 단어 목록 조회메소드 실행
                    break;
                case 4:
                    removeWord();    // 단어 목록 조회메소드 실행
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);      //main 종료
                    break;      
                default:
                    System.out.println("잘못된 선택값 입니다.");
                   break;
            }


        }
    }
    //프로그램 실행하는 객체 생성하고 (메소드로 기능을 분리할 때 
    //                          main 이 호출하는 static 을 없애기 위함.) 
    // start 메소드 프로그램 실행 내용을 코딩    

    private void initialize() {
        words.add(new JavaWord("private", "개인적인", 1));
        words.add(new JavaWord("protected", "보호된", 1));
        words.add(new JavaWord("Iterate", "반복하는", 1));
        words.add(new JavaWord("collection", "수집", 1));
        words.add(new JavaWord("application", "응용의", 2));
        words.add(new JavaWord("binary", "2진수의", 3));
    }

    private void addWord() {
        System.out.println("\t\t:: 단어 등록 ::");
        System.out.print("\t:: 영어 단어 입력하세요 ::");
        String english = System.console().readLine();
        System.out.print("\t:: 한글 의미 입력하세요 ::");
        String korean = System.console().readLine();
        System.out.print("\t:: level 입력하세요 ::(1.초급 2.중급 3.고급)");
        int level = Integer.parseInt(System.console().readLine());
        
    
            words.add(new JavaWord(english, korean, level));
            
    
}

    private void listWord() {
        //to-do  리스트 words 에 저장된 요소(항목)들을 모두 출력해보세요
        System.out.println("\t\t:: 단어 출력 ::");
        System.out.println(String.format("%-20s %-20s\t %-10s","ENGLISH","KOREAN","LEVEL"));
        for(int i=0; i<words.size();i++){

            System.out.println(String.format("%-20s %-17s\t %d",words.get(i).getEnglish(),words.get(i).getKorean(),words.get(i).getLevel()));
        }
    }
    
    private void serchWord() {
        
        System.out.println("\t\t:: 단어 검색 ::");
        System.out.print("검색할 단어를 영문으로 입력하세요>>");
        String find = System.console().readLine();
        
        boolean isfind =false;
        for(JavaWord word : words){
            if(word.getEnglish().equals(find)){  // 문자열 비교 equals 
                System.out.println("\t\t:: 검색 결과 ::");
                System.out.println("\t  "+word.getEnglish() +" = "+ word.getKorean()+" ("+ word.getLevel()+" level)" );
                //return ; //1같은 단어를 1번만 저장하게 할때 사용
               isfind = true;  //2)같은 단어가 2번 이상 저장될때
            }

           if(isfind==false)   //2) if문 조건검사는 같은 단어가 2번이상 단어장에 있을때 사용
                System.out.println( "\t\t"+ find +"는 없는 단어 입니다.");
                
            


        
    }

    }       //리스트에 동일한 단어가 두번 저장되었다면????
            //리스트에 없는 단어를 조회한다면????
    
    private void removeWord() {
        System.out.println("\t\t:: 단어 삭제 ::");
        System.out.print("삭제할 단어를 영문으로 입력하세요>>");
        String remove = System.console().readLine();
        
        //Mycode
        //System.out.println("\t\t:: 정말 삭제하시겠습니까? ::(yes or Enter /no)");
        //String yes = System.console().readLine();
        boolean isfind =false;

        //선생님 코드
        for(int i=0; i<words.size();i++){
            if(words.get(i).getEnglish().equals(remove)){        
                isfind=true;
                System.out.println("인덱스 "+i+"에서 단어를 찾았습니다.");
                System.out.print("삭제는 엔터, 취소는 n 을 입력하세요 >>");
                if(System.console().readLine().equals("n"))
                    continue;
                else
                {
                    words.remove(i); 
                    System.out.println("삭제완료!"); 
                }
            }

        }
        if(!isfind)
                System.out.println("찾는 단어가 없습니다.");
        // MyCode
        // if(yes.equals("yes")){
        //         for(int i=0;i<words.size();i++)
        //             if(words.get(i).getEnglish().equals(remove))
        //             words.remove(words.get(i));  
        //     }
        // else if(yes.equals("no")){
        //     System.out.println("삭제가 취소되었습니다.");
        // }

           // System.out.println(String.format("%-20s %-20s\t %-10s","ENGLISH","KOREAN","LEVEL"));
           // for(int i=0; i<words.size();i++){
        }

      //System.out.println(String.format("%-20s %-17s\t %d",words.get(i).getEnglish(),words.get(i).getKorean(),words.get(i).getLevel()));
        

    


    public static void main(String[] args) {
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    }
}
