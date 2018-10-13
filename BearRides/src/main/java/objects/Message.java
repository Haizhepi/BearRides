package objects;

@SuppressWarnings("unused")
public class Message extends MessageHeader implements Comparable<MessageHeader> {
    
    public Message(Integer time, String UUID, String title) {
        super(time, UUID, title);
        
        this.creator = UUID;
        this.postTime = time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((body == null) ? 0 : body.hashCode());
        result = prime * result + ((creator == null) ? 0 : creator.hashCode());
        result = prime * result + ((postTime == null) ? 0 : postTime.hashCode());
        result = prime * result + ((trip == null) ? 0 : trip.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
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
        if (postTime == null) {
            if (other.postTime != null)
                return false;
        } else if (!postTime.equals(other.postTime))
            return false;
        if (trip == null) {
            if (other.trip != null)
                return false;
        } else if (!trip.equals(other.trip))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return this.body;
    }

    // getters
    public String getCreator() {
        return this.creator;
    }

    public Integer getPostTime() {
        return this.postTime;
    }

    public String getBody() {
        return this.body;
    }

    public Trip getTrip() {
        return trip;
    }

    // setters
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public void setBody(String body) {
        this.body = body;
    }

    // variables
    private String creator;
    private Integer postTime;

    private String body;
    private Trip trip;
}
