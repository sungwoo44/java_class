package etc.day15;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * InnerMyCalendar
 */
public class InstanceTest {

    
    public static void main(String[] args) {
        MyCalendar my1 = MyCalendar.getInstance();
        // MyCalendar my2 = new MyCalendar();
        // MyCalendar my3 = MyCalendar.object();

        YourCalendar you1 = YourCalendar.of("2024", "03");

        Member m1 = new Member();
        m1.getAge();
        m1.getName();

        Member m2 = new Member("momo", 20, 100);
        System.out.println(m2.getName());
    }
    
}

//lombok 라이브러리는 자주 사용하는 메소드를 자동으로 생성.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Member{
    private String name;
    private int age;
    private int point;

    //커스텀생성자
    //기본생성자
    //getter        //setter
    //toString
    //hashcode 와 equals

}






// 메인 메소드는 1개 파일에 하나만 있어야 함.
// public 클래스도 1개 파일에 하나만 있어야 함.
// ㄴ 위에 2가지를 지키고 1개 파일에 클래스는 여러개 만들수 있다. 
class MyCalendar {
    private static MyCalendar object = new MyCalendar();
    // 필드가 현재 클래스의 타입. 미리 생성자로 객체를 만듭니다.


    private MyCalendar() { //생성자는 private. 다른 클래스에서 사용못함. 
    }

    public static MyCalendar getInstance(){
        // 미리 만들어진 현재 클래스 타입의 객체를 리턴!
        return object;
    }

    

}

class YourCalendar{
    private String month;
    private String day;

    
    private YourCalendar(){}   // 다른 클래스에서 new 연산 사용 못함. Private
    
    public static YourCalendar of(String month,String day){
        YourCalendar result = new YourCalendar();
        result.month = month;
        result.day = day;
        
        return result;
    }
    
    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

}
