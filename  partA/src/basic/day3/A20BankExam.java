package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true; // while문에서 사용할 조건 변수.
        int menu;
        int money;
        int balance = 0;

        DecimalFormat df = new DecimalFormat("#,###원"); // 세자리마다 ',' 표시하고 '원' 출력하기 
        while (run) {

            System.out.println("---------------------------------");
            System.out.println("1:예금   2:출금   3.잔액   4.종료");
            System.out.println("---------------------------------");
            System.out.print("메뉴 선택 >>>> ");

            menu = sc.nextInt();
            
            switch (menu) {
                case 1: // menu==1 ?
                    System.out.print("예금액 > ");
                    money = sc.nextInt();
                    balance += money;
                    System.out.println("고객님의 잔액은 " + df.format(balance) + "입니다.👩‍💼💰");
                    break; // 아래의 명령어들을 실행하지 않고 switch{ .. } 를 끝냅니다.
                case 2: // menu==2 ?
                    System.out.print("출금액 > ");
                    money = sc.nextInt();
                    if(money>balance) {
                        System.out.println("잔액을 초과하셨습니다.ㅠㅠ");
                        break;
                    }
                    balance -= money;
                    System.out.println("고객님의 잔액은 " + df.format(balance) + "입니다.👩‍💼💸");
                    break;
                case 3: // menu==3 ?
                    System.out.println("현재 잔액은 " + df.format(balance) + "입니다.👩‍💼💵");
                    break;
                case 4: // menu==4 ?
                    System.out.println("종료 입니다.");
                    run = false;
                    break;

                default: // 값이 1,2,3,4,5 모두 아닌경우
                    System.out.println("잘못된 선택 입니다.");
                    break;
            } // switch 끝

        } // while 끝

        System.out.println("프로그램 종료");
    }
}
