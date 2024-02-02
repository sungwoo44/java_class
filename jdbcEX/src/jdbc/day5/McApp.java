package jdbc.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;

import project.dao.BuyMenuDao;
import project.dao.MembersDao;
import project.dao.MenuDao;
import project.vo.BuyMenuVo;
import project.vo.MemberBuyVo;
import project.vo.MembersVo;
import project.vo.MenuVo;

public class McApp {
    private MembersDao membersDao = new MembersDao();
    private BuyMenuDao buymenudao = new BuyMenuDao();
    private MenuDao menudao = new MenuDao();
    private List<BuyMenuVo> cart = new ArrayList<>();
    private Map<String, Integer> priceMap = null;

    public McApp() {
        this.priceMap = menudao.getMpriceTable();
        //System.out.println(priceMap);
    }

    // 선택 메뉴보기
    private void showMenu() {
        System.out.println("-".repeat(50));
        System.out.println("[1]구매하기     [2]장바구니  [3]구매내역 [4]메뉴검색 ");
        System.out.println("[5]장바구니삭제  [6]결제하기  [7]회원가입   [0]GoodBye ");
        System.out.println("-".repeat(50));
    }

    // 구매리스트보기
    private void showMyPage(String customerid) {
        List<MemberBuyVo> result = buymenudao.selectMemberBuy(customerid);
        for (MemberBuyVo vo : result)
            System.out.println(vo);
    }

    // 메뉴 검색
    private void searchMenuByMname() {
        System.out.print("상품명을 입력하세요___");
        String Mname = System.console().readLine();
        List<MenuVo> menulist = menudao.selectByMname(Mname);
        for (MenuVo vo : menulist)
            System.out.println(vo);
    }

    // 장바구니에 메뉴담기
    private void addCartMenu(String customer_id) {
        System.out.print("구매할 상품코드를 입력하세요__");
        String menu_id = System.console().readLine();
        System.out.print("구매할 갯수를 입력하세요__ ");
        int menu_quantity = Integer.parseInt(System.console().readLine());

        cart.add(new BuyMenuVo(0, customer_id, menu_id, menu_quantity, null));
    }

    // 장바구니보기2
    private void showCartList() {
        long totalMoney = 0;
        System.out.println(".................. 장바구니 :: 목록 보기...................");
        for (int i = 0; i < cart.size(); i++) {
            int price = cart.get(i).getMenuQuantity() * priceMap.get(cart.get(i).getMenuId());
            System.out.println("번호 :" + i + " 물품 :" + cart.get(i)); // 리스트에서 인덱스 i번쨰 가져오기

            totalMoney += price;

        }
    }

    // 장바구니비우기
    private void removeCartMenu() {
        System.out.println("장바구니 비우기");

        System.out.print("삭제할 번호를 입력하세요__");
        int index = Integer.parseInt(System.console().readLine());
        cart.remove(index);

    }

    // 장바구니로 구매
    public void buyCartMenu() {
        if (cart.size() == 0) {
            System.out.println("장바구니가 비었습니다.");
            return;
        }
        System.out.println(" 장바구니 물품 모두 구매");
        int result = buymenudao.allAtOnes(cart);
        if (result > 0) {
            System.out.println("장바구니 물품구매가 정상적으로 완료되었습니다.");
            cart.clear();
        } else {
            System.out.println("장바구니 물품 구매 실패 하였습니다.");
        }
    }

    public void newMembers(){
        System.out.println("회원가입을 시작합니다.");
        MembersVo newmember = new MembersVo(null, null, null, null, 0);    
        
    }





    public static void main(String[] args) {
        McApp app = new McApp();
        app.start();
    }

   




    public void start() {
        System.out.println("사용자 아이디를 입력하세요");
        System.out.print("아이디 ____");
        String customerid = System.console().readLine();
        System.out.println();

        MembersVo vo = membersDao.getMembersVo(customerid);
        if(vo==null)
            System.out.println("회원이 아닙니다 회원가입하세요");

        else
            System.out.println(vo);

        boolean run = true;

        while (run) {
            showMenu();
            System.out.print("선택>>>");

            String select = System.console().readLine();
            switch (select) {
                case "1":
                addCartMenu(customerid);
                break;
                case "2":
                showCartList();
                break;
                case "3":
                    showMyPage(customerid);
                    break;
                case "4":
                    searchMenuByMname();
                    break;
                case "5":
                    removeCartMenu();
                    break;
                case "6":
                    buyCartMenu();
                    break;
                case "7":
                    membersDao.join(vo);
                    break;
                case "0":
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

}
