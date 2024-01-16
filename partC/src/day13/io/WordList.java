package day13.io;

import java.util.List;

import collection.day10.myapp.JavaWord;
// '자바단어장' 클래스는 아래의 추상메소드를 꼭 구현해야합니다.

public interface WordList {

    //최대 단어개수(100개)를 설정한다면.....
    int MAX_LENGTH=100;
    //추상메소드 정의 : 구현 내용은 클래스의 특징에 따라 정의됩니다.
    JavaWord getWord(int i);
    List<JavaWord> list();
    void add(JavaWord word);
    int indexOfWord(String english,int position);
    JavaWord remove(int index);
    List<JavaWord> searchAllByEnglish(String english);
    void print();


// Tip 
    //if 
    // 이미 구현 클래스 외에 적용하고 싶은 메소드가 있다면 --->> default
    //defualt 키워드로 정의하면  이미작성된 코드에 오류나지 않아~
    default List<JavaWord> search(Object object){
        return null;
    } 
} 