/*
 * Contributors: Ash
 * Description: this class serves as our user data structure
 * Date Last Modified: 10/22/2018
 */

package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import controller.DashBoard;
import object.User;

public class UserCollection {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public UserCollection() {
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
        user.setTable(this);
        return userTable.putIfAbsent(user.getEmail(), user) == null;
    }
    
    /*~~~~~~~~~~~~ Removal  ~~~~~~~~~~~~*/
    
    /*
     * description: removes all references to user
     * return: false if user can't be removed.
     * precondition: void
     * postcondition: all references to user will be removed
     */
    public Boolean remove(User user) {
        DashBoard.removeFromDatabase(user);
        
        return userTable.remove(user.getEmail()) != null;
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
    
    /*
     * description: getter
     * return: all users
     * precondition: void
     * postcondition: nothing is changed
     */
    public Collection<User> getAll(){
        return userTable.values();
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
                    !tokenMap.containsKey(attempt.getEmail())) {
                
                UUID token = generateToken();
                attempt.setToken(token);
                tokenMap.put(attempt.getEmail(), token);
                
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
                user.getToken().equals(tokenMap.get(user.getEmail()));
    }
    
    /*
     * description: logs out a user
     * return: void
     * precondition: void
     * postcondition: the user's token will be set to null and they
     *      will be removed from tokenMap
     */
    public void logout(User user) {
        tokenMap.remove(user.getEmail());
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
    
    //variables to be saved upon shutdown
    private Map<String, User> userTable;
    
    //variable not to be saved upon shutdown
    private Map<String, UUID> tokenMap;
}
