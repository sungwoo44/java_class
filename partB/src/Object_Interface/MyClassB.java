package Object_Interface;

//인터페이스를 다중(여러개)으로 사용하는 구현 클래스 연습입니다.

//상속은 	   단일상속
//인터페이스는 다중구현
public class MyClassB implements InterfaceA , InterfaceX {
		
	//InterfaceA의 추상메소드 구현
	@Override
	public void methodA() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int methodB(int num) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//InterfaceX의 추상메소드 구현
	@Override
	public String methodX() {
		// TODO Auto-generated method stub
		return "나는 테스트";
	}
}
