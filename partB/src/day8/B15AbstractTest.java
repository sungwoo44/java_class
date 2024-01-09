package day8;


// 추상클래스 테스트
public class B15AbstractTest {
    
        public static void main(String[] args) {
            
        //        Animal animal = new Animal();   // new 객체생성 불가
                                                // 추상클래스이기 떄문에 



                //Anonymous Inner Type(익명내부타입) : 클래스 이름이 없는 내부 클래스 형식

                Animal animal  = new Animal() {                 //강요된 추상메소드를 재정의하면서 내부 클래스 정의(일회용, 다른클래스에서 재사용불가)
                        @Override
                        public void sound() {
                               System.out.println("익명으로 만들어진 동물 클래스 : 소리 X");
                        }
                };

                animal.sound();
                System.out.println("animal toString = "+ animal);

                Puppy puppy = new Puppy("별루","브라운");
                puppy.sound();
                System.out.println("puppy toString =" + puppy);







        }
}
