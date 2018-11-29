/*
 * Contributors: Ash
 * Description: this class serves as the data of any user
 * Date Last Modified: 10/22/2018
 */

package object;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

import collection.UserCollection;

public class User implements Comparable<User> {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public User(String email, String password) {
        this.email = email;
        passHash = password.hashCode();
        notifications = new TreeSet<Message>();
        trips = new ArrayList<Trip>();
    }
    
    public User(String email, Integer passHash) {
        this.email = email;
        this.passHash = passHash;
        notifications = new TreeSet<Message>();
        trips = new ArrayList<Trip>();
    }
    
    /*~~~~~~~~~~~~ Insertion  ~~~~~~~~~~~~*/
    
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
    
    /*
     * description: inserts a trip
     * return: void
     * precondition: void
     * postcondition: the trip will be listed
     */
    public void insertTrip(Trip trip) {
        trips.add(trip);
    }
    
    /*~~~~~~~~~~~~ Removal  ~~~~~~~~~~~~*/
    
    /*
     * description: removes all references to notification
     * return: void
     * precondition: void
     * postcondition: all references to notification will be removed
     */
    public void removeNotification(Message notification) {
        notifications.remove(notification);
    }
    
    /*
     * description: removes all references to trip
     * return: void
     * precondition: void
     * postcondition: all references to trip will be removed
     */
    public void removeTrip(Trip trip) {
        trips.remove(trip);
    }
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: isDriver
     * precondition: void
     * postcondition: nothing is changed
     */
    public Boolean isDriver() {
        return isDriver;
    }
    
    /*
     * description: getter
     * return: the users name
     * precondition: void
     * postcondition: nothing is changed
     */
    public String toString() {
        return name;
    }
    
    /*
     * description: getter
     * return: uuid
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getEmail() {
        return email;
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
    public UserCollection getTable() {
        return collection;
    }
    
    /*
     * description: getter
     * return: primaryKey
     * precondition: void
     * postcondition: nothing is changed
     */
    public Long getPrimaryKey() {
        return primaryKey;
    }
    
    /*
     * description: getter
     * return: car
     * precondition: void
     * postcondition: nothing is changed
     */
    public Vehicle getVehicle() {
        return car;
    }
    
    /*
     * description: getter
     * return: ratingCount
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getRatingCount() {
        return ratingCount;
    }
    
    /*
     * description: getter
     * return: trips
     * precondition: void
     * postcondition: nothing is changed
     */
    public List<Trip> getTrips() {
        return trips;
    }

    /*~~~~~~~~~~~~ Setters  ~~~~~~~~~~~~*/
    
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
    public void setTable(UserCollection table) {
        this.collection = table;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: primaryKey is set
     */
    public void setPrimaryKey(Long key) {
        primaryKey = key;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: car is set
     */
    public void setVehicle(Vehicle vehicle) {
        car = vehicle;
        isDriver = vehicle != null;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: rating is set
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: rating count is set
     */
    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
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
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }
    
    @Override
    public int compareTo(User that) {
        return this.email.compareTo(that.email);
    }
    
    //variables to be saved upon shutdown
    private Long primaryKey = null;
    
    private String email;
    private Integer passHash;
    private Boolean gender;
    private String name;
    private String contact;
    private Integer age;
    private String picture;
    private Boolean isDriver = false;
    private Vehicle car; //reference
    private Integer rating = 100;
    private Integer ratingCount = 1;
    private SortedSet<Message> notifications; //set of references
    private List<Trip> trips; //set of references
    
    //variable not to be saved upon shutdown
    private UserCollection collection;
    private UUID token = null;
}