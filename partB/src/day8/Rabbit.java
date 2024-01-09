package day8;

public class Rabbit extends Animal{
    
    public static final String TYPE ="토끼";

    // 생성자 정의가 없으면 기본생성자 사용하겠다는 의미.
    //  super() 호출합니다. 

    // 자식객체가 생성될때 먼저 부모객체가 생성되고 자식 인스턴스요소가 추가됩니다. 
    // 이 때 부모생성자는 super()가 기본입니다. 

    
    @Override
    public void sound() {
        System.out.println(this.color +"토끼는 🐰🐰조용 합니다. ");
        
    }

    @Override
    public String toString() {
        return TYPE+"[color=" + color + ", name=" + name + "]";
    }

    



}
