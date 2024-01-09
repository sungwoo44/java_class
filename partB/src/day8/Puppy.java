package day8;

public class Puppy extends Animal {
	public static final String TYPE ="강아지 ";
	
	public Puppy() {
	}
	
	public Puppy(String name, String color) {
		super(name,color);			//부모 클래스 생성자 호출. 인자를 전달함
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}
	//toString 을 재정의 하지 않으면 부모 toString 이 실행되고 부모의 TYPE 상수값 출력
					
	//					재정의 전 출력물
					// 	☆새로운 반려동물 가족이 생겼습니다.☆
					// 익명으로 만들어진 동물 클래스 : 소리 X
					// animal toString = ☆동물★  Animal [color=null, name=null]
					// ☆새로운 반려동물 가족이 생겼습니다.☆
					// 브라운 강아지는 멍멍 🐶🐶하고 짖습니다.
					// puppy toString =☆동물★ Animal [color=브라운, name=별루]

//						재정의 후 출력물
					// ☆새로운 반려동물 가족이 생겼습니다.☆
					// 익명으로 만들어진 동물 클래스 : 소리 X
					// animal toString = ☆동물★ Animal [color=null, name=null]
					// ☆새로운 반려동물 가족이 생겼습니다.☆
					// 브라운 강아지는 멍멍 🐶🐶하고 짖습니다.
					// puppy toString =☆강아지★ [color=브라운, name=별루]

}
