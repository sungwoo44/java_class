package project.vo2;

import java.sql.Date;


// Value Object : 데이터 형식으로 정의되는 클래스 
//      ㄴ private 필드, 값 초기화 커스텀 생성자,  getter, hashcode, equlas 재정의
//      ㄴ 객체 생성시 값을 초기화 한 후 변경할 수 없으며, 필드값이 같으면 같은 값으로 처리되는 객체 
public class CustomVo {        //tbl_custom 테이블컬럼과 1:1 대응
    private String customId;
    private String name;
    private String email;
    private int age;
    private Date reg_date;


    //hash,  equals가 재정의 되어야 진짜 VO 입니다. 
    //          ㄴ 필드값이 겉으면 값이 같은 객체로 처리됩니다.

    public void setCustomId(String customId) {
        this.customId = customId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setReg_date(Date reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customId == null) ? 0 : customId.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + age;
        result = prime * result + ((reg_date == null) ? 0 : reg_date.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomVo other = (CustomVo) obj;
        if (customId == null) {
            if (other.customId != null)
                return false;
        } else if (!customId.equals(other.customId))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (age != other.age)
            return false;
        if (reg_date == null) {
            if (other.reg_date != null)
                return false;
        } else if (!reg_date.equals(other.reg_date))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CustomVo [" + customId + "," + name + "," + email + "," + age + ","
                + reg_date + "]\n";
    }

    public String getCustomId() {
        return customId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public Date getReg_date() {
        return reg_date;
    }

    public CustomVo(String customId, String name, String email, int age, Date reg_date) {
        this.customId = customId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.reg_date = reg_date;
    }


    

    
   


}
