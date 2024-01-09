package BeAble;

public class Dog implements Runnable{
    

    @Override
    public String run(int speed) {
        return "사람은 " +  speed +"km/h 로 달립니다. \n 최대속도 10km/h";        
    }

    @Override
    public String beAble() {
       
        return " 달리기";
    }
    
}
