package basic.day2;

public class A09HangulCharTest {

    /*
     * 
     * 문자 '나' 부터 '냇' 까지 while 문으로 출력해보세요.
     * 변수 char start ='나';
     * 모두 몇개의 문자가 있는지 갯수 구하기
     * int codeNa, codeNet;
     * 
     */
    public static void main(String[] args) {
        char codeNa = '나';
        char codeNet = '낟';
        char start = codeNa;

        System.out.println("=====문자 '"+codeNa +"'' 부터 '"+ codeNet+"'' 까지 while 문으로 출력===== ");
        while (start <= codeNet) {
            System.out.print(" " + start++);
        }
        System.out.println();
        System.out.println();
        System.out.println("while문 이후에 start 에 값:"+start);
        
        
        System.out.println("'나'문자의 유니코드값(10진수):" + (int) codeNa + "\n");
        System.out.println("'냇'문자의 유니코드값(10진수):" + (int) codeNet + "\n");
        System.out.println("문자 '나' 부터 '냿' 까지 갯수는: " + (((int) codeNet - (int) codeNa) + 1) + "\n");

    }

}
