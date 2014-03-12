/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Dinal
 */
public class Vendor {
   private String vname;
   private Recentqueue top5=new Recentqueue();
   private int length = 1000;
   private int bookidx[] = new int[length];
   private double rating;

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVname() {
        return vname;
    }
    

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }
    

    public void setBookidx(int idx) {
        int i = 0;
        boolean available = false;
        while(i<=length){
           if(bookidx[i]==idx){
               available=true;
               break;
           } 
            i++;
        }
        if (!available) {
            bookidx[length]=idx;
            length++;
        }
    }

    public void setTop5(double rate) {
        top5.enQueue(rate);
    }
       
}
class Vendors{
    
    Vendor vendortable[] = new Vendor[200];
    
    public void enterVendors(String name){
        
    }
    
    public int generateHash(String s){
        char set[] = s.toCharArray();
        int val=0;
        for (int i = 0; i < set.length; i++) {
            val+=(i+1)*Character.valueOf(set[i]);            
        }
                
        return getHash(val, 1, s);
    }
    
    private int getHash(int val,int rep,String vname){
        int hash;
        hash = ((rep*rep) + val)% 200;
        rep++;
        if (vendortable[hash]!=null) {
            if (vendortable[hash].getVname()== vname) {
               return hash;
            }     
            else{
               return getHash(hash,rep, vname);
            }
        }
        else{
            return hash;
        }
        
    }
    
    
    
    public double getRatings(int idx){
       return vendortable[idx].getRating();
    }
    
    public void setRatings(int idx,double r){
        vendortable[idx].setRating(r);
    }
    
    public String getName(int idx){
        return vendortable[idx].getVname();
    }
    
}

