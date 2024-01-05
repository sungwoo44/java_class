package day6;

import java.util.Arrays;

public class Product {

    private String productName;
    private int prices;
    private String company;
    private String[] etc;


    // public Product(){}



    //커스텀 생성자 만들기 
 
    public Product(String productName,int prices,String company,String[] etc) {
        this.productName = productName;
        this.prices = prices;
        this.company = company;
        this.etc = etc;
    }
   
    //getter 만들기 
    public String getProductName() {
        return productName;
    }
    public int getPrices() {
        return prices;
    }
    public String getCompany() {
        return company;
    }
    public String[] getEtc() {
        return etc;
    }

    //모든 필드값을 이용해서 문자열을 만들어 리턴
    public String getDate(){
        return String.format("%s\t %d\t %s\t %s", productName,prices,company,Arrays.toString(etc));
    }
    
}
