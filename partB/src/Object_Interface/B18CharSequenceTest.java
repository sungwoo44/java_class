package Object_Interface;


//CharSequence 는 자바에서 만든 인터페이스

// 어떻게 동작하는지 예시를 보자.

public class B18CharSequenceTest {
    public static void main(String[] args) {

        CharSequence csstr = new String("Hello java");
        CharSequence cssb = new String("Hi 자바");
        //  ↑ 인터페이스 타입

        String temp  = "자바 Hello~ Hi java ";
        System.out.println("charsequnce  타입을 인자로 하는 메소드 확인");
        System.out.println("contains : temp 객체에 csstr 문자열이 포함되어있는가?");
        System.out.println(temp.contains(csstr));
        System.out.println(temp.contains(cssb));
        System.out.println(temp.contains("Hello"));

        System.out.println("결론 : 메소드인자가 인터페이스 타입일 때에는");
        System.out.println("여러가지 구현 클래스가 인자로 전달될수 있습니다.");
    }
}
