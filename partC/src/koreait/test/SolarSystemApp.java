package koreait.MySystem;

public class SolarSystemApp {
    
    public static void main(String[] args) {
        
        //[1]
        SolarSystem[] bodies = new SolarSystem[10];

        bodies[0] = new Planet(12756, "지구", 9.8);
        bodies[3] = new Planet(	6792, "화성", 3.7);

        bodies[1] = new Satellite(3476, "달");
        bodies[5] = new Satellite(21, "포보스");
        bodies[7] = new Satellite(12, "데이모스");


        //[2]
        System.out.println("\n문제2.");
        Satellite Phobos = null;
        if (bodies[5] instanceof Satellite) {
            Phobos = (Satellite)bodies[5];
            Phobos.setPeriod(0.3);
            System.out.println(String.format(String.format("포보스는 지구가 한번 자전하는 동안 %.1f번 자전합니다",Phobos.perday())));
        }else System.out.println("다운캐스팅 불가능");
        

        //[3]
        System.out.println("\n문제3.");
        for(SolarSystem body : bodies){
            if (body!=null && body.diaMeter>3000) { //직경이 3000이상인 천체들을 출력합니다
                System.out.println(body);
            }
        }

        //[4]
        System.out.println("\n문제4.");
        for(SolarSystem body : bodies){
            if (body!=null && body instanceof Planet) {
                Planet planet = (Planet)body;
                System.out.println(planet.fall(12000)); //12000m에서 떨어졌을때 추락시간을 계산합니다.
            }
        }

        //[5]
        System.out.println("\n문제5.");
        String result = bodies[3].abstractMethod(5);    
        //인자값이 정수값이므로 행성의 공전횟수와 관련된 문자열을 반환하는 메소드를 호출합니다
        System.out.println(result);

        //[6]
        System.out.println("\n문제6.");
        //같은 이름의 메소드지만 이번엔 인자가 문자열이므로 탐사선과 관련된 문자열을 반환하는 메소드를 호출합니다
        System.out.println(bodies[5].abstractMethod("포누리"));

    }
}

/*
 * 자바 교재 204페이지
 * 라이브러리 클래스 : Product, Bike, Electroics 그리고 자바 클래스들
 *                   ㄴ프로그래밍에 필요한 재료로 사용되는 클래스
 *                   ㄴ인스턴스 메소드와 static 메소드로 제공되는 기능을 사용함
 * 실행 클래스 : ProductApp
 *                   ㄴmain 메소드를 포함하여 프로그램을 실행함
 *                   ㄴmain 메소드는 반드시 static 이어야 함
 *                   ㄴmain 메소드를 위한 객체를 먼저 생성할 수 없다. 그래서 static
 * 
 * 설명 예시 : Bike 클래스와 sell메소드 Object인자값은 외부에서 준다
 *            여기서 외부는 이 메소드를 사용하는 main또는 다른 클래스를 말함.
 *            라이브러리 클래스의 특히 인스턴스 필드값은 실행될 때 결정된다 > 인스턴스 메소드도 만찬가지로 실행될때 결과값이 결정된다
 */