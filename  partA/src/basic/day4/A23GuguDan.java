package basic.day4;

public class A23GuguDan {
    public static void main(String[] args) {
        for(int j =1; j<20; j++){
            System.out.println(String.format("======%d 단======",j));
            for(int i=1;i<20; i++){
                System.out.println(String.format("%3d x %3d = %3d",j,i,i*j));
            }

        }
    }
}
