/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Dinal
 */
public class User {
    String uname;
    int rtimes;

    public int getRtimes() {
        return rtimes;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }    

    public String getUname() {
        return uname;
    }

    public void setRtimes() {
        this.rtimes++;
    }
  
}
class Users{
    
    User usertable[] = new User[200]; 
    
    public void getUname(){
        
    }
    
    private int getTimes(int idx){
        return usertable[idx].getRtimes();
    }
    
    public double getWeight(int idx){
        
        return 2-1/getTimes(idx);
    }
    
    
    public int generateHash(String s){
        char set[] = s.toCharArray();
        int val=0;
        for (int i = 0; i < set.length; i++) {
            val+=(i+1)*Character.valueOf(set[i]);            
        }
                
        return getHash(val, 1, s);
    }
    
    private int getHash(int val,int rep,String uname){
        int hash;
        hash = ((rep*rep) + val)% 200;
        rep++;
        if (usertable[hash]!=null) {
            if (usertable[hash].getUname()== uname) {
               return hash;
            }     
            else{
               return getHash(hash,rep, uname);
            }
        }
        else{
            return hash;
        }
        
    }
    
    
}