package objectLoader;

import java.util.List;

import object.Message;
import object.Trip;

public class UnlinkedTrip extends Trip {

    public UnlinkedTrip(Long driver, Long message, List<Long> riders) {
        this.driver = driver;
        this.message = message;
        this.riders = riders;
    }
    
    public void setMessage(Message message) {
        super.message = message;
    }
    
    public Long getDriverKey() {
        return this.driver;
    }
    
    public Long getMessageKey() {
        return this.message;
    }
    
    public List<Long> getRiderKeys() {
        return this.riders;
    }
    
    private Long driver;
    private Long message;
    private List<Long> riders;
}
