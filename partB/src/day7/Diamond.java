package day7;


//Shape 클래스 상속예시2
public class Diamond extends Shape{

    //생성자 정의가 명시적으로 없으면 기본생성자를 실행합니다
    //자식 클래스는 부모클래스 기본생정자를 먼저 실행합니다. 


    // public void setShapeName(String shapeName){
    //         this.shapeName=shapeName;   --> 오류!        // 자식이지만 부모가 private 했기 때문!
    // }



    // 부모가 protected 로 선언한 필드는 자식은 자유롭게 접근 가능함.
    public void setEtc(String etc){     
        this.etc=etc;
    }



    //Object 클래스의 toString 메소드를 오버라이드 
    ///  ob2.toString()=day7.Diamond@1fb3ebeb <- 기본! so, 다른 문자열로 바꿈. 
 
    // day8 Object  클래스의 toString 메소드를 오버라이드
    @Override
    public String toString() {
        return "Diamond []";
    }

    @Override
    public void draw() {
        System.out.println("다이아몬드 "+ this.getShapeName() +"를 그립니다.");
    }

/*
 *  <접근 한정자>  access modifier
 *  public          :  모두에게 공개
 *  private         :  모두에게 비공개
 *  protected       :  같은패키지 클래스와 다른패키지인 경우 자식에게만 공개
 *                      ㄴ EX) Shape 의 etc 는 자식인 Triangle, Diamond 에게는 공개 / 같은 패키지 B10DiamondTest 에게도 공개
 *                      ㄴ 그 외의 경우는 비공개, 다른 패키지이지만 자식 클래스라면 공개 
 *  아무것도 안씀    :  거의 사용되지 않음. 같은 패키지 클래스에게만 공개 
 *     default           ㄴ EX) day7 패키지 클래스에게는 공개 / 그외에는 숨기기
 */
   // 자식 클래스가 정의한 인스턴스 메소드 = Diamond 타입으로 선언한 참조변수만 실행할 수 있음.  
    public void iAmDiamond(){
        System.out.println("나는 비싸");
    }
}
