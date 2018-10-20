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
    
    public void sortBy(Sorters sort, MessageTable table) {
        Comparator<Message> compare;
        
        switch(sort) {
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
    
    public void filterBy(Filters filt, JTable table, String search) {
        Filter filter = null;
        
        switch(filt) {
        case CREATOR:
            filter = new creatorFilter(new String(), new MessageTable());
            break;
        case TRIP:
            filter = new tripFilter(new String(), new MessageTable());
            break;
        case ORIGINlOC:
            filter = new originLocFilter(new String(), new MessageTable());
            break;
        case DESTINlOC:
            filter = new destinLocFilter(new String(), new MessageTable());
            break;
        case RETURNlOC:
            filter = new returnLocFilter(new String(), new MessageTable());
            break;
        case PASSENGERcAP:
            filter = new passengerCapFilter(new String(), new MessageTable());
            break;
        default:
            return;
        }
        sorter.setRowFilter(filter);
        table.setRowSorter(sorter);
        
    }
    
    public void viewMessage() {
        
    }
    
    public void postMessage() {
        
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
        CREATOR, TRIP, ORIGINlOC, DESTINlOC, RETURNlOC, PASSENGERcAP
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

abstract class Filter extends RowFilter<TableModel, Integer> {
    
    public Filter(String search, TableModel table) {
        this.search = search;
        this.table = table;
    }
    
    String search;
    TableModel table;
}

class creatorFilter extends Filter {
    
    public creatorFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}

class tripFilter extends Filter {
    
    public tripFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}

class originLocFilter extends Filter {
    
    public originLocFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}

class destinLocFilter extends Filter {
    
    public destinLocFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}

class returnLocFilter extends Filter {
    
    public returnLocFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}

class passengerCapFilter extends Filter {
    
    public passengerCapFilter(String search, TableModel table) {
        super(search, table);
    }
    
    @Override
    public boolean include(RowFilter.Entry<? extends TableModel,? extends Integer> row) {
        return false;
    }
}