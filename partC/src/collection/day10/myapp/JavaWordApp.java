package collection.day10.myapp;

import java.util.List;
import java.util.Scanner;

public class JavaWordApp {
    public static void main(String[] args) {
        
        // 단어장을 시작하는 프로그램입니다. 
        //1. 단어장 생성
        JavaWordBook myBook = new JavaWordBook();


        //2. 단어 추가 
        JavaWord newWord = new JavaWord("public", "공용의", 1);
        myBook.addWord(newWord);
        myBook.addWord(new JavaWord("private", "개인적인", 1));
        myBook.addWord(new JavaWord("protected", "보호된", 1));
        myBook.addWord(new JavaWord("Iterate", "반복하는", 1));
        myBook.addWord(new JavaWord("collection", "수집", 1));
        myBook.addWord(new JavaWord("application", "응용의", 2));
        myBook.addWord(new JavaWord("binary", "2진수의", 3));
        
        //메모장 출력하기 
        myBook.wordAllPrinting();




        //3. 단어 조회
            // 1) 영어단어 입력하면 찾아주기
        Scanner sc = new Scanner(System.in);
        String findText="";

        while (true) {

            if(findText=="end")break;
            myBook.serchWord(findText);
            JavaWord result = myBook.serchWord(findText);
            System.out.println(findText + "조회 결과 : " + result);
            
        }




        // // 2) List<JavaWord> serchWordByLevel(int level): 레벨로 조회하기
        
         List<JavaWord> list=myBook.searchWordByLevel(1);
         myBook.wordListPrint(list);

        




        //4. 단어 삭제


    
    }
}
