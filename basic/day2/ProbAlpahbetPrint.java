package basic.day2;

/*
 * 
 * 1.     ++연사자오하 println()을 여러번 사용해서 
 *         A~Z까지 출력
 * 
 *                  hint) char start ='A'; 로 시작
 * 
 * 2.       Z~A 까지 출력
 */
public class ProbAlpahbetPrint {
    public static void main(String[] args) {

         char start = 'A';
        System.out.println("=====A~Z 까지 출력하기=====");

        for (int i = 0; i < 26; i++) {
            System.out.print(start++);
        }
        
        System.out.println("\n");
        start = 'Z';
        
        System.out.println("=====Z~A 까지 출력하기=====");

        for (int i = 0; i < 26; i++) {
            System.out.print(start--);
        }
    }
}
