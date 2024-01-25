package koreait.test;

//장성우

public class ProductApp1 {
    
    public static void main(String[] args) {
        

        //1
        Product1[] cart= new Product1[10];
        cart[0]=new Bike1(123000,"MTB",25);
        cart[3]=new Bike1(99000,"삼천리",15);
        cart[1]=new Electronics1(35000,"USB");
        cart[5]=new Electronics1(527000,"스마트TV");
        cart[7]=new Electronics1(2250000,"ig냉장고");
    
        //2

        Electronics1 tv = null;

        if(cart[5] instanceof Electronics1){
                tv = (Electronics1) cart[5];
                tv.setKwh(0.9);
                System.out.println(tv.power());

        }else{
            System.out.println("Electronics 타입으로 변경 불가");
        }

        

        //3

        for(Product1 p : cart) {
            if(p!=null && p.price>=100000)				
                System.out.println(p.toString());
        }	
        

        //4
        Bike1 bike=null;
        for(Product1 b : cart) {
            if( b!=null && b instanceof Bike1)
            bike = (Bike1)b; 
            System.out.println(bike.ride());
                

        //5 
    
        cart[3].sell(20);    
        
        //6 
        cart[5].sell("사운드바");
    }
}
}
    
