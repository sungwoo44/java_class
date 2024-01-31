package koreait.test;

public class ProductApp2 {
    public static void main(String[] args) {
        
        Product2[] cart = new Product2[10];

        cart[0]=new Bike2(123000, "MTB", 25);
        cart[3]=new Bike2(123000, "MTB", 25);
        cart[1]=new Electronics2(35000,"USB");
        cart[5]=new Electronics2(527000,"스마트TV");
        cart[7]=new Electronics2(2250000,"lg냉장고");


         Electronics2 tv = null;

         if(cart[5] instanceof Electronics2){
            tv=(Electronics2)cart[5];
            tv.setKwh(0.9);
            System.out.println(tv.power()); 
         }
         else {
            System.out.println("전자기기 타입으로 변경 불가");
         }
           

        for(Product2 p : cart){
            if(p!= null && p.price>=100000){
                System.out.println(p);
            }
        }

        Bike2 bike= null;
        for(Product2 b : cart){
            if(b !=null && b instanceof Bike2){
                    bike= (Bike2)b;
                    System.out.println(bike.ride());
            }
        }

        cart[3].sell(20);
        cart[5].sell("사운드바");
    }
    
}
