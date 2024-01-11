package collection.day10.myapp;
/* 자바프로그램에서 사용되는 영어단어 데이터 저장할 클래스 */
public class JavaWord {
    private String english;
    private String korean;
    private int level;

    public JavaWord(String english, String korean, int level) {
        this.english = english;
        this.korean = korean;
        this.level = level;             // 0: 초급, 1: 중급 , 2:고급
    }

    @Override
    public String toString() {
        return "JavaWord [english=" + english + ", korean=" + korean + ", level=" + level + "]";
    }
    
    public String getEnglish() {
        return english;
    }

    public String getKorean() {
        return korean;
    }

    public int getLevel() {
        return level;
    }



    
}
