package basic.day4;

public class A22ForReview {
    public static void main(String[] args) {
        //for문으로 만들기
        //1. 1부터 n까지 더하기
        //2. 1부터 n까지 곱하기
        //3. 시작값 정수 m부터 마지막값 n까지 더하기
        //4. 시작값 정수 m부터 마지막값 n까지 곱하기
        //5. 2의 n승 구하기 : 2를 n번 곱하기 (2진수에서 많이 사용되는 연산)
        int n=0;
        int m=0;
        int sum=0;
        int result=1;   // 곱셉결과를 저장할 변수 
        long longResult=1;

        //1. 1부터 n까지 더하기
        n=100;//1부터 100까지 합 구하기 
        for(int i=1;i<=n;i++){
            sum+=i;
        }
        System.out.println(String.format("문제1) 1부터 %d 까지의 합계:%d", n,sum));


         //2. 1부터 n까지 곱하기
        n=13;//1부터 100까지 곱셈 구하기 
        for(int i=1;i<=n;i++){
            longResult*=i;
        }
        System.out.println(String.format("문제2) 1부터 %d 까지의 곱셈값:%,d", n, longResult));


         //3. 시작값 정수 m부터 마지막값 n까지 더하기
        m=10;// 시작값 정하기 
        sum=0;
        for(int i=m;i<=n;i++){
            sum+=i;
        }
        System.out.println(String.format("문제3) %d부터 %d 까지의 합계:%d",m,n,sum));


        //4. 시작값 정수 m부터 마지막값 n까지 곱하기
        m=10;// 시작값 정하기 
        result=1;
        for(int i=m;i<=n;i++){
            result*=i;
        }
        System.out.println(String.format("문제4) %d부터 %d 까지의 곱셈값:%d",m,n,result));


        //5. 2의 n승 구하기 : 2를 n번 곱하기 (2진수에서 많이 사용되는 연산)

        n=10;
        longResult=1;
        for(int i=1;i<=n;i++){
            longResult*=2;
        }
        System.out.println(String.format("문제5) 2의 %d 승:%,d",n,longResult));


    }
}
