package objectLoader;

import object.Message;
import object.User;

public class UnlinkedMessage extends Message {
    
    public UnlinkedMessage(Long creator, Long trip) {
        this.creator = creator;
        this.trip = trip;
    }
    
    public void setCreator(User user) {
        super.creator = user;
    }
    
    public void setUmid(String Umid) {
        super.umid = umid;
    }
    
    public void setPostTime(String postTime) {
        super.postTime = postTime;
    }
    
    public Long getCreatorKey() {
        return this.creator;
    }
    
    public Long getTripKey() {
        return this.trip;
    }
    
    private Long creator;
    private Long trip;
}
