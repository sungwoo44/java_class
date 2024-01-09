package day8;


public class AnimalCommunity {

	public static void main(String[] args)  {
		System.out.println("※※※※유기동물 분양소※※※※");
			Animal[] animals = new Animal[10];
			animals[0] = new Puppy("푸들이","브라운");
			animals[1] = new Cat("그레이");
			animals[2] = new Rabbit();
			animals[2].setColor("화이트");
			animals[3] = new Puppy("말티즈","화이트");

			//퀴즈!!!  아래 객체를 배열 요소에 대입했습니다 수정이 필요한 코드는??
			animals[7] =new Animal() {
				static final String TYPE ="새";

				 @Override
				 public void sound() {
				System.out.println(" 앵무새는 안녕~~~ 하고 말합니다.");	 
				 }

				 @Override
				 public String toString() {
					return TYPE+"[color=" + color + ", name=" + name + "]";
				 }
			};

			//퀴즈 추가 코드
			animals[7].setName("타조");
			animals[7].setColor("초록색");
			

			System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
			for(int i=0;i<animals.length;i++) {
				if(animals[i]!= null)				//배열요소에 참조되는 객체가 있는지 검사
					animals[i].sound();				// null 일때 실행하면 오류
			}	
			
	//	모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	//  동물 보호소 규정(비지니스 로직)
	//			ㄴ강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그밖에 20세이상 분양받을 수 있습니다.		
			//  ㄴ Member 클래스 isAdopt 메소드 실행. --> instandof 연산 사용
		
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);				//Member 클래스 인스턴스 필드는 age, name 2개
		
		StringBuilder sb = new StringBuilder(name);			// String 은 문자열 연결결과 다른 문자열이 나오면 객체를 새로만들어 저장 (비효율)
		
		//String 은 불변객체 (문자열 변경 불가), StringBuilder 는 가변 객체(문자열 변경 가능. 문자열 추가 연산결과를 동일 객체에 저장 )(효율)
		//											ㄴ 문자열 연결연산에 사용
		sb.append(" 회원님 \n");						//message +="회원\n";
		boolean result;
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) continue;
				//break;	// 첫번째 null  을 만나면 break;
				//continue; // null을 만나면 for문으로 돌아가 i++ 부터 다시 실행	
			 result = member.isAdopt(animals[i]);			//인자를 animal 타입으로 전달받는 메소드 (다형성 예시)
			 sb.append(animals[i].toString());				//message += animals[i].toString();
			if(result) {
				sb.append("  😃 분양 가능합니다. \n");
			} else {
				sb.append("  😓 분양 자격이 안됩니다.\n");
			}
		}
		System.out.println(sb);
		System.out.println(sb.toString());		//StringBuilder 타입객체는  PrintIn 의 인자로
												// 사용시 toString 명시적으로 작성(생략가능!)

	}//main end
	
}







