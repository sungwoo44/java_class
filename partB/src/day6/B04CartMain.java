package day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CartMain {
    public static void main(String[] args) {
        
         
         Cart momo_Cart = new Cart();

         String[] products ={"Liverpool", "Arsenal", "Chelsea","Mancity","Tottenham","Astonvilla","Westham","Brighton","Newcastle","Wolves"};
         int[] prices= {900,300,200,400,500,600,100,700,800,100};


        //장바구니 값 저장 
        momo_Cart.setUserid("momo");
        momo_Cart.setProductName(products);
        momo_Cart.setPrices(prices);



         Scanner sc = new Scanner(System.in);

         System.out.println(momo_Cart.getUserid()+"의 장바구니입니다.");
         System.out.println(String.format("%s\t %2s\t %10s\t\t","번호","상품명","가격"));

         
         for(int i=0; i<momo_Cart.getProductName().length;i++){
            System.out.println(String.format(" %-7d %10s %8s", i,products[i],prices[i]));

         }

         System.out.println("구매할 상품 번호를 선택하세요. 선택 종료는 -1 입니다.");
         int sel = 0;
         int [] select = new int[10];

         int k = 0;
         while(sel !=-1 && k<select.length){
            System.out.print("상품번호 입력 >>> ");
            sel = sc.nextInt();
            //sel의 선택범위는 productNames 범위값만
            if(sel<-1 || sel>momo_Cart.getProductName().length-1){
                    System.out.println("없는 품목입니다. ");
                    continue;
            }
            select[k++]=sel;
            
         }
         if(k==select.length){
            System.out.println(" 그만!그만! ");
         }
        momo_Cart.total_Money(select);
         System.out.println("선택하신 팀"+Arrays.toString(select));
         System.out.println("모모님이 선택하신 상품 합계 : "+ momo_Cart.getTotal_Money());
         

         // 필요에 따라서는 기존의ㅏ setter 메소드는 사용하지 않고 
         // 추가적인 비지니스로직을 구현하는 메소들 만듭니다. --> total_Money() 메소드
    }
}
