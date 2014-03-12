
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dinal
 */
public class RatingSystem {
    static Heap inputHeap=new Heap();
    
    public static void readData(){
        FileReader fd = null;
        BufferedReader br= null;
        String line = null;        
        
        try {
            fd=new FileReader("Userrating.txt");
            br=new BufferedReader(fd);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        
        for(int i=0;i<1000;i++){
            try {
                line=br.readLine();
            } catch (IOException e) {
                System.out.println("Error");
            }
        
            inputHeap.input(line.substring(5,7)+line.substring(8,10)+line.substring(11,13)+line.substring(14,16)+" "+line);
        }
        
        
        
    }
    public static void main(String[] args) {
        /*
        readData();
        
        inputHeap.heapSort();
        for(int i=0;i<1000;i++){
            System.out.println(inputHeap.output(i));
        }
               
*/
       
        
        
    }
    
    

}

