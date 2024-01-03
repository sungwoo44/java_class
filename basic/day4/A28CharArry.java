package basic.day4;

//문자열은 문자의 집합. 따라서 문잗열 구성하는 문자 하나씩 가져와 배열에 저장해보자. 
public class A28CharArry {
    public static void main(String[] args) {
        String message = "Hello~ World~ 자바는 어려워.";

        //문자열의 길이 만큼 배열의 크기를 정합니다. 
        char[] messageArray = new char[message.length()];

                    // messageArray.length 도 가능!
        for(int i=0; i<message.length(); i++){
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[i]=temp;
        }
        
        //Char 배열의 특징. 배열이름으로 println 하면?
                                                    // 문자열처럼 출력됨.
        System.out.println(messageArray);

        // 고대 암호: '모모'가 '나연'이한테 비밀 메시지를 보냅니다. 암호문을 만듭니다. 
        //          두사람이 알고 있는 비밀키 값 key=7 을 정했습니다. 암호문은??
        int key =7;
        for(int i=0;i<message.length();i++){
            messageArray[i]+=key;

        }
        System.out.println("비밀 메시지 :\n"+messageArray);
        

        
        for(int i=0;i<message.length();i++){
            messageArray[i]-=key;

        }
        System.out.println("해독 메시지 :\n"+messageArray); //  이거는 안나올꺼~ 이유가 뭘까?
        System.out.println(messageArray);

    }
}
