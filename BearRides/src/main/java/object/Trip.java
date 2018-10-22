/*
 * Contributors: Ash
 * Description: This class serves as our data structure for users
 * Date Last Modified: 10/22/2018
 */

package object;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trip implements Comparable<Trip> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯)*/
    
    public Trip(User driver, Message message, Date originTime, Integer passengerCap) {
        this.driver = driver;
        this.message = message;
        this.originTime = originTime;
        this.passengerCap = passengerCap;
        
        riders = new ArrayList<User>();
        requirements = new ArrayList<String>();
    }
    
    /*¯`·._.·(¯`·._.· Insertion ·._.·´¯)·._.·´¯*/
    
    /*
     * description: inserts a user into riders
     * return: true if inserted
     * precondition: void
     * postcondition: the user will be listed if it can be
     */
    public Boolean insertRider(User user) {
        if (riders.size() < passengerCap) {
            return riders.add(user);
        } else {
            return false;
        }
    }
    
    /*
     * description: inserts new requirement into the trip
     * return: void
     * precondition: void
     * postcondition: the requirement will be listed
     */
    public void insertRequirement(String requirement) {
        requirements.add(requirement);
    }
    
    /*¯`·._.·(¯`·._.· Removal ·._.·´¯)·._.·´¯*/
    
    /*
     * description: removes all references to user
     * return: false if user can't be removed.
     * precondition: void
     * postcondition: all references to user will be removed
     */
    public Boolean removeRider(User user) {
        return riders.remove(user);
    }
    
    /*
     * description: removes all references to requirement
     * return: false if requirement can't be removed.
     * precondition: void
     * postcondition: all references to requirement will be removed
     */
    public Boolean removeRequirement(String requirement) {
        return requirements.remove(requirement);
    }
    
    /*¯`·._.·(¯`·._.· Getters ·._.·´¯)·._.·´¯)*/
    
    /*
     * description: getter
     * return: riders
     * precondition: void
     * postcondition: nothing is changed
     */
    public List<User> getRiders() {
        return riders;
    }
    /*
     * description: getter
     * return: requirements
     * precondition: void
     * postcondition: nothing is changed
     */
    public List<String> getRequirements() {
        return requirements;
    }
    
    /*
     * description: getter
     * return: originTime
     * precondition: void
     * postcondition: nothing is changed
     */
    public Date getOriginTime() {
        return originTime;
    }
    
    /*
     * description: getter
     * return: destinTime
     * precondition: void
     * postcondition: nothing is changed
     */
    public Date getDestinTime() {
        return destinTime;
    }
    
    /*
     * description: getter
     * return: returnTime
     * precondition: void
     * postcondition: nothing is changed
     */
    public Date getReturnTime() {
        return returnTime;
    }
    
    /*
     * description: getter
     * return: originLoc
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getOriginLoc() {
        return originLoc;
    }
    
    /*
     * description: getter
     * return: destinLoc
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getDestinLoc() {
        return destinLoc;
    }
    
    /*
     * description: getter
     * return: returnLoc
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getReturnLoc() {
        return returnLoc;
    }
    
    /*
     * description: getter
     * return: the size of riders
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getPassengerCount() {
        return riders.size();
    }
    
    /*
     * description: getter
     * return: passengerCap
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getPassengerCap() {
        return passengerCap;
    }
    
    /*
     * description: getter
     * return: driver
     * precondition: void
     * postcondition: nothing is changed
     */
    public User getDriver() {
        return driver;
    }
    
    /*
     * description: getter
     * return: message
     * precondition: void
     * postcondition: nothing is changed
     */
    public Message getMessage() {
        return message;
    }

    /*¯`·._.·(¯`·._.· Setters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: originTime is set
     */
    public void setOriginTime(Date originTime) {
        this.originTime = originTime;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: destinTime is set
     */
    public void setDestinTime(Date destinTime) {
        this.destinTime = destinTime;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: returnTime is set
     */
    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: originLoc is set
     */
    public void setOriginLoc(String originLoc) {
        this.originLoc = originLoc;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: destinLoc is set
     */
    public void setDestinLoc(String destinLoc) {
        this.destinLoc = destinLoc;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: returnLoc is set
     */
    public void setReturnLoc(String returnLoc) {
        this.returnLoc = returnLoc;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: passengerCap is set
     */
    public void setPassengerCap(Integer passengerCap) {
        this.passengerCap = passengerCap;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: driver is set
     */
    public void setDriver(User driver) {
        this.driver = driver;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((destinLoc == null) ? 0 : destinLoc.hashCode());
        result = prime * result
                + ((destinTime == null) ? 0 : destinTime.hashCode());
        result = prime * result + ((driver == null) ? 0 : driver.hashCode());
        result = prime * result + ((message == null) ? 0 : message.hashCode());
        result = prime * result
                + ((originLoc == null) ? 0 : originLoc.hashCode());
        result = prime * result
                + ((originTime == null) ? 0 : originTime.hashCode());
        result = prime * result
                + ((passengerCap == null) ? 0 : passengerCap.hashCode());
        result = prime * result
                + ((returnLoc == null) ? 0 : returnLoc.hashCode());
        result = prime * result
                + ((returnTime == null) ? 0 : returnTime.hashCode());
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
        if (driver == null) {
            if (other.driver != null)
                return false;
        } else if (!driver.equals(other.driver))
            return false;
        if (message == null) {
            if (other.message != null)
                return false;
        } else if (!message.equals(other.message))
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
        return true;
    }
    @Override
    public int compareTo(Trip arg0) {
        return getOriginTime().compareTo(arg0.getOriginTime());
    }

    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    private User driver;
    @XmlElement
    private Message message;
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