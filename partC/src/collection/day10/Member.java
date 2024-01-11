package collection.day10;

import java.nio.channels.MembershipKey;


/* Member 클래스는 생성시 초기화하면 변경할수 없다. why  setter 가 없으므로 

                 hashCode, equals 매소드 재정의 
                         ㄴ VO (Value Object) 라고 부른다. 

 */

public class Member {
    


    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Member(String name, int age) {
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }

    /// ☆★☆ 객채의 동일성(같은 객체)을 위해서 hashCode 메소드, equals 메소드 재정의 !!★☆★
                    // ==>  해시코드값이 같고 인스턴스 필드의 냉용이 같으면 '동일한 객체'
    /// 인스턴스 필드값으로 해시코드 생성하기 
    @Override
    public int hashCode() {         // name.hashCode()와 age 정수값으로 계산.
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {     // 대상이되는 obj와 현재 this객체의 인스턴스 필드값이 모두 같은지 확인함.
                                            // 모두 같으면 "참" 리턴
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

    
}
