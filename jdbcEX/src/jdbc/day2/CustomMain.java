package jdbc.day2;

import project.dao.TblCustomerDao;
import project.vo.CustomVo;

public class CustomMain {
    public static void main(String[] args) {
         System.out.println("[고객관리시스템]");
         System.out.println("아이디 입력___");
         String customerId = System.console().readLine();
         System.out.println("----------조회결과----------");

          TblCustomerDao dao = new TblCustomerDao();
          CustomVo vo = dao.getCustomVo(customerId);

          if(vo==null)
             System.out.println("조회한 고객이 존재하지 않습니다.");
         else
            System.out.println(vo);
    }
}
