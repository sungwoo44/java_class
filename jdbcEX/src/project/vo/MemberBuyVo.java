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

        return String.format("%s  | %s  | %s  | %s  | %d | %d  | %s",buy_idx,customer_id,mname,menu_id,menu_quantity,mprice,buy_Date);
    }
}
