package IOday11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 텍스트 파일 --> 한글자씩 읽어오기!!
public class WriteText1 {
    public static void main(String[] args) {
        
        try {
            File file = new File("C:\\Users\\Administrator\\Downloads\\ReadText1.txt");
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("hello~~");
            printWriter.close();


            
        } 
        catch(FileNotFoundException e){
        }
        catch (IOException e) {
            System.out.println("예외 : "+ e.getMessage());

        }



    }
}
