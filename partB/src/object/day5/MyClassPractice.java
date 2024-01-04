package object.day5;

public class MyClassPractice{
    
    String carName;
    int carSpeed;
    double[] carCode;

    private String aniName;
    private int aniAge;
    private double[] aniCode;

    //getter
    public String getAniName(){
        return aniName;
    }

    public int getAniAge(){
        return aniAge;
    }

    public double[] getAniCode(){
        return aniCode;
    }

    //setter
    public void setAniName(String a){
        aniName=a;
    }
    public void setAniAge(int a){
        aniAge=a;
    }
    public void setAniCode(double[] a){
        aniCode=a;
    }

    public void printCar(){
        System.out.println(String.format("carName:%s\n carSpeed:%d\n carCode:%d",carName,carSpeed,carCode));
    }

    public void printAni(){
        System.out.println(String.format("aniName:%s\n aniAge:%d\n aniCode:%d",aniName,aniAge,aniCode));
    }
}

