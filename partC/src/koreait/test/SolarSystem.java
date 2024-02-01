package koreait.test;

public abstract class SolarSystem {
    protected int diaMeter; //천체의 직경 저장할 필드입니다
    //[1]
    protected String planetName;    //천체의 이름을 저장할 필드입니다

    //[2]
    public abstract String abstractMethod(Object object);   
    //      ㄴ추상메소드입니다. 행성(Planet)의 객체는 공전 횟수를 
    //                        위성(Satellite)의 객체엔 파견보낼 탐사선의 이름이 인자로 들어가게 구현할겁니다

    
    //[10]
    @Override
    public String toString() {
        return "diaMeter=" + diaMeter + ", planetName=" + planetName;
    }


}
