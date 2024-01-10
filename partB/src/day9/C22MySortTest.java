package day9;

import java.util.Arrays;

//순차정렬 알고리즘

public class C22MySortTest {
    public static void main(String[] args) {
        int[] number = {67, 34, 65, 89, 54};
        System.out.println("초기 숫자:        \t" + Arrays.toString(number));


        for(int i =0; i<number.length;i++){
            for(int j=i+1; j<number.length ;j++){
                //비교 조건과 맞지 않으면 number[i] 와 number[j]를 교환하기 

                 if(number[i]<number[j]){
                 int temp = number[j];
                 number[j]= number[i];
                 number[i]= temp;
                }
                System.out.println(String.format("오름차순 정렬 중:i=%d j=%d %s " , i,j, Arrays.toString(number)));
            }

        }
        System.out.println("오름차순 정렬 후: \t" + Arrays.toString(number));
        
       
        System.out.println("초기 숫자:        \t" + Arrays.toString(number));


        for(int i =0; i<number.length;i++){
            for(int j=i+1; j<number.length;j++){
                //내림차순은 number[i]가 number[j] 값보다 크거나 같아야 한다.
                //그렇지 않은면 number[i] 와 number[j] 교환하기

                 if(number[i]>number[j]){
                 int temp = number[j];
                 number[j]= number[i];
                 number[i]= temp;
                }
                System.out.println(String.format("오름차순 정렬 중:i=%d j=%d %s " , i,j, Arrays.toString(number)));
            }

        }
        System.out.println("오름차순 정렬 후: \t" + Arrays.toString(number));

    }
}
