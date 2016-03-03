package is.hi.hbv2.tvwatch;

/**
 * Created by ari on 14-Feb-16.
 */
public class BroadCastItem {
    private String title;
    private String desc;
    public BroadCastItem(String title, String desc) {

        this.title = title;
        this.desc = desc;

    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
