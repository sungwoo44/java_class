package BeAble;

public class Human implements Thinkable,Cookable,Runnable{


    @Override
    public int calculate(int a, int b){
             int reasult =0;
            if(a>=99999 && b>=99999){
                System.out.println("사람이 암산으로 할수 없는 연산입니다. ");
                return -99999;
            }else {
                System.out.println(" 암산 쌉가능!");
                 return reasult;
            }
    
}
    @Override
    public void think() {

            System.out.println(" 사람이라면 창의적으로 생각 가능  ");
            System.out.println(" 단, 데이터가 많은면 포기!!!!");
    }

    @Override
    public String beAble() {
            
        return "생각하고 요리하고 달리고~";
    }

    @Override
    public void cook(String material) {
            System.out.println(material+"을 이용해서 요리가능  ");
        
    }

    @Override
    public String run(int speed) {

        return "사람은 " +  speed +"km/h 로 달립니다. \n 최대속도 10km/h";
    }



    
}
