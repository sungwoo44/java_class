package collection.day10.myapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//JavaWord 여러개를 저장할 클래스 
//          조회기능에 유리한  Map을 사용하겠습니다.
//          조외 이외에는 특히 출력하는 map.values()로 value 값만 사용.
public class JavaWordBook {
    private Map<String,JavaWord>wordBook;

    //key :  영어단어 , key 같은 중복이 안되고 순서가 없습니다.
    //value : JavaWord(영어, 한글 ,레벨)
    public JavaWordBook() {
        this.wordBook=new TreeMap<>();
        //key 값인 영어 단어 순으로 정렬하여 접근.
    }
    //getter
    public Map<String, JavaWord> getWordBook() {
       return this.wordBook;
       
    }

    //단어 추가 
    public void addWord(JavaWord word){
        this.wordBook.put(word.getEnglish(), word);
    }

    //map의 특징 _ key 값을 이용해서 조회와 삭제 할 수 있습니다.
    //단어 조회 : (비교) 리스트에서는 for 반복으로 찾기 
    public JavaWord serchWord(String english){
        return this.wordBook.get(english);

    }
    
    // 단어 삭제 :  (비교) 리스트에서는 for 반복으로 찾기 . 인덱스로 삭제.
    public void removeWord(String english){
        this.wordBook.remove(english);
    }

    // 전체 단어 출력하기 1
    public void wordAllPrinting(){
        // TreeMap은 정렬되어 있으므로 Map 의 values를 리스트로 변환하여 출력메소드로 전달하기
        List<JavaWord> all = new ArrayList<>(this.wordBook.values());//**** */
        WordListPrint(all);
    }
    // 전체 단어 출력하기 2
    public List<JavaWord> wordAll(){
        // TreeMap은 정렬되어 있으므로 Map 의 values를 리스트로 변환하여 출력메소드로 전달하기
        List<JavaWord> all = new ArrayList<>(this.wordBook.values());//**** */
        return all;
    } 
    
    //인자로 전달된 list 출력하기 
    public  void print(){
        System.out.println("~".repeat(20)+" 단어장 "+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s","<english>","<korean>","<level>"));
        for(JavaWord word : this.wordAll()){
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }

    }

    public  static void WordListPrint(List<JavaWord> list){
        System.out.println("~".repeat(20)+" 단어장 "+"~".repeat(20));
        System.out.println(String.format("%-15s %-15s\t %s","<english>","<korean>","<level>"));
        for(JavaWord word : list){
            System.out.println(String.format("%-15s %-15s\t %d",word.getEnglish(),word.getKorean(),word.getLevel()));
        }

    }

//to-do 인자로 전달된 level 만 results 리스트에 저장하기
    public List<JavaWord> searchWordByLevel(int level){
        List<JavaWord> result = new ArrayList<>();
        for(JavaWord word : this.wordBook.values()){
            if(word.getLevel()==level)
                    result.add(word);
        }
        return result;


    }


    

}
