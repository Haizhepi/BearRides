package table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
    
    public MessageTable() {
        this.messages = new ArrayList<Message>();
        this.userMap = TreeMultimap.create();
        this.tripQueue = TreeMultimap.create();
    }
    
    //insertion
    public Boolean insert(Message message) {
        userMap.put(message.getCreator(), message);
        Trip trip = message.getTrip();
        if(trip != null) {
            tripQueue.put(trip.getOriginTime(), trip);
        }else {
        }
        return messages.add(message);
    }
    
    //removal
    public Boolean removeAll(User user) {
        userMap.removeAll(user);
        return userMap.containsKey(user);
    }
    
    public Boolean remove(Message message) {
        userMap.remove(message.getCreator(), message);
        // need to make sure the return is not null upon success
        return messages.remove(message);
    }

    public Boolean checkFor(Message message) {
        return messages.contains(message);
    }

    public Collection<Message> fromUser(User user) {
        return userMap.get(user);
    }
    
    public void pushReminders(Date date) {
        for(Trip trip : tripQueue.get(date)) {
            for(User user : trip.getRiders()) {
                //generate passenger notification
                user.notify(new Message(null, null));
            }
            
            //generate driver notification
            trip.getDriver().notify(new Message(null, null));
        }
    }
    
    //getters
    public int getColumnCount() {
        return COLUMNcOUNT;
    }

    public int getRowCount() {
        return messages.size();
    }

    public Object getValueAt(int row, int col) {
        return (col < COLUMNcOUNT && row < messages.size()) ? messages.get(row) : null;
    }
    
    public List<Message> getMessages() {
        return messages;
    }
    
    @XmlElement
    private List<Message> messages;
    @XmlElement
    private Multimap<User, Message> userMap;
    @XmlElement
    private Multimap<Date, Trip> tripQueue;
    
    private final int COLUMNcOUNT = 1;
    
    private static final long serialVersionUID = 7104942565195945524L;
}