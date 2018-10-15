package objects;

import java.util.Vector;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip {

    public Trip() {
        // stubbed
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
                + ((passengerCount == null) ? 0 : passengerCount.hashCode());
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
        if (passengerCount == null) {
            if (other.passengerCount != null)
                return false;
        } else if (!passengerCount.equals(other.passengerCount))
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
    public Boolean insertRider(String rider) {
        if (this.riders.size() < this.passengerCount) {
            this.riders.addElement(rider);
            return true;
        } else {
            return false;
        }
    }

    public void insertRequirement(String requirement) {
        this.requirements.addElement(requirement);
    }
    
    //removal
    public Boolean removeRider(String rider) {
        passengerCount--;
        return this.riders.removeElement(rider);
    }

    public Boolean removeRequirement(String requirement) {
        return this.requirements.removeElement(requirement);
    }
    
    // getters
    public Vector<String> getRiders() {
        return this.riders;
    }

    public Vector<String> getRequirements() {
        return this.requirements;
    }

    public String getOriginTime() {
        return this.originTime;
    }

    public String getDestinTime() {
        return this.destinTime;
    }

    public String getReturnTime() {
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
        return this.passengerCount;
    }
    
    // setters
    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public void setDestinTime(String destinTime) {
        this.destinTime = destinTime;
    }

    public void setReturnTime(String returnTime) {
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
        this.passengerCount = passengerCount;
    }
    
    @XmlElement
    private Vector<String> riders;
    @XmlElement
    private Vector<String> requirements;
    
    @XmlElement
    private String originTime;
    @XmlElement
    private String destinTime;
    @XmlElement
    private String returnTime;
    
    @XmlElement
    private String originLoc;
    @XmlElement
    private String destinLoc;
    @XmlElement
    private String returnLoc;
    
    @XmlElement
    private Integer passengerCount;
}