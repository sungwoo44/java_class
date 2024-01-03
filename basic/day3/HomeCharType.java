package basic.day3;

public class HomeCharType {
    
    public static void main(String[] args) {
        
        //String message = "Hello* Java Hi* Linux~~~"; //숙제 예문
		String message = "*Happy BirthDay*~@*#";
		
		System.out.println("=====문자열을 구성하는 문자의 종류 분석하기=====");
		
		int upperCount=0; //대문자의 갯수
		int lowerCount=0; //소문자의 갯수
		int numberCount=0;//숫자의 갯수
		int symbolCount=0;//기호의 갯수
		
		
		for(int i=0; i<message.length();i++) {
		if(message.charAt(i)>64 && message.charAt(i)<91) { //대문자 아스키코드
			upperCount++;
		}else if(message.charAt(i)>96 && message.charAt(i)<123){//소문자 아스키코드
			lowerCount++;
		}else if(message.charAt(i)>47 && message.charAt(i)<58) {//숫자 아스키코드
			numberCount++;
        }else{symbolCount++;} // 기호 아스키코드 (대문자,소문자,숫자가 아닌 나머지) 
        // else if(message.charAt(i)>31 && message.charAt(i)<48) {//기호 아스키코드
		// 	symbolCount++;
		// }else if(message.charAt(i)>57 && message.charAt(i)<65) {//기호 아스키코드
		// 	symbolCount++;
		// }else if(message.charAt(i)>90 && message.charAt(i)<97) {//기호 아스키코드
		// 	symbolCount++;
		// }else if(message.charAt(i)>122 && message.charAt(i)<127) {//기호 아스키코드
		// 	symbolCount++;
		}
			
		
		
		
		
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("문자열 : "+message);
		System.out.print(String.format("문자종류: 대문자%d개,소문자%d개,숫자%d개,기호%d개",upperCount,lowerCount,numberCount,symbolCount));
		}
	}



