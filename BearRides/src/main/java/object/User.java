package object;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User implements Comparable<User> {

    public User(String email, String password) {
        this.email = email;
        this.passHash = password.hashCode();
        notifications = new TreeSet<Message>();
    }
    
    @Override
    public int compareTo(User that) {
        return this.email.compareTo(that.email);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result
                + ((isDriver == null) ? 0 : isDriver.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result
                + ((passHash == null) ? 0 : passHash.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result + ((rating == null) ? 0 : rating.hashCode());
        result = prime * result
                + ((ratingCount == null) ? 0 : ratingCount.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        User other = (User) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        if (car == null) {
            if (other.car != null)
                return false;
        } else if (!car.equals(other.car))
            return false;
        if (contact == null) {
            if (other.contact != null)
                return false;
        } else if (!contact.equals(other.contact))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (gender == null) {
            if (other.gender != null)
                return false;
        } else if (!gender.equals(other.gender))
            return false;
        if (isDriver == null) {
            if (other.isDriver != null)
                return false;
        } else if (!isDriver.equals(other.isDriver))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (passHash == null) {
            if (other.passHash != null)
                return false;
        } else if (!passHash.equals(other.passHash))
            return false;
        if (picture == null) {
            if (other.picture != null)
                return false;
        } else if (!picture.equals(other.picture))
            return false;
        if (rating == null) {
            if (other.rating != null)
                return false;
        } else if (!rating.equals(other.rating))
            return false;
        if (ratingCount == null) {
            if (other.ratingCount != null)
                return false;
        } else if (!ratingCount.equals(other.ratingCount))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

    //insertion
    public void insertRating(Integer rating) {
        this.rating = (this.rating * this.ratingCount++ + rating) / ratingCount;
    }
    
    public void notify(Message notification) {
        this.notifications.add(notification);
    }
    
    //deletion
    public void forget(Message notification) {
        this.notifications.remove(notification);
    }

    // getters
    public String getUUID() {
        return this.email;
    }

    public Integer getPassHash() {
        return this.passHash;
    }

    public String getName() {
        return this.name;
    }

    public String getPicture() {
        return this.picture;
    }

    public Integer getAge() {
        return this.age;
    }

    public Boolean getGender() {
        return this.gender;
    }

    public String getContact() {
        return this.contact;
    }

    public Integer getRating() {
        return this.rating;
    }
    
    public UUID getToken() {
        return token;
    }
    
    public Set<Message> getNotifications(){
        return notifications;
    }

    // setters
    public void setPassHash(Integer passHash) {
        this.passHash = passHash;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String path) {
        this.picture = path;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    
    public void setToken(UUID token) {
        this.token = token;
    }

    // variables
    @XmlElement
    private String email;
    @XmlElement
    private Integer passHash;
    @XmlElement
    private Boolean gender;
    private UUID token = null;
    
    @XmlElement
    private String name;
    @XmlElement
    private String contact;
    @XmlElement
    private Integer age;
    @XmlElement
    private String picture;
    
    @XmlElement
    private Boolean isDriver = false;
    @XmlElement
    private Vehicle car;
    
    @XmlElement
    private Integer rating = 100;
    @XmlElement
    private Integer ratingCount;
    
    @XmlElement
    private SortedSet<Message> notifications;
}