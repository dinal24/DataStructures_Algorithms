/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dinal
 */
public class Recentqueue {
    private double queue[]=new double[5];
    private int tail=0;

    public void enQueue(double rating) {
        if(tail<5){
          queue[tail]=rating;
          tail++;  
        }
        else{
          for(int i=0;i<4;i++){
              queue[i]=queue[i+1];              
          } 
          queue[4]=rating;
        }
    }
    
    public void view(){
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);;
            
        }
    }
    
}