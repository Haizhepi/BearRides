package object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip implements Comparable<Trip> {

    public Trip(User driver, Date originTime, Integer passengerCap) {
        this.driver = driver;
        this.originTime = originTime;
        this.passengerCap = passengerCap;
        
        riders = new ArrayList<User>();
        requirements = new ArrayList<String>();
    }
    
    @Override
    public int compareTo(Trip arg0) {
        return getOriginTime().compareTo(arg0.getOriginTime());
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((destinLoc == null) ? 0 : destinLoc.hashCode());
        result = prime * result
                + ((destinTime == null) ? 0 : destinTime.hashCode());
        result = prime * result
                + ((originLoc == null) ? 0 : originLoc.hashCode());
        result = prime * result
                + ((originTime == null) ? 0 : originTime.hashCode());
        result = prime * result
                + ((passengerCap == null) ? 0 : passengerCap.hashCode());
        result = prime * result
                + ((requirements == null) ? 0 : requirements.hashCode());
        result = prime * result
                + ((returnLoc == null) ? 0 : returnLoc.hashCode());
        result = prime * result
                + ((returnTime == null) ? 0 : returnTime.hashCode());
        result = prime * result + ((riders == null) ? 0 : riders.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Trip other = (Trip) obj;
        if (destinLoc == null) {
            if (other.destinLoc != null)
                return false;
        } else if (!destinLoc.equals(other.destinLoc))
            return false;
        if (destinTime == null) {
            if (other.destinTime != null)
                return false;
        } else if (!destinTime.equals(other.destinTime))
            return false;
        if (originLoc == null) {
            if (other.originLoc != null)
                return false;
        } else if (!originLoc.equals(other.originLoc))
            return false;
        if (originTime == null) {
            if (other.originTime != null)
                return false;
        } else if (!originTime.equals(other.originTime))
            return false;
        if (passengerCap == null) {
            if (other.passengerCap != null)
                return false;
        } else if (!passengerCap.equals(other.passengerCap))
            return false;
        if (requirements == null) {
            if (other.requirements != null)
                return false;
        } else if (!requirements.equals(other.requirements))
            return false;
        if (returnLoc == null) {
            if (other.returnLoc != null)
                return false;
        } else if (!returnLoc.equals(other.returnLoc))
            return false;
        if (returnTime == null) {
            if (other.returnTime != null)
                return false;
        } else if (!returnTime.equals(other.returnTime))
            return false;
        if (riders == null) {
            if (other.riders != null)
                return false;
        } else if (!riders.equals(other.riders))
            return false;
        return true;
    }

    // insertion
    public Boolean insertRider(User user) {
        if (this.riders.size() < this.passengerCap) {
            this.riders.add(user);
            return true;
        } else {
            return false;
        }
    }

    public void insertRequirement(String requirement) {
        this.requirements.add(requirement);
    }
    
    //removal
    public Boolean removeRider(User user) {
        passengerCap--;
        return this.riders.remove(user);
    }

    public Boolean removeRequirement(String requirement) {
        return this.requirements.remove(requirement);
    }
    
    // getters
    public List<User> getRiders() {
        return this.riders;
    }

    public List<String> getRequirements() {
        return this.requirements;
    }

    public Date getOriginTime() {
        return this.originTime;
    }

    public Date getDestinTime() {
        return this.destinTime;
    }

    public Date getReturnTime() {
        return this.returnTime;
    }

    public String getOriginLoc() {
        return this.originLoc;
    }

    public String getDestinLoc() {
        return this.destinLoc;
    }

    public String getReturnLoc() {
        return this.returnLoc;
    }

    public Integer getPassengerCount() {
        return this.passengerCap;
    }
    
    public User getDriver() {
        return driver;
    }
    
    // setters
    public void setOriginTime(Date originTime) {
        this.originTime = originTime;
    }

    public void setDestinTime(Date destinTime) {
        this.destinTime = destinTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public void setOriginLoc(String originLoc) {
        this.originLoc = originLoc;
    }

    public void setDestinLoc(String destinLoc) {
        this.destinLoc = destinLoc;
    }

    public void setReturnLoc(String returnLoc) {
        this.returnLoc = returnLoc;
    }

    public void setPassengerCount(Integer passengerCount) {
        this.passengerCap = passengerCount;
    }
    
    public void setDriver(User user) {
        this.driver = user;
    }
    
    @XmlElement
    private User driver;
    @XmlElement
    private List<User> riders;
    @XmlElement
    private List<String> requirements;
    
    @XmlElement
    private Date originTime;
    @XmlElement
    private Date destinTime;
    @XmlElement
    private Date returnTime;
    
    @XmlElement
    private String originLoc;
    @XmlElement
    private String destinLoc;
    @XmlElement
    private String returnLoc;
    
    @XmlElement
    private Integer passengerCap;
}