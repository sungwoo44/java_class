package basic.day1;

public class ProbChangeMoney {
    public static void main(String[] args) {
        
             double yenToWonRate=9.29;   //1엔이 몇원? 살떄
            double wonToYenRate=8.97;   //1엔이 몇원? 팔때
            
            int myMon =1000000;                            //여행경비 (100만원)
            double toYen = (myMon/yenToWonRate);          //환전한 엔화 값  
           
            int cost  = 98760;                           //여행비용
            int myYen =(int)(toYen-cost);                //남은 여행 경비
            double toWon =myYen*wonToYenRate;                                  // 남은 경비 환전한 원화 값
            
           
           

            System.out.println("::: 한/일 23.12.28 기준 환율 :::");
            System.out.println("살때 1엔 = "+yenToWonRate);
            System.out.println("팔때 1엔 = "+wonToYenRate);
            System.out.println();
            System.out.println("::: 원화를 엔화로 환전하기 :::");
            System.out.println("환전할 원화는 "+myMon+"입니다.");
            System.out.println("원화를 엔화로 바꿀 때 : "+toYen+"입니다.");
            System.out.println();
            System.out.println("::: 엔화를 원화로 환전할경우 :::");
            System.out.println("일본에서 사용한 금액은 "+cost+" 엔 입니다.");
            System.out.println("남은 엔화는 얼마인가요?(정수)"+myYen+"엔");
            System.out.println("엔화를 원화로 바꿀 때 : "+toWon);
            

    }
}
