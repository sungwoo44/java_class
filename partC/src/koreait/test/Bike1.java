package koreait.test;       

/* 장성우 */
public class Bike1 extends Product1 {

    private int speed;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bike1(int price, String prdName, int speed) {
        this.price= price;
        this.prdName= prdName;
        this.speed = speed;
    }

    public String ride(){
        return "당신은 이것을 시속 "+speed+"km로 탈수 있습니다.";
    }
 
    @Override
    public String sell(Object object){
          return (String.format("[%s] 행사 - %d %%  인하",prdName,object));
    }
    
    @Override
    public String toString() {
        return "Product [price=" + price + ", prdName=" + prdName +",speed=" +speed+"]";
    }

    

    
}

class Electronics1 extends Product1{


    private double kwh;


    public double getKwh() {
        return kwh;
    }


    public void setKwh(double kwh) {
        this.kwh = kwh;
    }


    public Electronics1(int price,String prdName) {
        this.price= price;
        this.prdName= prdName;
    }

    public double power(){
        return kwh*24;
    }
    
    @Override
    public String sell(Object object){

        return (String.format("[%s] 증정 - %s", prdName,object));

    }
     
    @Override
    public String toString() {
        return "Product [price=" + price + ", prdName=" + prdName +",kwh=" +kwh+"]";
    }

   
}
