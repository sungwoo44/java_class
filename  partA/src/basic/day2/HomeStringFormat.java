package basic.day2;
import java.util.Date;
public class HomeStringFormat {
    public static void main(String[] args) {
        



	
	/*
	 * String.format()란? - 문자열을 “포맷팅”하기 위해서 사용되는 함수입니다. 
	 * 지정된 형식 문자열과 그에 따른 인수들을 입력받아,
	 * 지정된 형식으로 포맷팅된 문자열을 반환합니다.
	 */
	
	/*
	public static String format(String format, Object... args)
	
	  타입	| 파라미터	 |  설명
	String	| format | 서식화할 문자열입니다. 문자열 내에 %n 형태로 포맷 지정자를 사용할 수 있습니다.
	Object	| args	 | format 문자열 내 포맷 지정자에 대응시킬 값들입니다.
	
	포맷 지정자	| 설명			| 출력 결과 예시
	%s			| 문자열			| "hello"
	%d			| 10진수 정수		| 123
	%f			| 부동소수점 실수	| 3.14
	%c			| 문자			| 'a'
	%b			| boolean 값		| true 또는 false
	%n			| 줄바꿈 문자		| 줄바꿈
	*/
	
	String name1 = "Messi";
	int age1 = 36;
	double height1 = 169.0;
	boolean worldcupwin1 = true;
	
	
	String name2 = "Ronaldo";
	int age2 = 38;
	double height2 = 187.0;
	boolean worldcupwin2 = false;
	
	Date now =new Date();	

	String result1 = String.format("이름:%s %n나이는 : %d %n키: %.1f %n월드컵우승:%b ",name1,age1,height1 ,worldcupwin1);
	
	String result2 = String.format("이름:%s %n나이는 : %d %n키: %.1f %n월드컵우승:%b ",name2,age2,height2,worldcupwin2);
	
	System.out.println("===============================");
	System.out.println(result1);
	System.out.println("===============================");
	System.out.println(result2);
	
	
	
	
	System.out.println(String.format("01. 이름 : %s\t %S ", "Messi", "Ronaldo"));
    System.out.println(String.format("02. 문자 : %c\t %C", 'm', 'R'));
    System.out.println(String.format("03. 발롱도르수상 확률 : %d%%\t %d%%", 100, 10));
    System.out.println(String.format("04. 월드컵우승경력 : %b\t %B", true, false));
    System.out.println(String.format("05. 발롱도르 : %d\t %d",8, 5));
    System.out.println(String.format("06. 16진수 : %h\t %H", 1234.1234, 1234.1234));
    System.out.println(String.format("07. 16진수(오직정수) : %x\t %X", 1234, 1234));
    System.out.println(String.format("08. 8진수 : %o", 1234));
    System.out.println(String.format("09. 부동 소수점, 10진수로 표시 : %f\t %f", 1234f, 1234d));			
    System.out.println(String.format("10. 부동 소수점, 10진수(반올림)로 표시 : %g\t %G", 1234.1234, 1234.1234));
    System.out.println(String.format("11. 소수점 자릴수 제한(반올림) : %.2f\t %.2f <- nf면 소수점 n자리", 1234.1264f, 1234.1224d));
    System.out.println(String.format("12. 날짜 시간 스타일1 : %tY년 %<tm월 %<td일 %<tH시 %<tM분 %<tS초",now ));
    System.out.println(String.format("13. 날짜 시간 스타일2 : %ty년 %<tb %<ta %<tA %<tl시(소문자L) %<tF %<tD %<tT",now ));
	
	
}

    }
    

