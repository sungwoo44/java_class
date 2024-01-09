package day8;

public class Member {

    public String name;
    public int age;

    public Member(int age, String name) {

        this.name = name;
        this.age = age;// 부모 클래스 생성자 호출. 인자를 전달함
    }

    // 다형성 예시 : 메소드 인자가 부모 타입일대, 실제 객체는 여러자식 객체가 될 수 있습니다.
    public boolean isAdopt(Animal animals) {
        { // 모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
          // 동물 보호소 규정(비지니스 로직)
          // ㄴ강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 그밖에 20세이상 분양받을 수 있습니다.
          // / ㄴ Member 클래스 isAdopt 메소드 실행. --> instandof 연산 사용


          // 내코드
            if (animals instanceof Puppy) {
                return this.age >= 15;
            } else if (animals instanceof Cat) {
                return this.age >= 18;
            } else if (animals instanceof Rabbit) {
                return this.age >= 13;
            } else
                return this.age >= 20;
//////////////////////////////////////////////////////////////////
 /////////////////////////////////////////////////////////////////        
           // 쌤코드

/*             if (animals instanceof Puppy && age>=15) {
                return true;
            } else if (animals instanceof Cat && age>=18) {
                return true;
            } else if (animals instanceof Rabbit && age>=13) {
                return true;
            } else if(age>=20)
                return true;
            else
                return false;
*/



        }

    }
}
