package project.vo;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MemberBuyVo {
    private int buy_idx;
    private String customer_id;
    private String mname;
    private String menu_id;
    private int menu_quantity;
    private int mprice;
    private Timestamp buy_Date;

    @Override
    public String toString(){

        return "구매번호:"+buy_idx + " 고객아이디:"+customer_id+" 제품이름:"+ mname+" 제품번호:"+menu_id+" 수량"+menu_quantity+" 가격:"+mprice+" 구매날짜:"+buy_Date;
    }
}
