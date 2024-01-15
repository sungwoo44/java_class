package day11;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.HashPrintJobAttributeSet;

import collection.day10.myapp.JavaWord;

// 1월 14일 저녁 9시까지 제출
public class CustmoerManageApp {

    private List<Customer> PH = new ArrayList<>();

    private void start() {
        // 메뉴 선택: 등록,검색(이름/그룹), 삭제 수정, 전체 출력
        initialize();
        System.out.println("==========전화번호부==========");
        while (true) {
            System.out.println("   <<<메뉴를 선택하세요>>>\n");
            System.out.println("  ☞ 1.전화번호 등록☎");
            System.out.println("  ☞ 2.전화번호 검색☏ (이름/그룹)");
            System.out.println("  ☞ 3.전화번호 삭제☎");
            System.out.println("  ☞ 4.전화번호 수정☏");
            System.out.println("  ☞ 5.전체번호 출력☎");
            System.out.println("  ☞ 6.프로그램 종료☏");
            System.out.print("    선택◇ ▣ ◇ ▣ ◇ ☞   ");

            int select = Integer.parseInt(System.console().readLine());

            switch (select) {
                case 1:
                    addNumber(); // 단어 등록 메소드 실행
                    break;
                case 2:
                    searchNumber(); // 단어 목록 조회메소드 실행
                    break;
                case 3:
                    removeNumber(); // 단어 목록 조회메소드 실행
                    break;
                case 4:
                    modifyNumber(); // 단어 목록 조회메소드 실행
                    break;
                case 5:
                    printNumber(); // 단어 목록 조회메소드 실행
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0); // main 종료
                    break;
                default:
                    System.out.println("잘못된 선택값 입니다.");
                    break;
            }

        }

    }
    //초기 기본값 설정
    private void initialize() {
        PH.add(new Customer("momo", "010-1111-1111", 1));
        PH.add(new Customer("momo", "010-1111-1111", 2));
        PH.add(new Customer("momo", "010-1111-1111", 3));
        PH.add(new Customer("dahy", "010-2222-2222", 1));
        PH.add(new Customer("dahy", "010-2222-2222", 1));
        PH.add(new Customer("sana", "010-3333-3333", 2));
        PH.add(new Customer("hahy", "010-4444-4444", 2));

    }
    //번호 등록 메소드
    private void addNumber() {

        System.out.println("\n"+"  ☞ 1.전화번호 등록☎");

        System.out.print("이름을 입력 해주세요 >>>>> ");
        String name = System.console().readLine();
        System.out.println("형식 : 010-XXXX-XXXX");
        System.out.print("번호를 입력 해주세요 >>>>> ");
        String phone = System.console().readLine();
        System.out.print("그룹번호를 입력 해주세요 > ");
        int group = Integer.parseInt(System.console().readLine());

        PH.add(new Customer(name, phone, group));
    }

    //번호 검색 메소드
    private void searchNumber() {
        System.out.println("\n"+"  ☞ 2.전화번호 검색☏ (이름/그룹)"); 
        System.out.print("① 이름 조회 \n② 번호 조회 \n③ 그룹 조회 \n☞ 번호 입력 >>");
        String findName= null;
        String findNum = null;
        int findGroup = 0;
        List<Customer> list=new ArrayList<>();   
        switch (System.console().readLine()) {
            case "1":
                System.out.print("이름을 입력해주세요>>>>");        
                findName = System.console().readLine();
                list = searchAllName(findName);
                break;
            case "2":
                 System.out.print("전화번호을 입력해주세요>>>>");        
                findNum = System.console().readLine();
                list = searchAllNumber(findNum);
                break;
            case "3":
                 System.out.print("그룹번호을 입력해주세요>>>>");        
                findGroup = Integer.parseInt(System.console().readLine());
                list = searchAllGroup(findGroup);
                break;
            default:
                System.out.println("\n숫자를 잘못 누르셨습니다!!\n");
                break;
        }
        if(list.size()==0){
            // System.out.println("   \n:::::조회결과:::::");
            System.out.println("\n  찾는 번호가 없습니다.");
            printNumber(list);
        }
        else 
        return ;


    
    }

    //번호 삭제 메스도
    private void removeNumber() {
        boolean isfind = false;
        System.out.println("  ☞ 3.전화번호 삭제☎");
        System.out.print("이름을 입력해주세요>>>>");
        String remove = System.console().readLine();  
        System.out.println("   \n  :::::조회결과:::::");
        for(int i = 0; i< PH.size(); i++){
            if(PH.get(i).getName().equals(remove)){
                isfind =true;
                System.out.println(String.format("%-10s %-10s %5d",PH.get(i).getName(), PH.get(i).getPhone(),PH.get(i).getGroup()));
                System.out.print("삭제는 엔터, 취소는 n 을 입력하세요 >>");
                if(System.console().readLine().equals("n"))
                return;
                else{
                    
                    PH.remove(i);
                    System.out.println("\t삭제완료");
                    i--;
                }
            }
        }
        if(!isfind){
            System.out.println("\n찾으시는 이름이 존재하지 않습니다.\n");
        }
    }
    
    //출력 메소드
    private void printNumber() {
        System.out.println("\n\t:::::번호출력:::::");
        System.out.println(String.format("%-10s %-10s %-10s","이름","전화번호","그룹"));
        printNumber(PH);
    }
    
    private void modifyNumber() {
        boolean isfind = false;
        System.out.println("  ☞ 4.전화번호 수정☏");
        System.out.print(" ☞ 번호 입력 >> ");
        String bePhone = System.console().readLine();
        for(int i =0; i<PH.size();i++){
            if(PH.get(i).getPhone().equals(bePhone)){
                isfind =true;
                System.out.println(String.format("%-10s %-10s %5d",PH.get(i).getName(), PH.get(i).getPhone(),PH.get(i).getGroup()));
                System.out.print("계속 수정은 엔터, 취소는 n 을 입력하세요 >>");
                if(System.console().readLine().equals("n"))
                return;
                else{
                    System.out.println(" ☞ 수정할 번호 입력 >> ");
                    String afPhone =System.console().readLine();
                    System.out.println(" ☞ 수정할 그룹 입력 >> ");
                    int reGroup = Integer.parseInt(System.console().readLine());
                    PH.get(i).modify(afPhone, reGroup);
                    System.out.println("\t수정완료");
                    
                    System.out.println(String.format("%-10s %-10s %5d\n",PH.get(i).getName(), PH.get(i).getPhone(),PH.get(i).getGroup()));

                }
                
            }
        }
        if(!isfind){
            System.out.println("\n찾으시는 번호가 존재하지 않습니다.\n");
        }
    }
    
    
    
    private void printNumber(List<Customer> list) {
        // System.out.println("   \n\t:::::조회결과:::::");
        for(Customer PH : list){
            System.out.println(String.format("%-10s %-10s %5d",PH.getName(), PH.getPhone(),PH.getGroup()));
        }
        System.out.println();
    }
    
    private List<Customer> searchAllName(String findName) {
        System.out.println("   \n\t:::::조회결과:::::");
        List<Customer> clist = new ArrayList<>();
        System.out.println(String.format("%-10s %-10s %-10s","이름","전화번호","그룹"));
        for(Customer namelist : PH){
            if(namelist.getName().equals(findName)){
                System.out.println(String.format("%-10s %-10s %5d",namelist.getName(), namelist.getPhone(),namelist.getGroup()));
                clist.add(namelist);
            }
        }
        return clist;
        
    }
    
    private List<Customer> searchAllNumber(String findNum) {
        List<Customer> nlist = new ArrayList<>();
        System.out.println(String.format("%-10s %-10s %-10s","이름","전화번호","그룹"));
        for(Customer numlist : PH){
            if(numlist.getPhone().equals(findNum)){
                System.out.println(String.format("%-10s %-10s %5d",numlist.getName(), numlist.getPhone(),numlist.getGroup()));
            }
        }
        return nlist;
    }
    
    private List<Customer> searchAllGroup(int findGroup) {
 List<Customer> llist = new ArrayList<>();
        System.out.println(String.format("%-10s %-10s %-10s","이름","전화번호","그룹"));
        for(Customer grouplist : PH){
            if(grouplist.getGroup()==findGroup){
                System.out.println(String.format("%-10s %-10s %5d",grouplist.getName(), grouplist.getPhone(),grouplist.getGroup()));
            }
        }
        return llist;
    }
    
    
    public static void main(String[] args) {
        CustmoerManageApp app = new CustmoerManageApp();
        app.start();

    }
}