package day7;

import test.Square;

/*
 * 
 * 다형성이 어떻게 구현되는 것인지 확인하기 
 *  ㄴ 자료구조 필요.   배열을 사용해보자
 * 
 */
public class B12Polymorphsim {
    public static void main(String[] args) {

        Shape[] shapes = new Shape[5];

        shapes[0] = new Diamond();
        shapes[0].setShapeName("다이아아몬드");

        shapes[1] = new Triangle("세모", 100, 100, 60);

        shapes[2] = new Square();
        shapes[2].setShapeName("사가가각형");

        shapes[3] = new Diamond();
        shapes[3].setShapeName("2다이아몬드2");

        shapes[4] = new Triangle("삼각김밥", 50, 50, 50);
        // shapes[4].setShapeName("사각형님");
        // 여기까지 부모타입 배열에 자식 객체들을 생성해서 참조시킴.

        // 다형성 : 자료구조에 저장된 객체가 하나의 타입 (Shape) 이지만 실행되는 동작(draw) 는 모두 다름

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(i + "번 도형입니다.");
            shapes[i].draw();
            // 부모타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다.
            // 다형성은 메소드는 한가지를 통일해서 실행하지만 결과는 여러형태로 나올수 있다.===> 다형성
        }

        System.out.println(" ~~~ 자식객체의 실제 타입을 검사하는 instanceof 연산 ~~~~");
        for (int i = 0; i < shapes.length; i++) {

            // instanceof =
            System.out.println("도형 : " + shapes[i].getShapeName());
            System.out.println("shape[i] instanceof Triangle ?: " + (shapes[i] instanceof Triangle));
            System.out.println("shape[i] instanceof Diamond ?: " + (shapes[i] instanceof Diamond));
            System.out.println("shape[i] instanceofSquare ?: " + (shapes[i] instanceof Square));
            System.out.println("=====================================");
        }

        System.out.println(" ~~~ 삼각형  Triangle 객체는 넓이를 구해서 출력하기!!! ~~~");
        // 삼각형만 찾아서 넓이를 구하시오.
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Triangle) {
               
                // 반드시 실제 객체가 Triangle 일때 만 강제 캐스팅 한다. 
                Triangle temTriangle = (Triangle)shapes[i];             //부모 클래스에서 자식클래스 메소드 호출 하려고 할때

                
                System.out.println(i + "번째 도형");
                System.out.println(shapes[i].calculateArea());
                
                temTriangle.printAngle();
                

            }

        }

        System.out.println("~~~  shape 배열에 저장된 객체 중 다이아몬드를 draw 하기! ~~~");
        for (Shape temp : shapes) {
            if (temp instanceof Diamond) {
                System.out.println(temp.getShapeName() + " 도형");
                temp.draw();                

                //부모타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다.
                // 다형성 은 메소드는 한가지들 통일해서 실행하나 결과는 여러 형태를 보이는 것입니다. 
                //                  ㄴ 자식클래스가 ★※메소드 오버라이드※★ 를  할수 있기 때문에!!

            }
        }

        

    }
}
