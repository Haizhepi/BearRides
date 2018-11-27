/*
 * Contributors: Ash
 * Description: this class serves as our user data structure
 * Date Last Modified: 10/22/2018
 */

package table;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import object.User;

@XmlRootElement
public class UserTable {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public UserTable() {
        userTable = new HashMap<String, User>();
        tokenMap = new HashMap<String, UUID>();
    }
    
    /*~~~~~~~~~~~~ Insertion  ~~~~~~~~~~~~*/
    
    /*
     * description: inserts a user
     * return: true if inserted
     * precondition: void
     * postcondition: the new user will be mapped
     */
    public Boolean insert(User user) {
        return userTable.putIfAbsent(user.getUUID(), user) == null;
    }
    
    /*~~~~~~~~~~~~ Removal  ~~~~~~~~~~~~*/
    
    /*
     * description: removes all references to user
     * return: false if user can't be removed.
     * precondition: void
     * postcondition: all references to user will be removed
     */
    public Boolean remove(User user) {
        return userTable.remove(user.getUUID()) != null;
    }
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: user mapped by uuid
     * precondition: void
     * postcondition: nothing is changed
     */
    public User get(String uuid) {
        return userTable.get(uuid);
    }
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: checks for a user in the list
     * return: void
     * precondition: void
     * postcondition: nothing is changed
     */
    public Boolean checkFor(String uuid) {
        return userTable.containsKey(uuid);
    }
    
    /*
     * description: logs in a user
     * return: null if they couldn't be logged in, user otherwise
     * precondition: void
     * postcondition: the user will have their token set if they were logged in
     */
    public User login(String uuid, String password) {
        if(userTable.containsKey(uuid)) {
            User attempt = userTable.get(uuid);
            
            if(attempt != null &&
                    attempt.getPassHash().equals(password.hashCode()) &&
                    !tokenMap.containsKey(attempt.getUUID())) {
                
                UUID token = generateToken();
                attempt.setToken(token);
                tokenMap.put(attempt.getUUID(), token);
                
                return attempt;
            }else {
            }
        }
        return null;
    }
    
    /*
     * description: authenticates a user by their token
     * return: true if their token matches the one mapped to them
     * precondition: void
     * postcondition: nothing will be changed
     */
    public Boolean authenticate(User user) {
        return user.getToken() != null &&
                user.getToken().equals(tokenMap.get(user.getUUID()));
    }
    
    /*
     * description: logs out a user
     * return: void
     * precondition: void
     * postcondition: the user's token will be set to null and they
     *      will be removed from tokenMap
     */
    public void logout(User user) {
        tokenMap.remove(user.getUUID());
        user.setToken(null);
    }
    
    /*
     * description: generates a user token
     * return: a token
     * precondition: void
     * postcondition: nothing will be changed
     */
    private UUID generateToken() {
        return UUID.randomUUID();
    }
    
    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    private Map<String, User> userTable;
    
    //variable not to be saved upon shutdown
    private Map<String, UUID> tokenMap;
}
