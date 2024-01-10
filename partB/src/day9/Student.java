package day9;

public class Student {
    private String name;
    private int age;

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }



    public Student(String name, int age){
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return String.format("Student [name= %s, age=%d]\n ",this.name,this.age);
    }

/* 
    Member 클래스 compareTo 의 문제점. 비교기준 또는 정렬 방법을 변경하려면 클래스 내부의 
                    compareTo  메소드 구현의 return 값을 변경해야 한다. (불편!!!!!) 다른프로그램의 영향!!!
                     so, 개선된방법으로 바꿔보자....!
                     
*/    
}
