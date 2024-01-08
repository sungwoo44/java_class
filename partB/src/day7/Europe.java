package day7;

public class Europe extends CountryTest {
    
    @Override
    public void showWhere(){
        System.out.println(String.format("%s 는 %s 대륙입니다.",super.getCountryName(),super.getContinent()));

}
