package Object_Interface;

public class B16MyclassAMain {
    public static void main(String[] args) {
        
        //인터페이스는 객체 생성 못함. 
        //단, 익명 내부 타입으로 정의는 가능.
       // InterfaceA ifa= new InterfaceA() ;

        //구현 클래스로 객체 생성
        MyClassA mya = new MyClassA();

        // 업캐스팅 가능(정확히 업캐스팅은 아니지만.. 이해하기 쉽도록)
        InterfaceA ifa = new MyClassA();

        // 다운 캐스팅 가능(정확히 다운캐스팅은 아니지만.. 이해하기 쉽도록)
        MyClassA temp = (MyClassA)ifa;
        System.out.println("참조타입변수와 상관없이 똑같이 실행됨.");

    }
}
