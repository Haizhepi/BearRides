package table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import objects.User;

@XmlRootElement
public class UserTable extends AbstractTableModel {
    
    public UserTable() {
        userTable = new HashMap<String, User>();
        loginTracker = new HashSet<String>();
    }

    public User login(String UUID, String password) {
        if(isLogged(UUID)) {
            return null;
        } else {
            User attempt = userTable.get(UUID);
            return (attempt.getPassHash() == password.hashCode()) ? attempt : null;
        }
    }

    public Boolean insert(User user) {
        return userTable.putIfAbsent(user.getUUID(), user) == null;
    }

    public Boolean remove(String UUID) {
        return  userTable.remove(UUID) != null;
    }

    public User get(String UUID) {
        return userTable.get(UUID);
    }

    public Boolean checkFor(String UUID) {
        return userTable.containsKey(UUID);
    }
    
    private Boolean isLogged(String UUID) {
        return loginTracker.contains(UUID);
    }

    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int getRowCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Object getValueAt(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @XmlElement
    Map<String, User> userTable;
    @XmlElement
    Set<String> loginTracker;
    
    private static final long serialVersionUID = -8789212477038794129L;
}
