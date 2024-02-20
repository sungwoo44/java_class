package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo2.BuyVo;
import project.vo2.CustomBuyVo;
import project.vo2.ProductVo;

//static이 많아지면 상속의 특징을 사용할 수 없다. 멀티스레드 환경애도 부적합
//  =>여기서는 테스트를 위해 static 사용
public class CartApp2 {

    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색  [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    // 상품 목록을 선택한 카테고리에 대해 보여주기 (구매할 상품 조회)
    // 또는 상품명으로 검색 (구매할 상품 조회)
    // 또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
    public static void main(String[] args) {
        TblBuyDao buyDao = new TblBuyDao();
        TblProductDao productDao = new TblProductDao();
        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customerid = System.console().readLine();
        System.out.println(String.format("%s님 환영합니다.", customerid));

        boolean run = true;
        while (run) { // 메뉴 선택 반복
            showMenu();
            System.out.print("선택 >>> ");
            String select = System.console().readLine();
            switch (select) {
                case "M", "m": // 나의 구매내역
                    List<project.vo2.CustomBuyVo> result = buyDao.selectCustomerBuyList(customerid);
                    for (project.vo2.CustomBuyVo vo : result)
                        System.out.println(vo);
                    break;
                case "C", "c":
                    System.out.println("카터고리 : A1-과일 A2-수입과일 B1-인스턴스 B2-선물세트 C1-과자류");
                    System.out.print("카테고리 입력 > ");
                    String category = System.console().readLine();
                    List<ProductVo> productlist = productDao.selectByCategory(category);
                    for (ProductVo vo : productlist)
                        System.out.println(vo);
                    break;
                case "P", "p":
                    System.out.print("상품명 검색어 입력 > ");
                    String pname = System.console().readLine();
                    productlist = productDao.selectByPname(pname);
                    for (ProductVo vo : productlist)
                        System.out.println(vo);
                    break;
                case "B", "b":
                    System.out.print(" 상품코드를 입력하세요. __ ");
                    String pcode = System.console().readLine();

                    System.out.print(" 수량을 입력하세요. __ ");
                    int quantity = Integer.parseInt(System.console().readLine());

                    BuyVo vo = new BuyVo(0, customerid, pcode, quantity, null);

                    buyDao.insert(vo);
                    System.out.println("상품을 담았습니다.");
                    break;
                case "D", "d":
                    System.out.print("취소할 구매 번호를 입력하세요. __ ");
                    int buy_idx = Integer.parseInt(System.console().readLine());
                    buyDao.delete(buy_idx);
                    break;
                case "Q", "q":
                    System.out.print(" 수정할 구매 번호를 입력하세요. __ ");
                    buy_idx = Integer.parseInt(System.console().readLine());

                    System.out.print(" 상품코드를 입력하세요. __ ");
                    pcode = System.console().readLine();

                    System.out.print(" 변경할 수량을 입력하세요. __ ");
                    quantity = Integer.parseInt(System.console().readLine());

                    vo = new BuyVo(buy_idx, customerid, pcode, quantity, null);
                    buyDao.update(vo);
                    break;
                case "X", "x":
                    return;
                default:
                    break;
            }
        }

    }
} // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java
  // 테이블 컬럼과 1:1 대응되는 BuyVo.java
  // 테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.
  // insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.
