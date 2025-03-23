
package swing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author BENNET DYANI <bennet.dyani>
 */
public class FileHandlerClass {
    
    FileWriter fw;
    BufferedWriter bf;
    
    public void openFile() throws IOException{
        
        fw = new FileWriter("C:\\Java_2025\\School\\Portfolio\\JavaSwingProject\\EmployeeOutput.txt");
        bf = new BufferedWriter(fw);
       
        
        
    }
 
        public void processFile(String output) throws IOException {
            if(bf != null){
               bf.write(output);
               bf.newLine();
            }else throw new IOException("The file is not open!");
             
        }
    
        public void closeFile() throws IOException{
            if(bf !=null){
                bf.close();
            }
            
        }
}
