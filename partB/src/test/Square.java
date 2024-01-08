package test;

import day7.Shape;



public class Square extends Shape{
    
    public void setEtc(){
        this.etc=etc;           //Shape 의 상속 클래스는 etc 필드 직접 사용
    }

    @Override
    public void draw() {
        System.out.println("정사각형 "+ this.getShapeName() +"를 그립니다.");
    }
    // public void setAccessModifier(int accessModifier){
    //     this.accessModifier=accessModifier;         //Shape 과 같은 패키지가 아니므로 사용 불가
    // }
    
    //     width=10;
    //     border=3;

}
