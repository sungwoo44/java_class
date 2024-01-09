package Object_Interface;

public class B17MyClassBMain {
    
public static void main(String[] args) {
    
    //구현 클래스 객체 생성

    MyClassA my1 = new MyClassA();
    MyClassB myb = new MyClassB();



    //업캐스팅 --> B14참고

    
    InterfaceA ifa = new MyClassB();

    //InterfaceX ifx1 = new MyClassA();
    InterfaceX ifx = new MyClassB();



    myb.methodA();
    ifa.methodA();
    //ifx.methodA();    //오류: methodA 는 InterfaceA 추상메소드
                        //다른 인터페이스 참조 타입으로는 메소드 실행 못함

    ifx.methodX();
    //ifa.methodX();    //오류: methodX 는 InterfaceX 추상메소드
                        //다른 인터페이스 참조 타입으로는 메소드 실행 못함

    InterfaceX ix = (InterfaceX)ifa;
    ix.methodX();
}


}
