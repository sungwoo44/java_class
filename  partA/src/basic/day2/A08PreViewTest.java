package basic.day2;

public class A08PreViewTest {

    public static void main(String[] args) {
        
    char start = 'A'; // 코드값 'A'=65

    //반복 명령 while  맛보기 

    while(start <='Z'){         //'Z'=90
        System.out.print(start++);
    }

    System.out.println();

   // start = 'Z';
    while(start >'A'){
        System.out.print(--start);
    }
}
}

