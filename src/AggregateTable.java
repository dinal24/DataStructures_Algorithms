/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dinal
 */
public class AggregateTable {

    int elements;
    AggregateElement htable[] = new AggregateElement[elements];
    int nextidx = 0;

    public void setValue(int hash, double rating) {

        int i = 0;
        boolean available = false;
        while (htable[i] != null) {
            if (htable[i].getHash() == hash) {
                htable[i].setTimes();
                htable[i].setRatings(rating);
                available = true;
                break;
            }
            i++;
        }
        if (!available) {
            htable[nextidx] = new AggregateElement();
            htable[nextidx].setHash(hash);
            htable[nextidx].setRatings(rating);
            htable[nextidx].setTimes();
            nextidx++;
        }

    }
    
    public void getAggregateRating(Users utable){
        
        for (int i = 0; i < nextidx; i++) {
          double wi = utable.getWeight(htable[i].getHash());
          double ri = htable[i].getRatings(); 
          int k = htable[i].getTimes();
          
        }
        
    }
            
    
    
}

class AggregateElement {

    private int hash;
    private int times = 0;
    private double ratings;

    public double getRatings() {
        return ratings;
    }

    public int getTimes() {
        return times;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int getHash() {
        return hash;
    }

    public void setRatings(double ratings) {
        this.ratings += ratings;
    }

    public void setTimes() {
        this.times++;
    }
}
