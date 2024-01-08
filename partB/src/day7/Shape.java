package day7;


//

/*  클래스의 상속		//자바에서 제공하는 클래스들의 상속관계를 이해하기 위함. 우리가 직접 만드는 것은 몇가지 정도.....
		ㄴ 자세하게(구체화된) 클래스를 만든다면 .. 삼각형,정사각형,직사각형,사다리꼴...
		ㄴ 구체화할 때 Shape 클래스를 상속받는다.			//부모 클래스 shape 은 모든 도형들의 공통적인 필드와 메소드를 정의.
		ㄴ 상속받는 자식 클래스는 부모 클래스의 생성자를 호출해서 부모의 필드값을 초기화합니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 사용할수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 필드값을 가져올수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 재정의(오버라이딩) 할수 있습니다.

	↓ Shape 클래스는 추상적인 상태. 모든 도형을 대표하는 클래스로 정의하였습니다.
 */
public class Shape {    

		//기본생성자
		public Shape(){
				// 아래 커스텀 생성자 있을 때는 기본생성자 사용하기 위해서 직접 정의!
				 System.out.println("새로운 도형이 만들어 졌습니다. 초기화 필요");
		}

		public static final int MAX_WIDTH=100;    //상수 // 최대너비를 제한시킴. // 상속의 의미가 없음.
		// 인스턴스 필드
		private String shapeName;		//도형 이름
		
		private int width;				//도형의 크기 중 너비
		private int height;				//도형의 크기 중 높이
		
		//  접근한정자 테스트용 인스턴스 필드
		protected String etc;			// 자식에서  set생성 가능하도록  protected!!
		int accessModifier;
		public int border;
		
		
		// 인스턴스 필드값 초기화하는 생성자
		public Shape(String shapeName, int width,int height) {
			this.shapeName=shapeName;
			this.width=width;
			this.height=height;
			
		}
		
		// 필드값을 리턴하는 getXXX 메소드
		public String getShapeName() {
			return shapeName;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		// setXXX 메소드 없음.('초기값을 바꿀수 없다'는 요구조건을 예시로 합니다. )
		
		//단, : shapeName  만  setter  추가
		public void setShapeName(String shapeName) {
			this.shapeName = shapeName;
		}
		

		
		// 도형의 면적(넓이) 계산하는 메소드 (계산식은 너비 *높이)
		public int calculateArea() {
			return this.width*this.height;
		}


		// 자식 클래스들이 draw 를 재정의 해서 다른 메시지가 출력되게 만들어보자!!!
		public void draw(){
			System.out.println("어떤 도형인지 모름...!");
		}
	
		// final 메소드 - 재정의 할수 없는 메소드로 만들어야 할때 사용합니다.
		public final void print() {
			System.out.println("final 메소드 테스트-" + shapeName + "의 너비:" + width +",높이:" 
					+height + ",면적:" + calculateArea());
		}

	
		
}









