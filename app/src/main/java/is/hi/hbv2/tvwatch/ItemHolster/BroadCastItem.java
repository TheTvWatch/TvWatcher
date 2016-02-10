package is.hi.hbv2.tvwatch.ItemHolster;

/**
 * Created by ari on 10-Feb-16.
 */
public abstract class BroadCastItem {
    private String name = null;
    private int airTime;

    public String getItemName(){
        return this.name;
    }
    public void setItemName(String name){
        this.name = name;
    }
    public void setAirTime(int time){
        this.airTime = time;
    }
    public int minutesToAirTime(){
        return this.airTime;
    }

}
