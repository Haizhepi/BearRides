package controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import object.Message;
import object.Trip;
import table.MessageTable;


public class MessageTableController {
    
    public MessageTableController() {
        sorter = new TableRowSorter<MessageTable>();
    }
    
    public void sortBy(Sorters sorters, MessageTable table) {
        Comparator<Message> compare;
        
        switch(sorters) {
        case POSTtIME:
            compare = new postTimeComparator();
            break;
        case ORIGINtIME:
            compare = new tripOriginTimeComparator();
            break;
        case DESTINtIME:
            compare = new tripDestinTimeComparator();
            break;
        case RETURNtIME:
            compare = new tripReturnTimeComparator();
            break;
        case PASSENGERcAP:
            compare = new tripPassengerCapComparator();
        default:
            return;
        }
        
        Collections.sort(table.getMessages(), compare);
        table.fireTableDataChanged();
    }
    
    public void filterBy(Filters filters, JTable table, String search) {
        RowFilter<TableModel, Integer> filter = null;
        
        switch(filters) {
        case CREATOR:
            filter = new driverFilter(search);
            break;
        case HAsTRIP:
            filter = new hasTripFilter();
            break;
        case ORIGINlOC:
            filter = new originLocFilter(search);
            break;
        case DESTINlOC:
            filter = new destinLocFilter(search);
            break;
        case RETURNlOC:
            filter = new returnLocFilter(search);
            break;
        case PASSENGERcAP:
            filter = new passengerCapFilter(search);
            break;
        default:
            return;
        }
        
        sorter.setRowFilter(filter);
        table.setRowSorter(sorter);
    }
    
    public void postMessage(Message message) {
        //authenticate user
        //verify title isnt empty
        //make sure that the message isnt already in the set
        //verify that the body isn't e
    }
    
    public void editMessage() {
        
    }
    
    public void clearUser() {
        
    }
    
    public void remind() {
        
    }
    
    public enum Sorters {
        POSTtIME, ORIGINtIME, DESTINtIME, RETURNtIME, PASSENGERcAP
    }
    
    public enum Filters {
        CREATOR, HAsTRIP, ORIGINlOC, DESTINlOC, RETURNlOC, PASSENGERcAP
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