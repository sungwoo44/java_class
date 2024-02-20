package jdbc.day2;

import project.dao.TblBuyDao;
import project.vo2.BuyVo;

public class CartApp {
    public static void main(String[] args) {
        //상품목록을 선택한 카테고리에 대해 보여주기 
        // 또는 상품명으로 검색
        // 또는 입력한 아이디로 구매한 구매내역 출력(구매수량 변경 또는 구매취소 buy_idx 조회)
        
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.println("아이디 입력__");


        System.out.println("[1] 구매하기  [2]구매취소  [3]구매수량변경  [4]구매종료");
        int select = Integer.parseInt(System.console().readLine());
        boolean run = true;

        while(run){     //메뉴 선택 반복

            switch (select) {   
                case 1:     // 구매하기 =buy 테이블에 insert(1행)
                System.out.println("우리 쇼핑몰 [회원가입] 환영합니다.");
                System.out.println("주의사항 : 아이디는 중복된 값을 저장하면 무결성 위반 오류입니다.");

                System.out.print(" 아이디를 입력하세요. __ ");
                String customId = System.console().readLine();

                System.out.print(" 제품코드를 입력하세요. __ ");
                String pcode = System.console().readLine();

                System.out.print(" 나이를 입력하세요. __ ");
                int quantity = Integer.parseInt(System.console().readLine());

                BuyVo vo = new BuyVo(null,customid,pcode,quantity,null);
                TblBuyDao dao = new TblBuyDao();

                dao.buy(vo);

                    break;
                case 2:     // 구매 취소 delete
                System.out.println("우리 쇼핑몰 [구매취소]- 합니다.");
                System.out.print(" 아이디를 입력하세요. __ ");
                customId = System.console().readLine();
                
                    
                    break;
                case 3:     // 구매수량 변경 update

                    break;
                case 4:
                    run = false;
                    break;
                default:
                    break;
            }


        }

    }
} //tbl_buy 테이블을 대상 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java
//  테이블 컬럼과 1:1 대응 되는 BuyVo.java 
//  테이블 pk 컬럼은 : buy_idx --> update,delete 의 조건컬럼
