package day6;

import java.util.Scanner;

public class B06MCP1 {
    public static void main(String[] args) {

        MCP1 alisson = new MCP1("Alisson", 1, "Golkeeper", 31, new String[1]);
        MCP1 vandijk = new MCP1("vanDijk", 4, "Centre-Back", 32, new String[1]);
        MCP1 thiago = new MCP1("Thiago", 6, "Central Midfield", 32, new String[1]);
        MCP1 salah = new MCP1("Salah", 11, "Right Winger", 31, new String[1]);
        MCP1 arnold = new MCP1("Arnold", 66, "Right-Back", 25, new String[1]);

        String[] marketvalue= {"32m","32m","10m","65m","70m"};

        System.out.println(alisson);
        System.out.println(thiago);
        System.out.println(salah);
        System.out.println(arnold);
        System.out.println(vandijk);
        System.out.println();

        System.out.println(String.format("%-6s %-6s %-11s %2s %11s ","이름","등번호","포지션","나이","시장가치"));
        System.out.println(alisson.getDate());
        System.out.println(vandijk.getDate());
        System.out.println(thiago.getDate());
        System.out.println(salah.getDate());
        System.out.println(arnold.getDate());


        Scanner sc = new Scanner(System.in);

        int sel=0; 
        int [] select = new int[5];

        int k=0;
        while(sel!=-1){
            System.out.print("선수선택>>>");
            sel=sc.nextInt();
            select[k++]=sel;
        }


        alisson.showvalue(select);


        






    }
}
