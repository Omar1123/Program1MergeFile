/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergefiles;

import java.io.BufferedReader;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author jake
 */
public class MergeFiles {

    private FileOutputStream fileStream;    
    private File FILENAME1 = new File("C:\\Users\\Alvarados\\Documents\\projects\\Program1MergeFile\\src\\mergefiles\\AR1.txt");
    private File FILENAME2 = new File("C:\\Users\\Alvarados\\Documents\\projects\\Program1MergeFile\\src\\mergefiles\\AR2.txt");
    private File FILENAME3 = new File("C:\\Users\\Alvarados\\Documents\\projects\\Program1MergeFile\\src\\mergefiles\\AR3.txt");
    private File FILENAME4 = new File("C:\\Users\\Alvarados\\Documents\\projects\\Program1MergeFile\\src\\mergefiles\\AR4.txt");
    int[] myArray = new int[20];
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            MergeFiles mergeF = new MergeFiles();
            mergeF.run();
        } catch (Exception ex) {
            
        }
    }
           
    private void run() {
        System.out.println("Llamando archivos");        
        mergeFileToOne(FILENAME1, FILENAME2);
        getFileThree(FILENAME3);
    }
    
    private void getFileThree(File file){
        int index = 0;
        try {            
            if(file.exists()){
                
                BufferedReader buffer = new BufferedReader(new FileReader(file));                
                String lines;
                                
                while((lines = buffer.readLine())!=null) {                
                    //System.out.println(lines);      
                    myArray[index] = Integer.parseInt(lines);
                    index++;
                }
                buffer.close();
                
              }else{
                System.out.println("Fichero No Existe");
              }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        createFile4();
    }
    
    private void mergeFileToOne(File file1, File file2){
        try {
                                        
            BufferedReader buffer1 = new BufferedReader(new FileReader(file1));                
            BufferedReader buffer2 = new BufferedReader(new FileReader(file2));                
            
            String lines1;
            String lines2;           
            
            while((lines1 = buffer1.readLine())!= null & (lines2 = buffer2.readLine())!=null) {                
                if(Integer.parseInt(lines1) > Integer.parseInt(lines2)) {
                    createFile3(lines1);
                    createFile3(lines2);
                } else {  
                    createFile3(lines2);
                    createFile3(lines1);
                }                                
            }

            buffer1.close();      
            buffer2.close();
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }    
        
    private void createFile3(String number) {        
        try {
          
            if(!FILENAME3.exists()){  
                FILENAME3.createNewFile();
            }
                     
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME3,true), "utf-8"));
            
            writter.write(number + "\r\n");          
          
            writter.close();
            
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        }      
    }    
    private void createFile4(){
        Arrays.sort(myArray);
          try {
          
            if(!FILENAME4.exists()){  
                FILENAME4.createNewFile();
            }
                     
            BufferedWriter writter =new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILENAME4,true), "utf-8"));
            for(int i= myArray.length -1; i > 0 ; i--){
                writter.write(myArray[i]+ "\r\n");      
                System.out.println(myArray[i]);
            }    
          
            writter.close();
            
        } catch (Exception ex) {
          //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        } 
    }
}
