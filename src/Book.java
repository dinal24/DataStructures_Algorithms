/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Dinal
 */

public class Book {
    private String bname;
    private Recentqueue top5=new Recentqueue();
    private VendorHeap vendorHeap= new VendorHeap();
    private AggregateTable userTable = new AggregateTable();

    public AggregateTable getUserTable() {
        return userTable;
    }

    public void setUserTable(int hash, double rating) {
        this.userTable.setValue(hash, rating);
    }
    
       

    public void setTop5(double rate) {
        top5.enQueue(rate);
    }    

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void viewTop5() {
         top5.view();
    }

    public String getBname() {
        return bname;
    }
    public void setVendors(int idx){
        vendorHeap.input(idx);
    }    
        
}
class Books{
    Book booktable[]= new Book[400];
    
    public int generateHash(String s){
        char set[] = s.toCharArray();
        int val=0;
        for (int i = 0; i < set.length; i++) {
            val+=(i+1)*Character.valueOf(set[i]);            
        }                
        return getHash(val, 1, s);
    }
    
    private int getHash(int val,int rep,String bname){
        int hash;
        hash = ((rep*rep) + val)% 200;
        rep++;
        if (booktable[hash]!=null) {
            if (booktable[hash].getBname()== bname) {
               return hash;
            }     
            else{
               return getHash(hash,rep, bname);
            }
        }
        else{
            return hash;
        }        
    }        
}


class VendorHeap{
    
   private int length=0;
   private int vendoridx[]=new int[1000];
   private Vendors vendorstable;
    
    
    public void input(int idx){    //input data to the heap
        int i = 0;
        boolean available = false;
        while(i<=length){
           if(vendoridx[i]==idx){
               available=true;
               break;
           } 
            i++;
        }
        if (!available) {
            vendoridx[length]=idx;
            length++;
        }
    
    }
    
    public String output(int x){        //take out nay data according to given index
        return "";
    }
    
    public void heapify(Vendors vendortable,int i){        //standard heapify operation
        
        int l,r,largest;
        l=2*i+1;
        r=2*i+2;
        if(l<=length && vendortable.getRatings(vendoridx[l])> vendortable.getRatings(vendoridx[i])){
            largest=l;
        }
        else largest=i;
        if(r<=length && vendortable.getRatings(vendoridx[l])> vendortable.getRatings(vendoridx[largest])){
            largest=r;
        }
        if(largest!=i){
            int temp = vendoridx[i];
            vendoridx[i]=vendoridx[largest];
            vendoridx[largest]=temp;
            heapify(vendortable,largest);
        }
    }
    
    public void buildHeap(Vendors vtable){    //standard buildHeap operation
        for(int i=(length+1)/2;i>=0;i--){
            heapify(vtable,i);
        }
    }
    public void heapSort(Vendors vendorstable){        //standard heapSort operation
        buildHeap(vendorstable);
        int len=length;
        int temp;
        for(int i=length;i>0;i--){
            temp=vendoridx[0];
            vendoridx[0]=vendoridx[i];
            vendoridx[i]=temp;
            length--;
            heapify(vendorstable,0);
        }
        length=len;
    }
    
    
    public void veiwVendors(Vendors vtable){
        for (int i = length; i>0; i--) {
            System.out.println(vtable.getName(vendoridx[i])+vtable.getRatings(vendoridx[i]));             
        }
    }
    
}