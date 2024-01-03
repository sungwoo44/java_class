package basic.day4;
//변수의 선언 위치 -> 변수 사용범위가 결정됩니다. 
public class A21VariableArea {

    int number = 999;               //1.클래스 범위에서 사용되는 변수
    static int number2 = 999999;       //1.클래스 범위에서 사용되는 변수
   
    public static void main(String[] args) {
        
        int a = 23;         //2. main 메소드 범위에서 사용되는 변수 

        for (int i = 0; i < 10; i++) {  //3.특정 블록(for) 블럭 안에서 사용되는 변수 -i
            System.out.println("i=" + i);
        }

        while(a==23){                   //3. 특정 블록(while) 블럭 안에서 사용되는 변수 - count
            int count; 
            System.out.println("a="+a);
            count=100;
            System.out.println("count="+count);
            System.out.println("number2="+number2);
            a=24;
            
        }
        System.out.println("a="+a);
        // System.out.println("i=" + i);             // 문법오류    'i' 는 이 범위에서 알수없는 변수
        // System.out.println("count="+count);      //문법오류 'count'는 이 범위에서 알수 없는 변수
        //System.out.println("number="+number);     // main 메소드가 static메소드 static은 static 끼리만 서로 사용할 수 있다. 
                                                     // static 이 아인 클래스 선언 변수는 사용못함.

                                                    //class 변수, 특정블록변수, static 변수
        System.out.println("number2="+number2); //
    }//main
}//클래스
