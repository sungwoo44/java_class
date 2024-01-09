package day7;

//shape 과 Triagnle 을 객체 생성하고 메소드 테스트

public class B09ShapeMain {
    public static void main(String[] args) {
        
        Shape sh1 = new Shape("정사각", 100, 100);
        Shape sh2 = new Shape("직사각", 100, 100);
        Shape sh3 = new Shape("사다리", 100, 100);

        Triangle tr1 = new Triangle("삼각1", 100, 100 , 60);
        Triangle tr2 = new Triangle("삼각2", 30, 30 , 60);
        Triangle tr3 = new Triangle("삼각3", 50, 50 , 60);

        System.out.println(sh1.calculateArea());
        System.out.println(sh2.calculateArea());
        System.out.println(sh3.calculateArea());
        System.out.println();

        sh1.print();
        sh2.print();
        sh3.print();
         System.out.println();

        System.out.println(tr1.calculateArea());
        System.out.println(tr2.calculateArea());
        System.out.println(tr3.calculateArea());
        System.out.println();

        tr1.print();
        tr2.print();
        tr3.print();


        tr1.printAngle();
        tr2.printAngle();
        tr3.printAngle();
        System.out.println();



        System.out.println("재정의 메소드 실행");
        System.out.println(sh1.getShapeName()+sh1.getHeight());


        System.out.println("부모클래스가 정의한 메소드 실행");
        sh1.print();
        tr1.print();


        System.out.println("자식클래스가 정의한 메소드 실행");
        //sh1.getAngle();       안됨


        //상속에서의 변수 참조타입 --- 자식클래스 타입, 부모클래스 타입
        //1) 자식객체를 부모 타입으로 참조하기!********
        Shape tempsh1 = new Triangle("자식을 부모타입으로 도형", 50, 500, 500);




        //2)  부모객체를 자식 타입으로 참조할수... 없음!!
        // Triangle tempsh2 = new Shape(); 
        
        Triangle tempsh2 = (Triangle) new Shape("부모를 자식타입으로 도형", 30, 30);
            // 강제 캐스팅은 했으나 Triangle 에 필요한 인스턴스 필드가 안 만들어기지 때문에 오류 (문법적으로만 오류가 없음.)
            // ㄴ  사용하지 않음!
        //1),2) 메소드 사용제한 확인하기!!!!


        tempsh1.print();
      // System.out.println("tempsh1" + tempsh1.getShapeName()+tempsh1.calculateArea());
      //  System.out.println("tempsh1" + tempsh1.getShapeName()+tempsh1.getHeight()+tempsh1.getAngle()+tempsh1.calculateArea());
    //                                                                                  ㄴ 오류!!★           

    // tempsh2.print();
    // tempsh2.calculateArea();
  
  
  
      




        
    }    
}
