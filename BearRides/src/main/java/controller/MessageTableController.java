/*
 * Contributors: Ash
 * Description: define input and out buffers for program here
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JOptionPane;

import object.Message;
import object.Trip;
import object.User;
import table.MessageTable;


public class MessageTableController {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public MessageTableController() {
        sorter = new TableRowSorter<MessageTable>();
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: generic sorter
     * return: void
     * precondition: void
     * postcondition: table is sorted respectively to sorters
     */
    public void sortBy(Sorters sorters, MessageTable table) {
        Comparator<Message> compare;
        
        switch(sorters) {
        case POST_TIME:
            compare = new postTimeComparator();
            break;
        case ORIGIN_TIME:
            compare = new tripOriginTimeComparator();
            break;
        case DESTIN_TIME:
            compare = new tripDestinTimeComparator();
            break;
        case RETURN_TIME:
            compare = new tripReturnTimeComparator();
            break;
        case PASSENGER_CAP:
            compare = new tripPassengerCapComparator();
        default:
            return;
        }
        
        Collections.sort(table.getMessages(), compare);
        table.fireTableDataChanged();
    }
    
    /*
     * description: generic filter
     * return: void
     * precondition: void
     * postcondition: table is filtered by search respectively to filters
     */
    public void filterBy(Filters filters, String search, JTable table) {
        RowFilter<TableModel, Integer> filter = null;
        
        switch(filters) {
        case CREATOR:
            filter = new driverFilter(search);
            break;
        case HAS_TRIP:
            filter = new hasTripFilter();
            break;
        case ORIGIN_LOC:
            filter = new originLocFilter(search);
            break;
        case DESTIN_LOC:
            filter = new destinLocFilter(search);
            break;
        case RETURN_LOC:
            filter = new returnLocFilter(search);
            break;
        case PASSENGER_CAP:
            filter = new passengerCapFilter(search);
            break;
        default:
            return;
        }
        
        sorter.setRowFilter(filter);
        table.setRowSorter(sorter);
    }
    
    /*
     * description: posts a message to table
     * return: void
     * precondition: void
     * postcondition: a new message may be put into table if its valid
     */
    public void postMessage(Message message, MessageTable table) {
        //make sure the user is logged in and who they say the are
        // then make sure all the fields in the message are valid
        if(authenticate(message) && verify(message)) {
            table.insert(message);
            table.fireTableDataChanged();
        }else {
            JOptionPane.showMessageDialog(null, "Error: this message is not valid, "
                    + "please make sure all the fields are filled.");
        }
    }
    
    /*
     * description: authenticates the user posting the message
     * return: true if authentic user
     * precondition: void
     * postcondition: nothing is changed
     */
    private Boolean authenticate(Message message) {
        User user = message.getCreator();
        return user.getTable().authenticate(user);
    }
    
    /*
     * description: authenticates the user editing the message
     * return: true if authentic user
     * precondition: void
     * postcondition: nothing is changed
     */
    private Boolean authenticate(Message newMessage, Message oldMessage) {
        return newMessage.getCreator().equals(oldMessage.getCreator()) && authenticate(newMessage);
    }
    
    /*
     * description: verifies that a message is valid
     * return: true if valid
     * precondition: void
     * postcondition: nothing is changed
     */
    private Boolean verify(Message message) {
        Trip trip = message.getTrip();
        
        return !message.getBody().isEmpty() &&
                !message.getTitle().isEmpty() &&
                trip != null ? verify(trip) : true;
    }
    
    /*
     * description: verifies that a trip is valid
     * return: true if valid
     * precondition: void
     * postcondition: nothing is changed
     */
    private Boolean verify(Trip trip) {
        Date now = new Date();
        
        return trip.getOriginLoc() != null &&
                trip.getDestinLoc() != null &&
                trip.getReturnLoc() !=  null &&
                trip.getOriginTime() != null &&
                trip.getDestinTime() != null &&
                trip.getReturnTime() != null &&
                trip.getOriginTime().after(now) &&
                trip.getDestinTime().after(now) &&
                trip.getReturnTime().after(now);
    }
    
    /*
     * description: replaces an old message with a new message
     * return: void
     * precondition: void
     * postcondition: the old message might be replaced
     */
    public void editMessage(Message newMessage, Message oldMessage, MessageTable table) {
        if(authenticate(newMessage, oldMessage)) {
            if(verify(newMessage)) {
                table.insert(newMessage);
                table.remove(oldMessage);
                table.fireTableDataChanged();
            } else {
                //jOptionpane
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: this account is not logged in here.");
        }
    }
    
    /*
     * description: removes all messages from a user
     * return: void
     * precondition: void
     * postcondition: if the user is authentic the messages are cleared
     */
    public void clearUser(User user, MessageTable table) {
        if(user.getTable().authenticate(user)) {
            table.removeAll(user);
        }else {
            JOptionPane.showMessageDialog(null, "Error: this account is not logged in here.");
        }
    }
    
    /*
     * description: reminds all participants of trip on the given date
     * return: void
     * precondition: void
     * postcondition: notifications are sent to the participants
     */
    public void remind(Date date, MessageTable table) {
        if(date.after(new Date())) {
            table.pushReminders(date);
        }else {
        }
    }
    
    //variable not to be saved upon shutdown
    private TableRowSorter<MessageTable> sorter;
    public enum Sorters {
        POST_TIME, ORIGIN_TIME, DESTIN_TIME, RETURN_TIME, PASSENGER_CAP
    }
    public enum Filters {
        CREATOR, HAS_TRIP, ORIGIN_LOC, DESTIN_LOC, RETURN_LOC, PASSENGER_CAP
    }
}

