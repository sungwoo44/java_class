package object.day5;

public class MyClass2{

    //인스턴스 필드 - 객채를 생성해서 사용.
    //private 키워드 : 현재 클래스 외에 다른 클래스에서 사용못함.
    String field1;
    private int field2;
    private double[] field3;


    //필드값을 가져오는 메소드 : getter
    public String getFild1(){
        return field1;
    }

    //필드값을 저장하는 메소2드 : setter
    public void setFiled1(String f1){
        field1=f1;

    }
    //필드값을 가져오는 메소드 : getter
    public int getFild2(){
        return field2;
    }

    //필드값을 저장하는 메소드 : setter
    public void setFiled2(int f2){
        field2=f2;
    }
    //필드값을 가져오는 메소드 : getter
    public double[] getFild3(){
        return field3;
    }

    //필드값을 저장하는 메소드 : setter
    public void setFiled3(double[] f3){
        //field3=f3;

        //참조값을 대입시킵니다. 
        //객체가 의도하지 않아도 쉽게 field3배열값이 변경됨
        field3 =new double[f3.length];  // 배열을 새로 생성하기
        for(int i=0;i<f3.length;i++){   //f3 배열의 값을 복사하기
            field3[i]=f3[i];
        }
    }

    // 모든 인스턴스 필드 값을 출력해주는 메소드 
    public void printDate(){
        System.out.println("field1="+field1+"\nfield2="+field2+"\nfield3="+field3);
        System.out.println();
    }





}