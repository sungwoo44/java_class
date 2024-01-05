package day6;

public class Cart {
    
    private String userid;
    private String[] productName;
    private int[] prices;
    private int total_Money;
    
    //getter
    public String getUserid() {
        return userid;
    }
    public String[] getProductName() {
        return productName;
    }
    public int[] getPrices() {
        return prices;
    }
    public int getTotal_Money() {
        return total_Money;
    }

    //setter
    // public void setTotal_Money(int total_Money) { //우리가 짠 코드에서는 불필요
    //     this.total_Money = total_Money;            // total_Money()가 대신 값을 계산해서 저장.
    // }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public void setProductName(String[] productName) {
        this.productName = productName;
    }
    public void setPrices(int[] prices) {
        this.prices = prices;
    }


    // 추가적인 인스턴스 메소드 
    public void total_Money(int[] select){  // Setter 역할로 변경!

        int sum=0;
        for(int i=0;i<select.length-1;i++){
            int temp =select[i];
            if(temp == -1 ) break;  // 반복문 중지
            sum += prices[temp];
        }

        this.total_Money=sum;

    }
}
