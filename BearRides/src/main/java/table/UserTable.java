package table;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import object.User;

@XmlRootElement
public class UserTable {
    
    public UserTable() {
        userTable = new HashMap<String, User>();
        tokenMap = new HashMap<String, UUID>();
    }

    public User login(String uuid, String password) {
        if(userTable.containsKey(uuid)) {
            User attempt = userTable.get(uuid);
            if(attempt.getPassHash().equals(password.hashCode()) &&
                    !tokenMap.containsKey(attempt.getUUID())) {
                UUID token = generateToken();
                attempt.setToken(token);
                tokenMap.put(attempt.getUUID(), token);
                return attempt;
            }
        }
        return null;
    }
    
    public Boolean authenticate(User user) {
        return user.getToken() != null &&
                user.getToken().equals(tokenMap.get(user.getUUID()));
    }
    
    public void register(User user) {
    	this.userTable.put(user.getUUID(), user);
    }
    
    public void logout(User user) {
        tokenMap.remove(user.getUUID());
        user.setToken(null);
    }

    public Boolean insert(User user) {
        return userTable.putIfAbsent(user.getUUID(), user) == null;
    }

    public Boolean remove(User user) {
        return userTable.remove(user.getUUID()) != null;
    }

    public User get(User user, String uuid) {
        return userTable.get(uuid);
    }

    public Boolean checkFor(String uuid) {
        return userTable.containsKey(uuid);
    }
    
    private UUID generateToken() {
        return UUID.randomUUID();
    }
    
    @XmlElement
    Map<String, User> userTable;
    Map<String, UUID> tokenMap;
}
