package etc.day15;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTypeTest {
    
    public static void main(String[] args) {
        
        System.out.println("1. 현재 날짜와 시간을 구하여 출력");
        LocalDate currentDate = LocalDate.now();    //객체생성 메소드 now() -->  new 연산을 대신함.
        System.out.println("LocalDate 현재 날짜: " + currentDate);
        System.out.println();
        LocalTime currentTime = LocalTime.now();// 10억분의 1초(ms)
        System.out.println("LocalTime 현재시간 :"+ currentTime);
        System.out.println();
        LocalDateTime currDateTime = LocalDateTime.now();
        System.out.println("LocalDateTime 현재시간 :"+ currDateTime);

        System.out.println("\n2. 특정 날짜와 시간을 지정해서 객체를 생성합니다.");
        LocalDate mybirth = LocalDate.of(1991, 4, 4);
        // of 메소드 : 객체를 생성하고 값을 초기화 합니다.  
        LocalTime mybirth_time = LocalTime.of(19, 30, 0);
        System.out.println("\t LocalDate.of(1991, 4, 4):"+mybirth);
        System.out.println("\t LocalTime.of(19,30):"+mybirth_time);

        //java.time 패키지에 다른 클래스 테스트 
        System.out.println("3. 날짜 사이의 간격 계산하기 ");
        System.out.println("\t 내가 태어난지 --년 --월 --일이 지났습니다.");
        Period between = Period.between(mybirth,currentDate);
        System.out.println(between.getYears() + "년");
        System.out.println(between.getMonths() + "월");
        System.out.println(between.getDays() + "일");


        System.out.println("4. 날짜 사이의 간격 계산하기 (단위 년 또는 월 또는 일 )");
        System.out.println("\t 내가 태어나서 --년(개월or일) 이 지났습니다");
        System.out.println(ChronoUnit.YEARS.between(mybirth, currentDate)+"년");
        System.out.println(ChronoUnit.MONTHS.between(mybirth, currentDate)+"개월");
        System.out.println(ChronoUnit.DAYS.between(mybirth, currentDate)+"일");

        System.out.println("5. 내 생일로부터 10000일 까지 날짜는?");
        LocalDate day10000= mybirth.plusDays(10000);
        System.out.println(day10000+"일");
        
        System.out.println("6. 오늘 날짜로부터 10000일 전  날짜는?");
        LocalDate day_10000= currentDate.minusDays(3);
        System.out.println(day_10000+"일");

        System.out.println("7. 오늘 날짜로부터 3일 전/후 날짜는?");
        System.out.println(currentDate.minusDays(3)+"일");
        System.out.println(currentDate.plusDays(3)+"일");

        System.out.println("8. 날짜의 출력 패턴 설정하기");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(" dd일 MM월 yyyy년");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("mm분 ss초 dd일 MM월 yyyy년");
        System.out.println(currentDate.format(formatter));
        System.out.println(currDateTime.format(formatter2));


    }
}
