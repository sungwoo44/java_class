package IOday11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// 텍스트 파일 --> 한글자씩 읽어오기!!
public class ReadText1 {
    public static void main(String[] args) {
        
        try {
            File file = new File("C:\\Users\\Administrator\\Downloads\\ReadText1.txt");
            FileReader fileReader = new FileReader(file);
            int b;
            while ((b=fileReader.read())!=-1) {
                System.out.print((char)b);
                
            }
            fileReader.close();


            
        } 
        catch(FileNotFoundException e){
        }
        catch (IOException e) {
            System.out.println("예외 : "+ e.getMessage());

        }



    }
}
