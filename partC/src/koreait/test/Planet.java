package koreait.test;


public class Planet extends SolarSystem{
    //[4]
    private double gSpeed;      //행성의 중력 가속도를 저장할 필드입니다

    //[4]
    public double getSpeed() {  //중력 가속도에 대한 getter와 setter입니다.
        return gSpeed;
    }
    public void setSpeed(double gSpeed) {
        this.gSpeed = gSpeed;
    }
    
    
    //[3]
    public Planet(int diaMeter, String planetName, double gSpeed) {
        //행성의 커스텀 생성자입니다. Bike로 했을때와 구조는 같습니다
        this.diaMeter = diaMeter;
        this.planetName = planetName;
        this.gSpeed = gSpeed;
    }

    //Bike 클래스의 ride()메소드를 살짝 바꿨습니다. 
    //높이와 중력 가속도를 기반으로 추락시간을 구하기 때문에 ride()때와는 달리 높이값을 인자로 주도록 구현하였습니다
    public String fall(int height) {    
        return String.format("%s에서 %dm로부터 떨어진 당신은 %.1f초 후 지면에 추락합니다.", this.planetName, height, (Math.sqrt(height*2/gSpeed)));
    }                                                                                           //ㄴ높이와 중력 가속도를 기반으로 추락시간을 무하는 수식인데 굳이 이해할 필요 없습니다.
                                                                                                //  어차피 공기저항도 고려되지 않아 실제와 다릅니다.

    //[8]
    @Override
    public String abstractMethod(Object object) {   
        //추상메소드 : 인자가 정수값일땐 공전횟수 문자열을 반환하도록 합니다.
        return String.format("[%s] 행성- 태양을 %d번 공전합니다.", this.planetName, object);
    }

    
    @Override
    public String toString() {
        return "Planet ["+super.toString() +", gSpeed="+ gSpeed + "]";
    }

    

    
}

class Satellite extends SolarSystem{
    //[6]
    private double period;     //위성의 자전주기를 저장할 필드입니다.

    public void setPeriod(double period) {  //자전주기에 대한 getter와 setter입니다.
        this.period = period;
    }
    public double getPeriod() {
        return period;
    }

    //[3]
    public Satellite(int diaMeter, String planetName){
        //위성의 커스텀 생성자입니다. Electronics로 했을때와 구조는 같습니다
        super();
        this.diaMeter = diaMeter;
        this.planetName = planetName;
    }

    //[7]
    public double perday() {    //지구의 하루동안 위성의 자전 횟수를 계산할 메소드입니다.
         return 1/period;
    }

    //[9]
    @Override
    public String abstractMethod(Object object) {
        //추상메소드 : 인자가 문자열일땐 탐사선 파견 문자열을 반환하도록 합니다.
        return String.format("위성 [%s]에 탐사선 %s호 파견", this.planetName, object);
    }

    //[10]
    @Override
    public String toString() {
        return "Satellite ["+super.toString() +", period="+ period + "]";
    }

    
    

}