/*
 * Contributors: Ash
 * Description: This class serves as our data structure for messages
 * Date Last Modified: 10/22/2018
 */

package table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.swing.table.AbstractTableModel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import object.Message;
import object.Trip;
import object.User;

@XmlRootElement
public class MessageTable extends AbstractTableModel {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public MessageTable() {
        messages = new ArrayList<Message>();
        userMap = TreeMultimap.create();
        tripQueue = TreeMultimap.create();
        
        mailMan = new User("BearRides@baylor.edu", UUID.randomUUID().toString());
        mailMan.setName("mailMan");
        mailMan.setContact("BearRides@Baylor.edu");
        mailMan.insertRating(999);
    }
    
    /*¯`·._.·(¯`·._.· Insertion ·._.·´¯)·._.·´¯*/
    
    /*
     * description: inserts a message
     * return: true if inserted
     * precondition: void
     * postcondition: the new message will be mapped
     */
    public Boolean insert(Message message) {
        Trip trip = message.getTrip();
        
        return messages.add(message) &&
                userMap.put(message.getCreator(), message) &&
                trip != null ? tripQueue.put(trip.getOriginTime(), trip) : true;
    }
    
    /*¯`·._.·(¯`·._.· Removal ·._.·´¯)·._.·´¯*/
    
    /*
     * description: removes all references to messages from one user
     * return: false if one of their messages can't be removed.
     * precondition: void
     * postcondition: all messages that can be removed will be
     */
    public Boolean removeAll(User user) {
        Boolean flag = true;
        
        for(Message message : fromUser(user)) {
            flag = remove(message) && flag;
        }
        
        return flag;
    }
    
    /*
     * description: removes all references to message from this database
     * return: true if successfully removed in all places
     * precondition: void
     * postcondition: all references to the message that can be
     *      removed are removed
     */
    public Boolean remove(Message message) {
        Trip trip = message.getTrip();
        
        return messages.remove(message) &&
                userMap.remove(message.getCreator(), message) &&
                trip != null ? tripQueue.remove(trip.getOriginTime(), trip) : true;
    }
    
    /*¯`·._.·(¯`·._.· Getters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: getter
     * return: COLUMN_COUNT
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }
    
    /*
     * description: getter
     * return: the size of messages
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int getRowCount() {
        return messages.size();
    }
    
    /*
     * description: getter
     * return: the value in messages at index row if it can, or null
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public Object getValueAt(int row, int col) {
        return (col < COLUMN_COUNT && row < messages.size()) ? messages.get(row) : null;
    }
    
    /*
     * description: getter
     * return: the list of messages
     * precondition: void
     * postcondition: nothing is changed
     */
    public List<Message> getMessages() {
        return messages;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: verifies references to message
     * return: void
     * precondition: void
     * postcondition: nothing is changed
     */
    public Boolean checkFor(Message message) {
        return messages.contains(message)
                && userMap.containsValue(message)
                && message.getTrip() != null ? tripQueue.containsValue(message.getTrip()) : true;
    }
    
    /*
     * description: gets all messages from a user
     * return: the messages from user if it can or null
     * precondition: void
     * postcondition: nothing is changed
     */
    public Collection<Message> fromUser(User user) {
        return userMap.get(user);
    }
    
    /*
     * description: pushes reminder notifications to each user with a trip on date
     * return: void
     * precondition: void
     * postcondition: a new notification may be put into any user
     */
    public void pushReminders(Date date) {
        if(tripQueue != null) {
            for(Trip trip : tripQueue.get(date)) {
                @SuppressWarnings("deprecation")
                String title = "Your next Trip to " + trip.getDestinLoc() + " is in "
                + Integer.toString(trip.getOriginTime().getDay() - new Date().getDay())
                + " days!";
                
                String body = ",\n\n" + title + "\nWe hope you'll have a great time,"
                        + " but in case you have to cancel please do so ASAP"
                        + " for the sake of everyone else. \n\n"
                        + "Be safe! -/n BearRides Dev Team";
                String greeting;
                Message message;
                
                for(User user : trip.getRiders()) {
                    greeting = "Hi " + user.getName();
                    
                    message = new Message(mailMan);
                    message.setTitle(title);
                    message.setBody(greeting + body);
                    message.setHidden(true);
                    
                    insert(message);
                    user.insertNotification(message);
                }
                User driver = trip.getDriver();
                greeting = "Hi " + driver.getName();
                
                message = new Message(mailMan);
                message.setTitle(title);
                message.setBody(greeting + body);
                message.setHidden(true);
                
                insert(message);
                driver.insertNotification(message);
            }
        }else {
        }
    }
    
    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    private List<Message> messages;
    @XmlElement
    private Multimap<User, Message> userMap;
    @XmlElement
    private Multimap<Date, Trip> tripQueue;
    @XmlElement
    private User mailMan;
    
    //variable not to be saved upon shutdown
    private final int COLUMN_COUNT = 1;
    private static final long serialVersionUID = 7104942565195945524L;
}