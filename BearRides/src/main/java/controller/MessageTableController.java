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
    
    public MessageTableController() {
        sorter = new TableRowSorter<MessageTable>();
    }
    
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
    
    public void postMessage(Message message, MessageTable table) {
        if(authenticate(message)) {
            if(message.getTitle().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Error: The title can not be empty.");
            }else {
                if(message.getBody().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: The message can not be empty.");
                }else {
                    Trip trip = message.getTrip();
                    Date now = new Date();
                    if(trip == null ||
                            (trip.getOriginTime().after(now) &&
                            trip.getDestinTime().after(now) &&
                            trip.getReturnTime().after(now))) {
                        table.insert(message);
                        table.fireTableDataChanged();
                    }else {
                        JOptionPane.showMessageDialog(null, "Error: The dates for the trip can not be in the past.");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error: this account is not logged in here.");
        }
    }
    
    public void editMessage(Message newMessage, Message oldMessage, MessageTable table) {
        if(authenticate(newMessage, oldMessage)) {
            postMessage(newMessage, table);
            table.remove(oldMessage);
        } else {
            JOptionPane.showMessageDialog(null, "Error: this account is not logged in here.");
        }
    }
    
    public void clearUser(User user, MessageTable table) {
        if(user.getTable().authenticate(user)) {
            table.removeAll(user);
        }else {
            JOptionPane.showMessageDialog(null, "Error: this account is not logged in here.");
        }
    }
    
    public void remind(Date date, MessageTable table) {
        if(date.before(new Date())) {
            table.pushReminders(date);
        }else {
        }
    }
    
    private Boolean authenticate(Message message) {
        User user = message.getCreator();
        return user.getTable().authenticate(user);
    }
    
    private Boolean authenticate(Message newMessage, Message oldMessage) {
        return newMessage.getCreator().equals(oldMessage.getCreator()) && authenticate(newMessage);
    }
    
    public enum Sorters {
        POST_TIME, ORIGIN_TIME, DESTIN_TIME, RETURN_TIME, PASSENGER_CAP
    }
    
    public enum Filters {
        CREATOR, HAS_TRIP, ORIGIN_LOC, DESTIN_LOC, RETURN_LOC, PASSENGER_CAP
    }
    
    private TableRowSorter<MessageTable> sorter;
}

class postTimeComparator implements Comparator<Message> {
    @Override
    public int compare(Message arg0, Message arg1) {
        return arg0.getPostTime().compareTo(arg1.getPostTime());
    }
}

class tripOriginTimeComparator implements Comparator<Message> {
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
    @Override
    public int compare(Message arg0, Message arg1) {
        Trip trip0 = arg0.getTrip();
        Trip trip1 = arg1.getTrip();
        
        Integer date0 = (trip0 != null) ? trip0.getPassengerCount() : 0;
        Integer date1 = (trip1 != null) ? trip1.getPassengerCount() : 0;
        
        return date0.compareTo(date1);
    }
}

class driverFilter extends RowFilter<TableModel, Integer> {
    
    public driverFilter(String search) {
        this.search = search;
    }
    
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
    
    public hasTripFilter() {
    }
    
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
    
    public originLocFilter(String search) {
        this.search = search;
    }
    
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
    
    public destinLocFilter(String search) {
        this.search = search;
    }
    
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
    
    public returnLocFilter(String search) {
        this.search = search;
    }
    
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
    
    public passengerCapFilter(String search) {
        this.search = search;
    }
    
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