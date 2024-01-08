package day6;


import java.util.Random;
import java.util.Scanner;

public class AddQuizMain {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);       

        int correctCount = 0;                       
        int questions = 10;                      
        int start = 11;                            
        int end =99;                                
         
        Addquiz[] addQuiz = new Addquiz[questions];    
        System.out.println("덧셈 "+questions+"문제 퀴즈를 시작합니다.");

        for (int i = 0; i < questions; i++) {
            int data1 =  (int)(Math.random()*(end-start+1))+start;  
            int data2 =  (int)(Math.random()*(end-start+1))+start;
            
            addQuiz[i] = new Addquiz(data1, data2);                 
    
            Addquiz q2 = addQuiz[i];
            System.out.println(String.format("%d문제 %d+%d= ?", (i + 1), q2.getNum1(), q2.getNum2()));
            System.out.print("답을 입력하세요>>>");
            int temp=sc.nextInt();
            q2.setUserAnswer(temp);


            if (q2.isRight(temp)) {
                correctCount++;
            }
        }

        System.out.println("\n::::::채 점 중 입 니 다::::::");
        System.out.println(String.format( "%10s %4s %3s %3s","문제","제출답","정답","채점" ));

        for (int i = 0; i < questions; i++) {
            Addquiz q2 = addQuiz[i];
            System.out.println(String.format("%-2d 번 %4d+%d / %-4d / %-4d %3c", (i + 1), q2.getNum1(), q2.getNum2(),
                    q2.getUserAnswer(), (q2.getNum1() + q2.getNum2()),(q2.isRight())));
        }

        System.out.println(String.format("\n:::맞은 갯수 %d 입니다.:::", correctCount));

        
    }
}

