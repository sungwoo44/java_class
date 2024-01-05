package day6;

import java.util.Random;

class Addquiz {
    private int num1;
    private int num2;
    private int answer;

    public Addquiz() {
        Random random = new Random();
        this.num1 = random.nextInt(90) + 10; // 10 이상 99 이하의 난수
        this.num2 = random.nextInt(90) + 10; // 10 이상 99 이하의 난수
        this.answer = this.num1 + this.num2;
    }

    public String getProblem() {
        return num1 + " + " + num2 + " = ?";
    }

    public int getAnswer() {
        return answer;
    }

     private static boolean checkAnswer(Addquiz problem, int userAnswer) {
        return userAnswer == problem.getAnswer();
    }
}
