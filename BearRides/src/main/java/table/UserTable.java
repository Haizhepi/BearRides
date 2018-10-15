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
        logger = new HashSet<String>();
    }

    public User login(String UUID, String password) {
        if(!isLogged(UUID)) {
            if(userTable.containsKey(UUID)) {
                User attempt = userTable.get(UUID);
                if(attempt.getPassHash() == password.hashCode()) {
                    logger.add(UUID);
                    return attempt;
                }else {
                }
            }
        } else {
        }
        return null;
    }
    
    public void logout(String UUID) {
        if(isLogged(UUID)) {
            logger.remove(UUID);
        }else {
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
        return logger.contains(UUID);
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
    Set<String> logger;
    
    private static final long serialVersionUID = -8789212477038794129L;
}
