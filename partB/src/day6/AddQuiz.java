package day6;

import java.util.Random;

class Addquiz {
    private int data1;
    private int data2;
    private int userAnswer;


    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int getNum1() {
        return this.data1;
    }
    
    public int getNum2() {
        return this.data2;
    }
    
    public int getUserAnswer() {
        return this.userAnswer;
    }
    
    public Addquiz(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public boolean isRight(int userAnswer){
        return (data1 + data2)==getUserAnswer(); 
    }

    public char isRight(){
        return getUserAnswer()==(getNum1() + getNum2()) ? 'O' : 'X'; 
    }
    
    
}
