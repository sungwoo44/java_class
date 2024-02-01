package koreait.solution;

public class ProductApp {
    public static void main(String[] args) {
        //1)
        Product[] cart = new Product[10];
   
        cart[0] = new Bike(123000,"MTB",25);
        cart[3] = new Bike(99000,"삼천리",15);
        cart[1] = new Electronics(35000,"USB");
        cart[5] = new Electronics(527000,"스마트TV");
        cart[7] = new Electronics(2250000,"ig냉장고");
        


        //2)power  메소드 : electronics 자식 클래스의 메소드 
        //          현재 부모타입으로 참조하는 것을 자식타입으로 변경.
       
        System.out.println("문제2");
        // Electronics tv = null;
        if(cart[5] instanceof Electronics){
            Electronics tv = (Electronics)cart[5];
             tv.setKwh(0.9);
             System.out.println(tv.power());

        }else{
            System.out.println("Electronics 타입으로 변경 불가");
        }
        
        
        //3)  배열10개중 객체가 참조된건은 5개 , 나머지 5개는 null
        // -->  반복뭄ㄴ으로 실행할 때 반드시  null 이 아닌 것만 하도록 합니다. 
        // --> null 이면 메소드 실행 예외 발생!  
        


        System.out.println("문제3");
        for(Product p : cart){
            if(p!=null && p.price>=100000){
                System.out.println(p);
        }
        
        }

        
        Bike bike= null;
        for(Product p : cart){
            if(p != null && p instanceof Bike)
                bike = (Bike)p;
                System.out.println(bike.ride());

        }



        //4)
        System.out.println("문제4");
        Bike bb= null;
        for(Product B : cart){
            if(B!=null && B instanceof Bike){
                bb= (Bike)B;
                System.out.println(bb.ride());
             }
        }

        
        //5)
        System.out.println("문제5");
        System.out.println(cart[3].sell(20));
        

        //6)
        System.out.println("문제6");
        System.out.println(cart[5].sell("사운드바"));


/* 자바교제 p.204 

        라이브러기 클래스 : Product, Bike, Electronics (tip) ★★★★★ 자바 클래스들을 사용
                   ㄴ 프로그래밍에 필요한 재료로 사용되는 클래스 
                   ㄴ 인스턴스 메소드와  statc 메소드로 제공되는 기능을 사용함
    
        실행 클래스 : ProductApp
                   ㄴ main 메소드를 포함하여 ㄹ프로그램을 실행함
                   ㄴ main 메소드는 반드시 static 이어야 한다. 
                   ㄴ main 메소드를 위한 객체를 먼저 생성할 수 없다..


        설명 예시 : Bike 클래스의 sell 메소드 Object 인자값은 외부에서 줍니다. 
                                                            ↑ (외부) main or 다른 클래스 

                    라이브러리 클래스의 인스턴스 필드값은 실행될 때 결정된다. 
*/        

        






    }
}

