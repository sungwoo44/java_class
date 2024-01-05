package day6;

import java.util.Scanner;

import day6.random;

public class AddQuizMain {
   
   
    public static void main(String[] args) {
        // 10개의 덧셈 문제 생성
        Scanner sc = new Scanner(System.in);

        int userAnswer = 0;
        for (int i = 0; i < 10; i++) {
            Addquiz problem = new Addquiz();
            System.out.print((i + 1)+"문제 " + problem.getProblem());
            userAnswer = sc.nextInt();
        }


        for(int i =0; i<10; i++){
            
        }
    }
}