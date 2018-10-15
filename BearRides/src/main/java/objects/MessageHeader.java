package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessageHeader implements Comparable<MessageHeader> {
    
    public MessageHeader(Integer time, String UUID, String title) {
        this.UMID = time + UUID;
        this.title = title;

        this.hidden = false;
    }

    public int compareTo(MessageHeader that) {
        return this.UMID.compareTo(that.UMID);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((UMID == null) ? 0 : UMID.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
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
        MessageHeader other = (MessageHeader) obj;
        if (UMID == null) {
            if (other.UMID != null)
                return false;
        } else if (!UMID.equals(other.UMID))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return this.title;
    }

    // getters
    public String getUMID() {
        return this.UMID;
    }

    public String getTitle() {
        return this.title;
    }

    public Boolean isHidden() {
        return this.hidden;
    }

    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    // variables
    @XmlElement
    protected String UMID;
    @XmlElement
    protected String title;
    
    @XmlElement
    public Boolean hidden;
}
