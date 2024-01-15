package IOday11;

import java.util.Scanner;

public class D01TryCatchTest {
    
    public static void main(String[] args) {
        // 예외 처리 구문: 비정상적인 종료에 대해 사용자에게 전달. 또는 이후의 명령을 계속 실행하도록 함.
        //NumberFormatException, ArrayIndexOutOfBoundsException 는 예외처리가 강제되지 않는다. ==>> ★Unckecked Exception!★

        try {
            //  예외가능성이 있는 명령문을 작성
numberException();
        } catch (NumberFormatException e) { //  <-- (인자) : 처리할 예외의 종류 : Exception은 모든 에외.
            
            // 예외가 발생할 떄 실행할 명령
            System.out.println("숫자만 입력하세요!!");
            System.out.println(e.getMessage());// 오류 원인

        }catch(ArrayIndexOutOfBoundsException e){

            System.out.println("인덱스 범위는 배열의 길이 -1 까지 입니다.");
            System.out.println(e.getMessage());// 오류 원인

        }
        System.out.println("(테스트) 마지막 명령어 입니다. (테스트)");
        
    }
    public static void indexException(){
        
        int[] arrays= {11,22,33,44,55};         
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[arrays.length]);      //ArrayIndexOutOfBoundsException  //Runtime Exception
        
    }
    
    
    public static void numberException(){
        
                Scanner sc = new Scanner(System.in);
                System.out.print("정수를 입력하세요 >>");
                int number =Integer.parseInt(sc.nextLine());    //문자열을 정수로 변환 //  Runtime Exception!
                System.out.println("입력한 값 : " + number);
                sc.close();
                
        
    }

}
