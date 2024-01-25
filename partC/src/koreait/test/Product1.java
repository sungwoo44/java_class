package koreait.test;

/* 장성우 */
public abstract class Product1 {

    
    protected int  price;
    protected String prdName;


    public abstract String sell(Object object);




    public int getPrice() {
        return price;
    }
    public String getPrdName() {
        return prdName;
    }






    @Override
    public String toString() {
        return "Product [price=" + price + ", prdName=" + prdName + "]";
    }




   

   






}