class postTimeComparator implements Comparator<Message> {
    /*
     * description: compares two messages
     * return: 0 if equal
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int compare(Message arg0, Message arg1) {
        return arg0.getPostTime().compareTo(arg1.getPostTime());
    }
}

class tripOriginTimeComparator implements Comparator<Message> {
    /*
     * description: compares two messages
     * return: 0 if equal
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int compare(Message arg0, Message arg1) {
        Trip trip0 = arg0.getTrip();
        Trip trip1 = arg1.getTrip();
        
        Date date0 = (trip0 != null) ? trip0.getOriginTime() : new Date(0);
        Date date1 = (trip1 != null) ? trip1.getOriginTime() : new Date(0);
        
        return date0.compareTo(date1);
    }
}

class tripDestinTimeComparator implements Comparator<Message> {
    /*
     * description: compares two messages
     * return: 0 if equal
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int compare(Message arg0, Message arg1) {
        Trip trip0 = arg0.getTrip();
        Trip trip1 = arg1.getTrip();
        
        Date date0 = (trip0 != null) ? trip0.getDestinTime() : new Date(0);
        Date date1 = (trip1 != null) ? trip1.getDestinTime() : new Date(0);
        
        return date0.compareTo(date1);
    }
}

class tripReturnTimeComparator implements Comparator<Message> {
    /*
     * description: compares two messages
     * return: 0 if equal
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int compare(Message arg0, Message arg1) {
        Trip trip0 = arg0.getTrip();
        Trip trip1 = arg1.getTrip();
        
        Date date0 = (trip0 != null) ? trip0.getReturnTime() : new Date(0);
        Date date1 = (trip1 != null) ? trip1.getReturnTime() : new Date(0);
        
        return date0.compareTo(date1);
    }
}

class tripPassengerCapComparator implements Comparator<Message> {
    /*
     * description: compares two messages
     * return: 0 if equal
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public int compare(Message arg0, Message arg1) {
        Trip trip0 = arg0.getTrip();
        Trip trip1 = arg1.getTrip();
        
        Integer cap0 = (trip0 != null) ? trip0.getPassengerCount() : 0;
        Integer cap1 = (trip1 != null) ? trip1.getPassengerCount() : 0;
        
        return cap0.compareTo(cap1);
    }
}

class driverFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public driverFilter(String search) {
        this.search = search;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null && message.getTrip().getDriver().getName().contains(search)) {
                return true;
            }else {
            }
        }
        return false;
    }
    
    String search;
}

class hasTripFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public hasTripFilter() {
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null) {
                return true;
            }else {
            }
        }
        return false;
    }
}

class originLocFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public originLocFilter(String search) {
        this.search = search;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null && message.getTrip().getOriginLoc().contains(search)) {
                return true;
            }else {
            }
        }
        return false;
    }
    
    String search;
}

class destinLocFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public destinLocFilter(String search) {
        this.search = search;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null && message.getTrip().getDestinLoc().contains(search)) {
                return true;
            }else {
            }
        }
        return false;
    }
    
    String search;
}

class returnLocFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public returnLocFilter(String search) {
        this.search = search;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null && message.getTrip().getReturnLoc().contains(search)) {
                return true;
            }else {
            }
        }
        return false;
    }
    
    String search;
}

class passengerCapFilter extends RowFilter<TableModel, Integer> {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯*/
    
    public passengerCapFilter(String search) {
        this.search = search;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    /*
     * description: returns whether a message should be included or not
     * return: true if it should be
     * precondition: void
     * postcondition: nothing is changed
     */
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        TableModel table = row.getModel();
        Integer index = row.getIdentifier();
        
        for (int i = 0; i < row.getValueCount(); i++) {
            Message message = (Message) table.getValueAt(index, i);
            
            if(message.getTrip() != null && message.getTrip().getPassengerCap() > Integer.parseInt(search)) {
                return true;
            }else {
            }
        }
        return false;
    }
    
    String search;
}