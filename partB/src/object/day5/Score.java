package object.day5;

import java.util.Arrays;

public class Score {
    
    //인스턴스 필드 
    private String name;        //학생 이름
    private int grade;          //학년
    private int[] jumsues;      // 점수들이 저장될 배열
    
    //인스턴스 메소드: 인스턴스 필드를 사용하는 처리를 합니다. 

    // Score(){
    // }//배열의 크기는 학년마다 다를수 있음/
    // Score(String name, int grade, int[]jumsues){
    //     this.name = name;
    //     this.grade = grade;
    //     this.jumsues = jumsues;
    // }

    //getter
    public String getName(){
        return name;
    }
    public int getGrade(){
        return grade;
    }
    public int[] getJumsues(){
        return jumsues;
    }


    
    //setter
    public void setName(String a){
        name=a;
    }
    public void setGrade(int a){
        grade=a;
    }
    public void setJumsues(int[] a){
        jumsues=a;
    }

    //점수의 합계를 리턴하는 sum()메소드
    public int sum(){
        int sum=0;
        for(int i=0;i<jumsues.length;i++){
            sum+=jumsues[i];
        }           
        return sum;
    }


    //점수의 평균 double 리턴하는 average() 메소드
    public double average(){
       
        double avr=0;
        avr = (double)sum() / (jumsues.length);        
        return avr;
    }

    //모든 인스턴스 필드값을 확인 출력하는 printScore() 메소드
    public void printScore(){
            
            System.out.println(Arrays.toString(jumsues));
            System.out.println("=====================");
        
    }

}
