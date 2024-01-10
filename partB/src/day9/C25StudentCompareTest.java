package day9;

import java.util.Arrays;
import java.util.Comparator;

// Arrays.sort 메소드에 두번째 인자로 Comparator  인터페이스 타입 객체를 전달하면
//              비교 기준과 정렬 방법을 실행 시점에서 결정!!
public class C25StudentCompareTest {
    
    public static void main(String[] args) {

        Student[] students = new Student[4];

        students[0] = new Student("장모모", 23);
        students[1] = new Student("박나연", 22);
        students[2] = new Student("김다현", 24);
        students[3] = new Student("사나", 21);


        System.out.println("초기 students 배열 : \n" + Arrays.toString(students));
        // Arrays.sort(students);      // 오류!! student 객체를 comparable 이 아니다!!

        // Comparator<Student> ageAscending = new Comparator<Student>() {
            
        //     @Override
        //     public int compare(Student o1, Student o2){
        //         return o1.getAge()-o2.getAge();
        //     }
        // };

          Comparator<Student> ageDecending = new Comparator<Student>() {
            
            @Override
            public int compare(Student o1, Student o2){
                return o2.getAge()-o1.getAge();
            }
        };

        //   Comparator<Student> nameAscending = new Comparator<Student>() {
            
        //     @Override
        //     public int compare(Student o1, Student o2){
        //         return o1.getName().compareTo(o2.getName());
        //     }
        // };

          Comparator<Student> nameDecending = new Comparator<Student>() {
            
            @Override
            public int compare(Student o1, Student o2){
                return o2.getName().compareTo(o1.getName());
            }
        };


        //한번만 사용할 Comparator 는 변수 선언하지 않고 바로 인자로 전달할 수 있습니다. 
        //◎람다식 표현   ☞ver.3
        Arrays.sort(students,(o1,o2) ->{
                return o1.getAge()-o2.getAge();
            }
        );
        System.out.println("나이오름차순 정렬 후 students 배열 : \n" + Arrays.toString(students));
        

        //ageDecending    ☞ver.1
        Arrays.sort(students,ageDecending);
        System.out.println("나이내림차순 정렬 후 students 배열 : \n" + Arrays.toString(students));

      
        //nameAscending   ☞ver.2
        //한번만 사용할 Comparator 는 변수 선언하지 않고 바로 인자로 전달할 수 있습니다. 
        Arrays.sort(students,new Comparator<Student>() {
            
            @Override
            public int compare(Student o1, Student o2){
                return o1.getName().compareTo(o2.getName());
                
            }
        });
        System.out.println("이름오름차순 정렬 후 students 배열 : \n" + Arrays.toString(students));
        
        
        //nameDecending
        //◎람다식 표현  ☞ver.4
        Arrays.sort(students,(o1,o2) ->{
                return o2.getName().compareTo(o1.getName());
            });
        System.out.println("이름내림차순 정렬 후 students 배열 : \n" + Arrays.toString(students));


            // o1,o2 오름/내림 상관없이 교환을 안해도 되는 경우를 음수값으로 리턴한다. 
            // sort  메소드 정렬 알고리즘은 비교결과 음수 리턴하면 교환 하지 않고
                                                // 양수 리턴하면 교환!!



    }
}
