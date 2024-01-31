package koreait.test;

public class Bike2 extends Product2 {
 
    private int speed;

   public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Bike2(int price,String prdName,int speed){
    this.price=price;
    this.prdName=prdName;
    this.speed=speed;

   }
    
   public String ride(){
    return "당신은 이것을 시속 "+this.speed+"km 로 탈수 있습니다. ";
   }
    
   @Override
   public String sell(Object object){
        return String.format("[%s]행사 - %d %% 인하", this.prdName,object);

   }

    @Override
    public String toString() {
        return "Bike2   ["+super.toString()+" speed=" + speed + "]";
    }
    




}

 class Electronics2 extends Product2{

    private double kwh;

    public double getKwh() {
        return kwh;
    }
    public Electronics2( int price, String prdName) {
        super();
        this.price=price;
        this.prdName=prdName;
    }


    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    public double power(){
         return this.kwh*24;
    }


    @Override
    public String sell(Object object){
        return String.format("[%s] 증정 - %s ",this.prdName,object);

        
    }

    @Override
    public String toString() {
        return "Electronics2  ["+super.toString()+" kwh=" + kwh + "]";
    }
}
