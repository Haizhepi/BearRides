package object;

import java.time.Clock;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Comparable<Message> {
    
    public Message(User user, String title) {
        this.postTime = Clock.systemUTC().instant().toString();
        this.creator = user;
        
        this.umid = postTime + user.getUUID();
        this.title = title;
    }
    
    @Override
    public int compareTo(Message that) {
        return this.getUMID().compareTo(that.getUMID());
    }

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

    // getters
    public User getCreator() {
        return this.creator;
    }

    public String getPostTime() {
        return this.postTime;
    }

    public String getBody() {
        return this.body;
    }

    public Trip getTrip() {
        return trip;
    }
    
    public String getUMID() {
        return this.umid;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean isHidden() {
        return this.hidden;
    }

    // setters
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    // variables
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
