/*
 * Contributors: Ash
 * Description: This class serves as our data structure for users
 * Date Last Modified: 10/22/2018
 */

package object;

import java.time.Clock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Comparable<Message> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public Message(User creator) {
        postTime = Clock.systemUTC().instant().toString();
        this.creator = creator;
        
        umid = postTime + creator.getUUID();
        title = new String();
        body = new String();
    }
    
    /*¯`·._.·(¯`·._.· Getters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: getter
     * return: creator
     * precondition: void
     * postcondition: nothing is changed
     */
    public User getCreator() {
        return creator;
    }
    
    /*
     * description: getter
     * return: postTime
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getPostTime() {
        return postTime;
    }
    
    /*
     * description: getter
     * return: body
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getBody() {
        return body;
    }
    
    /*
     * description: getter
     * return: trip
     * precondition: void
     * postcondition: nothing is changed
     */
    public Trip getTrip() {
        return trip;
    }
    
    /*
     * description: getter
     * return: umid
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getUMID() {
        return umid;
    }
    
    /*
     * description: getter
     * return: title
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getTitle() {
        return title;
    }
    
    /*
     * description: getter
     * return: hidden
     * precondition: void
     * postcondition: nothing is changed
     */
    public Boolean isHidden() {
        return hidden;
    }

    /*¯`·._.·(¯`·._.· Setters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: trip is set
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: body is set
     */
    public void setBody(String body) {
        this.body = body;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: title is set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: hidden is set
     */
    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
        result = prime * result + ((hidden == null) ? 0 : hidden.hashCode());
        result = prime * result
                + ((postTime == null) ? 0 : postTime.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((trip == null) ? 0 : trip.hashCode());
        result = prime * result + ((umid == null) ? 0 : umid.hashCode());
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
        Message other = (Message) obj;
        if (body == null) {
            if (other.body != null)
                return false;
        } else if (!body.equals(other.body))
            return false;
        if (creator == null) {
            if (other.creator != null)
                return false;
        } else if (!creator.equals(other.creator))
            return false;
        if (hidden == null) {
            if (other.hidden != null)
                return false;
        } else if (!hidden.equals(other.hidden))
            return false;
        if (postTime == null) {
            if (other.postTime != null)
                return false;
        } else if (!postTime.equals(other.postTime))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (trip == null) {
            if (other.trip != null)
                return false;
        } else if (!trip.equals(other.trip))
            return false;
        if (umid == null) {
            if (other.umid != null)
                return false;
        } else if (!umid.equals(other.umid))
            return false;
        return true;
    }
    
    @Override
    public int compareTo(Message that) {
        return getUMID().compareTo(that.getUMID());
    }
    
    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    protected String umid;
    @XmlElement
    protected String title;
    @XmlElement
    public Boolean hidden = false;
    @XmlElement
    private User creator;
    @XmlElement
    private String postTime;
    @XmlElement
    private String body;
    @XmlElement
    private Trip trip;
}
