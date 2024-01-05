package day6;

public class B06ProductMain {
    public static void main(String[] args) {
        //Product 객체를 4개 만들어보겠습니다 .


        Product snack =new Product("홈런볼",1200,"해태", new String[3]);
        Product drink =new Product("포카리",1000,"오츠카", new String[3]);
        Product fruit =new Product("망고",500,"필리핀", new String[3]);
        Product icecream =new Product("외계인",4200,"베스킨", new String[3]);



        //출력하기 
        System.out.println(snack);
        System.out.println(drink);
        System.out.println(fruit);
        System.out.println(icecream);
            // 출력문
            // day6.object.day6.Product@2f92e0f4        -
            // day6.object.day6.Product@28a418fc        
            // day6.object.day6.Product@5305068a
            // day6.object.day6.Product@1f32e575 
            //      패키지이름.클래스이름@ 참조값(식별값),주소

        System.out.println(snack.getDate());
        System.out.println(drink.getDate());
        System.out.println(fruit.getDate());
        System.out.println(icecream.getDate());

        //QUIZ!!  snack 의 etc 필드 배열요소 0번에 "10개 묶음 " 문자열을 저장하기.
        
        String[] temp = snack.getEtc();
        temp[0]="10개 묶음";
        temp[1]="BOGO";
        

        // System.out.println(snack.getDate());
        //snack.setPrices(1000);  //set메소드 없음 -> 오류
        //snack.price=1000;       //private   ->오류

        Product[] mycarts = new Product[8]; //Product 객체 배열 - product 객체의 참조값 저장 배열
        mycarts[0]=drink;
        mycarts[1]=icecream;
        //mycarts[2]=drink;         //비워둬보기
        mycarts[3]=fruit;
        mycarts[4]=snack;
        mycarts[5]=snack;
        mycarts[6]=snack;
        mycarts[7]=snack;




        //배열이므로 반복문으로 출력할수 있습니다.
        System.out.println("========바구니 출력=========");
        for(int i=0; i<mycarts.length;i++){
            if(mycarts[i]!=null)
            System.out.println((mycarts[i]).getDate());
        }




    }
}
