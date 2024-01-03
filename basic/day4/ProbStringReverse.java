package basic.day4;

import basic.day1.string;

public class ProbStringReverse {

    // 문자열 뒤집기 
    public static void main(String[] args) {
        String message = "Hello World";

        char[] messageArray = new char[message.length()];

        // String reverse ="";
        // for(int i=messageArray.length-1;i>=0;i--){
        
        //    messageArray[i]+=message.charAt(i); 
        //    reverse += message.charAt(i);

        // }
                        // int cidx = message.length()-1;
                        // for(int i=0; i<message.length()-1; i++){
                        //     char temp = message.charAt(i); 
                        //     messageArray[cidx]=temp; 
                        //     cidx--;
                        // }

        
        for(int i=0; i<message.length()-1; i++){
            char temp = message.charAt(i); 
            messageArray[message.length()-i-1]=temp; 
           
        }

        System.out.println(messageArray);
        //System.out.println(reverse);
    }
}
