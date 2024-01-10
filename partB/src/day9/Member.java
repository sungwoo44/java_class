package day9;


/*
 * 
 * 인터페이스 예시 - 비교 가능한 객체 만들기 
 *                 ㄴ객체 비교 방법 1) Comparable  인터페이스 구현하도록 합니다.
 *  Comparable<Member> --> <> 안에 타입을 표시 
 *                           ㄴ제너릭 타입    : 클래스 또는 인터페이스의 메소드에게 타입을 매개변수로 전달하기 위함.
 *                                이 때 타입이 실행시점에 결정되기 떄문에~~ 기본형은 Wrapper 클래스로 사용
 *                          Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달합니다. 
 * 
 * Comparable 비교할수있는
 * 
 */
public class Member implements Comparable<Member> {  //Comparable 인터페이스가 실행하는 메소드에 Member 타입을 전달합니다.
        private String id;
        private int age;


        public Member(String id, int age) {
            this.id = id;
            this.age = age;
        }

        public String getId() {
            return id;
        }
        public int getAge() {
            return age;
        }


        //Comparable  인터페이스의 추상메소드 comparaTo를 구현
        @Override
        public int compareTo(Member o) {// 메소드의 인자 타입 Member는 <> 제너릭 타입과 같게 만들어집니다.
            // 현재 객체 this를 인자로 전달되는  Member객체와 비교합니다.
            //비교기준은 요구사항에 따라 개발자가 정한다.

            // case1) 나이로 
            // return this.age - o.age;         //오름차순
            return o.age - this.age;          //내림차순
            
            // case2) 이름(id) 순으로
            // return this.id.compareTo(o.id);   //오름차순
            // return o.id.compareTo(this.id);   //내림차순
        }

        @Override
        public String toString() {
            return "Member [id=" + id + " age=" + age + "] \n";
        }
       

    
}
