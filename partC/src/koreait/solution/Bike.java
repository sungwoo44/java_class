package koreait.solution;
//0) 객체의 구성요소 : 인스턴스 필드와 인스턴스 메소드
//   클래스 구성요소 : 객체의 구성요소 + static 메소드 필드


public class Bike extends Product{
    //4)
    private int speed;
    //4)
    public int getSpeed() {
        return speed;
    }
    //4)
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    //3)
    public Bike(int price,String prdName,int speed) {
            this.price=price;
            this.prdName=prdName;
            this.speed=speed;
      //  super();  생략가능        자식클래스는 부모생성자 반드시 호출한다. 
      //  prdName, price 는 proteced 필드이므로 자식은 직접 접근 가능
    }
      //5) getter ,setter, ride 메소드 : 인스턴스 필드 변수라는 것을 가독서 있게 해줍니다.
      public String ride(){         // this.는 생략가능 객체의 필드라는것을 전달하기위함.
         return "당신은 이것을 시속 "+this.speed+"km로 탈수 있습니다.";
      }
    
    //8)추상클래스 상속 받았으므로 추상메소드 재정의
    @Override
    public String sell(Object object) {
        return String.format("[%s] 행사 - %d %%  인하",this.prdName,object);
    }
    @Override
    public String toString() {
        return "Bike ["+super.toString()+"speed=" + speed + "]";
    }

    //10)
   

}

class Electronics extends Product {

     private double kwh;

    public void setKwh(double kwh) {
        this.kwh = kwh;
    }

    //3) price,prdName 필드값만 초기화 - 생성자
    public Electronics (int price, String prdName){
        super();
        this.price=price;
        this.prdName=prdName;
    }

    //7)
    public double power(){
        return this.kwh*24;
    }

    //9)
    @Override
    public String sell(Object object) {
        return String.format("[%s] 증정 - %s", this.prdName,object);
    }

   
    //10) prodcuct 클래스에서 toString 재정의 한것을 자식 클래스가 다시 재정의 
    @Override
    public String toString() {
        return "Electronics ["+super.toString()+" kwh=" + kwh+ "]";
    }
   
}
