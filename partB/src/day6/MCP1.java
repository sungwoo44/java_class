package day6;

import java.util.Arrays;

public class MCP1 {
    
    private String playername;          //선수이름
    private int uniformnumber;          //유니폼 번호
    private String position;            //포지션
    private int age;                    //나이
    private String[] marketvalues;      //시장가치


 public MCP1(String[] marketvalues) {
        this.marketvalues = marketvalues;
    }



public MCP1(String playername, int uniformnumber, String position, int age, String[] marketvalues) {
        this.playername = playername;
        this.uniformnumber = uniformnumber;
        this.position = position;
        this.age = age;
        this.marketvalues = marketvalues;
    }

 

   public String getPlayername() {  
        return playername;
    }
    public int getUniformnumber() {
        return uniformnumber;
    }
    public String getPosition() {
        return position;
    }
    public int getAge() {
        return age;
    }
   
    public String getDate(){
        return String.format("%-10s %-5d  %-16s %-10d %10s",playername,uniformnumber,position,age,Arrays.toString(marketvalues));

    }

    public void showvalue(int[] select){
        System.out.println(Arrays.toString(select));

    }
   


}
