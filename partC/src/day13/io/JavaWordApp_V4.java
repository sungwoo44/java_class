package day13.io;

import java.util.ArrayList;
import java.util.List;

import collection.day10.myapp.*;

/* 
    JavaWordApp_V4  메모장 list 초기화를 initialize  메소드를 사용하지 않고 
                    단어장.txt 파일에서 읽어오도록 변경

                    단어장 객체를 생성할 떄 읽어올 단어장 파일을 꼭 전달해야 합니다. 
                    단어장 파일의 데이터로 리스트를 초기화 했습니다.


 * 메소드 만드는 연습
 * 검색 메솓, print  메소드 //리펙토리 (refactorying)
 * 
 * 
 * 객체지향 프로그램밍은 최대한 객체로 분리시켜서
 *          실행되는 환경에 독립적이 되도록 합니다.
 * 
 * 
 * JavaWord :단어객체
 * JavaWordList : 단어장 객체 
 * 
 */
public class JavaWordApp_V4 {
    // private : JavaWordList
    // 
    //private List<JavaWord> words = new ArrayList<>();
    private JavaWordList words = new JavaWordList("단어장.txt");
    // 프로그램 시작
    
    private void start() { //   V4 파일에서 단어장 읽어오기 
        // initialize();// words 리스트 요소를 몇개만 미리 저장해서 초기화(테스트용)
        // 단어 등록,목록,검색,삭제 기능을 메뉴로 구현합니다.
        words.fileLoad();
        System.out.println("단어장 프로그램 시작합니다~ " + "~".repeat(20));
        while (true) {
            System.out.println("\t<<<메뉴를 선택하세요>>>");
            System.out.println("\t1.단어 등록");
            System.out.println("\t2.단어 목록 조회");
            System.out.println("\t3.단어 검색");
            System.out.println("\t4.단어 삭제");
            System.out.println("\t5.프로그램 종료");
            words.fileSave();
            System.out.print("\t선택>>"); // 메소드에 입력기능이 있을때는 Scanner관리가 불편

            int select = Integer.parseInt(System.console().readLine());// -> (키보드 입력 문자열) 정수형
            // System.console(): 시스템의 콘솔(표준입출력장치) 객체를 리턴, readline() 입력메소드 실행
            switch (select) {
                case 1:
                    add(); // 단어 등록 메소드 실행
                    break;
                case 2:
                    listWord(); // 단어 목록 조회메소드 실행
                    break;
                case 3:
                    searchWordBy(); // 단어 목록 조회메소드 실행
                    break;
                case 4:
                    removeWord(); // 단어 목록 조회메소드 실행
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // main 종료
                    break;
                default:
                    System.out.println("잘못된 선택값 입니다.");
                    break;
            }

        }
    }
    // 프로그램 실행하는 객체 생성하고 (메소드로 기능을 분리할 때
    // main 이 호출하는 static 을 없애기 위함.)
    // start 메소드 프로그램 실행 내용을 코딩

    private void add() {
        System.out.println("\t\t:: 단어 등록 ::");
        System.out.print("\t:: 영어 단어 입력하세요 ::");
        String english = System.console().readLine();
        System.out.print("\t:: 한글 의미 입력하세요 ::");
        String korean = System.console().readLine();
        System.out.print("\t:: level 입력하세요 ::(1.초급 2.중급 3.고급)");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));

    }

    private void removeWord() {
        System.out.println("\t\t:: 단어 삭제 ::");
        System.out.print("삭제할 단어를 영문으로 입력하세요>>");
        String find = System.console().readLine();
        int position = words.indexOfWord(find, 0);  //단어의 인덱스를 배열로 리턴
        if(position ==-1 ){ //인덱스 0부터 단어를 찾아서 -1이면 찾는 단어가 없음.
            System.out.println("삭제할 단어는 단어장에 없습니다.");
             return ;
        }
        while(position != -1){  //찾는 단어가 없을때 까지 반복하기 
            System.out.println("삭제할 단어 : "+ words.getWord(position));
            System.out.print("삭제는 엔터, 취소는 n 을 입력하세요 >>");
            if(!System.console().readLine().equals("n")){
            //단어 삭제 .
            words.remove(position);                    // 삭제후 다음인덱스는 -1  해주어야 함!!!
            System.out.println("삭제완료!");
            position--; //삭제했을 때 인덱스값이 모두 하나씩 작아짐.

        }
        position =words.indexOfWord(find, ++position); //단어의 인덱스를 배열로 리턴
        //position은 찾은 단어 다음 위치부터 다시찾기 
        
    }
    }
    /// JavaWordList 객체의 메소드를 이용해서 수정해보자!@!



    
    private void listWord() {
        // to-do 리스트 words 에 저장된 요소(항목)들을 모두 출력해보세요
        System.out.println("\t\t:: 단어 출력 ::");
        System.out.println(String.format("%-20s %-20s\t %-10s", "ENGLISH", "KOREAN", "LEVEL"));
        // for (int i = 0; i < words.size(); i++) {

        //     System.out.println(String.format("%-20s %-17s\t %d", words.get(i).getEnglish(), words.get(i).getKorean(),
        //             words.get(i).getLevel()));
        // }
        words.print();
    }



    private void searchWordBy(){
        System.out.println("\t ::: 단어 검색합니다. 단어 조회는 1. 레벨 조회는 2. :::");
        String find = null;
        List<JavaWord>list = null;
        switch (System.console().readLine()) {
            case "1":
            System.out.print("검색한 단어를 영문으로 입력하세요>>");
            find = System.console().readLine();
            list = words.searchAllByEnglish(find);
            break;
            case "2":
            System.out.print("검색할 레벨을 입력하세요>>>");
            int level = Integer.parseInt(System.console().readLine());
            list = words.searchAllByLevel(level);
            break;
            
            default:
            System.out.println("1,2만 입력하세요");
            break;
        }
        System.out.println("\t::: 검색 결과입니다.:::");
        if(list.size()==0) System.out.println("단어장에 찾는 단어가 없습니다.");
        else JavaWordList.print(list);
    }






    public static void main(String[] args) {
        JavaWordApp_V4 app = new JavaWordApp_V4();
        app.start();
    }
}
