package jdbc.day2;

import java.util.List;

import project.dao.TblBuyDao;
import project.dao.TblProductDao;
import project.vo.BuyVo;
import project.vo.CustomBuyVo;
import project.vo.ProductVo;

//static 이 많아지면 상속의 특징을 사용할수 없습니다. 멀티 스레드 환경에 적합하지 않습니다.
//                              --> 여기서는 테스트를 위해  static 사용 중입니다.
public class CartApp_2 {
    
            //상품 목록을 선택한 카테고리에mia 대해 보여주기  (구매할 상품 조회)
            //또는 상품명으로 검색 (구매할 상품 조회)
            //또는 입력한 아이디로 구매한 구매내역 보여주기 (구매수량 변경 또는 구매 취소 buy_idx 조회)
            

    public static void showMenu() {
        System.out.println(".".repeat(50));
        System.out.println("[C] 카테고리별 상품 조회     [P] 상품명 검색    [M]나의 구매내역");
        System.out.println("[B] 구매하기   [D] 구매 취소   [Q] 구매 수량 변경  [X] 구매 종료");
        System.out.println(".".repeat(50));
    }

    public static void showMyPage(){
        
    }


    public static void main(String[] args) {
        TblBuyDao buyDao= new TblBuyDao();
        TblProductDao productDao = new TblProductDao();
        

        System.out.println("구매할 사용자 간편 로그인 필요합니다.");
        System.out.print("아이디 입력 __");
        String customid= System.console().readLine();
        System.out.println(customid+"님 환영합니다.♥_♥");
        boolean run = true; 
        while (run) {       //메뉴 선택 반복
            showMenu();
            System.out.println("선택>>>>");      
            // int select = Integer.parseInt(System.console().readLine());
            
            String  select= System.console().readLine();
            switch (select) {
                case "m","M":   //[1] 장바구니 담기 - buy 테이블에 insert (1행)
                    List<CustomBuyVo> result = buyDao.selectCustomBuy(customid);
                    for(CustomBuyVo vo : result)
                        System.out.println(vo);
                    break;

                case "c","C":
                    System.out.println("카테고리 목록: A1-과일 A2-수입과일 B1-인스턴트 B2-선물세트 C1-과자류");
                    System.out.println("카테고리 입력___");
                    String category = System.console().readLine();
                    List<ProductVo> productList = productDao.selectByCategory(category);
                    for(ProductVo vo : productList)
                            System.out.println(vo);
                    break;
                
                case "p","P":
                    System.out.println("상품명 조회: ");
                    System.out.println("상품명 입력___ ");
                    String pname = System.console().readLine();
                    List<ProductVo> productList1 = productDao.selectByPname(pname);
                    for(ProductVo vo : productList1)
                            System.out.println(vo);
                    break;

                case "b","B":
                    System.out.println("구매하기 ");

                    
                    System.out.println("상품코드 입력___ ");
                    String pcode = System.console().readLine();
                    System.out.println("상품수량 입력___ ");
                    String quantity = System.console().readLine();

                    BuyVo vo = new BuyVo(null,customid,pcode,quantity,null);
                    buyDao.buy(vo);


                    break;

                case "d","D":
                    System.out.println("구매 취소하기");
                    System.out.println("취소할 상품의 buy_idx 입력___");
                    int buy_idx = Integer.parseInt(System.console().readLine());

                    BuyVo vo = new BuyVo(buy_idx, customid, pcode, buy_idx, null);
                    buyDao.delete(vo);
                    System.out.println("상품이 삭제되었습니다."); 
                    break;
                
                    case "q","Q":
                    System.out.println("구매 수량 변경하기 ");
                    System.out.println("변경할 상품의 buy_idx 입력___");
                    int modify_buy_idx = Integer.parseInt(System.console().readLine());
    
                    // Now we need to get the new quantity from the user
                    System.out.println("변경할 수량 입력___ ");
                    int newQuantity = Integer.parseInt(System.console().readLine());
                    
                    // Call the modify method with the new quantity
                    BuyVo modifyVo = new BuyVo();
                    modifyVo.modify(modify_buy_idx);
                    modifyVo.setQuantity(newQuantity);
                    buyDao.modify(modifyVo);
                    break;
                case "x","X":
                    run= false;

                                //[2] 구매 취소 - delete
                                //  [3] 구매 수량 변경 - update
                default:
                    break;
            }
        }

    }
}   // tbl_buy 테이블을 대상을 insert, update, delete 할수 있는 dao 클래스 TblBuyDao.java 
    //         테이블 컬럼과 1:1 대응되는 BuyVo.java  
    //         테이블 PK 컬럼은 buy_idx -> update,delete 의 조건 컬럼입니다.     
    //         insert 에서 시퀀스는 sql 실행할 때와 동일하게 사용합니다.       
