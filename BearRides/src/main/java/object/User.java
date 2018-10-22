/*
 * Contributors: Ash
 * Description: This class serves as our data structure for users
 * Date Last Modified: 10/22/2018
 */

package object;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import table.UserTable;

@XmlRootElement
public class User implements Comparable<User> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯)*/
    
    public User(String email, String password) {
        uuid = email;
        passHash = password.hashCode();
        notifications = new TreeSet<Message>();
    }
    
    /*¯`·._.·(¯`·._.· Insertion ·._.·´¯)·._.·´¯*/
    
    /*
     * description: adds a rating
     * return: void
     * precondition: void
     * postcondition: the new rating will be averaged with the rest
     */
    public void insertRating(Integer rating) {
        this.rating = ((this.rating * ratingCount++) + rating) / ratingCount;
    }
    
    /*
     * description: inserts a notification
     * return: void
     * precondition: void
     * postcondition: the notification will be listed
     */
    public void insertNotification(Message notification) {
        notifications.add(notification);
    }
    
    /*¯`·._.·(¯`·._.· Removal ·._.·´¯)·._.·´¯*/
    
    /*
     * description: removes all references to notification
     * return: void
     * precondition: void
     * postcondition: all references to notification will be removed
     */
    public void removeNotification(Message notification) {
        notifications.remove(notification);
    }
    
    /*¯`·._.·(¯`·._.· Getters ·._.·´¯)·._.·´¯)*/
    
    /*
     * description: getter
     * return: uuid
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getUUID() {
        return uuid;
    }
    
    /*
     * description: getter
     * return: passHash
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getPassHash() {
        return passHash;
    }
    
    /*
     * description: getter
     * return: name
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getName() {
        return name;
    }
    
    /*
     * description: getter
     * return: picture
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getPicture() {
        return picture;
    }
    
    /*
     * description: getter
     * return: age
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getAge() {
        return age;
    }
    
    /*
     * description: getter
     * return: gender
     * precondition: void
     * postcondition: nothing is changed
     */
    public Boolean getGender() {
        return gender;
    }
    
    /*
     * description: getter
     * return: contact
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getContact() {
        return contact;
    }
    
    /*
     * description: getter
     * return: rating
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getRating() {
        return rating;
    }
    
    /*
     * description: getter
     * return: token
     * precondition: void
     * postcondition: nothing is changed
     */
    public UUID getToken() {
        return token;
    }
    
    /*
     * description: getter
     * return: notification
     * precondition: void
     * postcondition: nothing is changed
     */
    public Set<Message> getNotifications() {
        return notifications;
    }
    
    /*
     * description: getter
     * return: table
     * precondition: void
     * postcondition: nothing is changed
     */
    public UserTable getTable() {
        return table;
    }

    /*¯`·._.·(¯`·._.· Setters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: passHash is set
     */
    public void setPassHash(Integer passHash) {
        this.passHash = passHash;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: name is set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: picture is set
     */
    public void setPicture(String path) {
        this.picture = path;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: age is set
     */
    public void setAge(Integer age) {
        this.age = age;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: contact is set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: gender is set
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: token is set
     */
    public void setToken(UUID token) {
        this.token = token;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: table is set
     */
    public void setTable(UserTable table) {
        this.table = table;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((car == null) ? 0 : car.hashCode());
        result = prime * result + ((contact == null) ? 0 : contact.hashCode());
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
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        if (uuid == null) {
            if (other.uuid != null)
                return false;
        } else if (!uuid.equals(other.uuid))
            return false;
        return true;
    }
    
    @Override
    public int compareTo(User that) {
        return this.uuid.compareTo(that.uuid);
    }
    
    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    private String uuid;
    @XmlElement
    private Integer passHash;
    @XmlElement
    private Boolean gender;
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
    @XmlElement
    private UserTable table;
    
    //variable not to be saved upon shutdown
    private UUID token = null;
}