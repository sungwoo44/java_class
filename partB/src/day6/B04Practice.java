package day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04Practice {
    public static void main(String[] args) {
        
        Cart bobo = new Cart();


        String[] list= {"1","2","3"};
        int[] listPrices= {100,200,300};

        bobo.setUserid("bobo");
        bobo.setProductName(list);
        bobo.setPrices(listPrices);

        Scanner sc = new Scanner(System.in);

        System.out.println(bobo.getUserid()+"의 리스트");
        System.out.println(String.format("%s\t %2s %6s\t\t", "번호","리스트","가격"));

        for(int i=0; i<bobo.getProductName().length;i++){
            System.out.println(String.format("%-5d %5s\t %6s",i,list[i],listPrices[i] ));
        }

        System.out.println("메뉴를 고르세요");

        int sel=0;
        int [] select = new int[5];

        int k=0;

        while(sel !=-1)
        {
            System.out.print("메뉴번호 >>> ");
            sel = sc.nextInt();
            select[k++]=sel;
        }
         bobo.total_Money(select);
        System.out.println(Arrays.toString(select));
        System.out.println(bobo.getTotal_Money());


    }
}
