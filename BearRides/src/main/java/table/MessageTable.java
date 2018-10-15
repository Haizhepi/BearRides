package table;

import java.util.Collection;
import java.util.NavigableSet;

import javax.swing.table.AbstractTableModel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import objects.Message;
import objects.MessageHeader;
import uk.co.omegaprime.btreemap.BTreeMap;

@XmlRootElement
public class MessageTable extends AbstractTableModel {
    
    public MessageTable() {
        this.messageBoard = BTreeMap.create();
        this.userMap = TreeMultimap.create();
    }
    
    public static Boolean pushReminders() {
        return null;
        // stubbed
    }

    public Boolean insert(Message message) {
        userMap.put(message.getCreator(), message);
        return messageBoard.putIfAbsent(message, message) == null;
    }

    public Boolean removeAll(String UUID) {
        userMap.removeAll(UUID);
        return userMap.containsKey(UUID);
    }
    
    public Boolean remove(Message message) {
        userMap.remove(message.getCreator(), message);
        // need to make sure the return is not null upon success
        return messageBoard.remove(message) != null;
    }

    public Message get(MessageHeader message) {
        return messageBoard.get(message);
    }

    public Boolean checkFor(MessageHeader message) {
        return messageBoard.containsKey(message);
    }

    public NavigableSet<MessageHeader> getHeaders() {
        return messageBoard.keySet();
    }

    public Collection<MessageHeader> fromUser(String UUID) {
        return userMap.get(UUID);
    }

    public int getColumnCount() {
        return 0;
    }

    public int getRowCount() {
        return 0;
    }

    public Object getValueAt(int arg0, int arg1) {
        return null;
    }
    
    
    
    @XmlElement
    private BTreeMap<MessageHeader, Message> messageBoard;
    @XmlElement
    private Multimap<String, MessageHeader> userMap;
    
    private static final long serialVersionUID = 7104942565195945524L;
}