package Object_Interface;

import BeAble.Ai;
import BeAble.BeAble;
import BeAble.Cookable;
import BeAble.Dog;
import BeAble.Human;
import BeAble.Thinkable;
import BeAble.Runnable;

public class B19BeAbleMain {

    public static void main(String[] args) {
        
        Thinkable th1 = new Human(); 
        Thinkable th2 = new Ai();
       
        Ai ai  = (Ai)th2;
        ai.setOp('*');
        
        Runnable run1 = new Human();
        Runnable run2 = new Dog();


        Cookable cook = new Human();

        BeAble[] beAbles = new BeAble[3];
        beAbles[0]= th1;
        beAbles[1]= th2;
        beAbles[2]= run2;

        System.out.println("beAble test");
        for(BeAble able : beAbles){
            System.out.println(able.beAble());
            
            //다운캐스팅
            if(able instanceof Thinkable){
                Thinkable temp = (Thinkable)able;
                System.out.println(able.getClass().getName()+ " 이 계산함");
                
                char op = temp instanceof Ai ? ((Ai)temp).getOp() : '+';

                System.out.println("\t연산~"+op);
                System.out.println("\t정답~"+(temp).calculate(3,2));
                
            }
            else{
                System.out.println(able.getClass().getName()+ " 은 계산 못함");

            }

            //결론 : 업캐스팅 다운캐스 목적은 상속과 같은 방식으로 사용합니다.
                    // 업캐스팅: 다형성.  업캐스팅 타입이 갖는 메소드만 실행.
                    // 다운캐스팅 : 업캐스팅 타입이 갖는 추상 메소드가 아닌 메소드를 실행하기위함.
        }

        

        
    }
    
}
