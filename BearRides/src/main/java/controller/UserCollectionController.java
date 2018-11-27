/*
 * Contributors: Ash
 * Description: this serves as our controller for UserTable
 * Date Last Modified: 10/22/2018
 */

package controller;

import collection.IOBuffers;
import collection.UserCollection;
import object.User;

public class UserCollectionController {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public UserCollectionController() {
        //load from file later
        
        this.table = new UserCollection();
    }
    
    /*~~~~~~~~~~~~ IO  ~~~~~~~~~~~~*/
    
    public void load(IOBuffers buffers) {
    }
    
    public void save(IOBuffers buffers) {
    }
    
    /*~~~~~~~~~~~~ Insertion  ~~~~~~~~~~~~*/
    
    /*
     * description: registers a new user
     * return: void
     * precondition: void
     * postcondition: the new user will be mapped
     */
    public Boolean register(User user) {
        if(user.getEmail().contains("@baylor.edu")) {
        	return table.insert(user);
        } else {
            //error window
        }
        
        return false;
    }
    
    /*~~~~~~~~~~~~ Removal  ~~~~~~~~~~~~*/
    
    /*
     * description: removes user from the table
     * return: void
     * precondition: void
     * postcondition: all references to user will be removed
     */
    public void remove(User user) {
    	table.remove(user);
    }
    
    /*~~~~~~~~~~~~ Setters  ~~~~~~~~~~~~*/
    
    /*
     * description: changes a user
     * return: void
     * precondition: void
     * postcondition: oldUser will be replaced with new user
     */
    public Boolean setInfo(User newUser, User oldUser) {
        //stubbed
        return null;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/

    /*
     * description: recovers an account when someone forgot their password
     * return: void
     * precondition: void
     * postcondition: their account's password is changed
     */
    public void recover(User user) {
        //stubbed
    }
    
    /*
     * description: reverifies all accounts to make sure they are students
     * return: void
     * precondition: void
     * postcondition: accounts are no longer active until verified
     */
    public void reverifyAll() {
        //stubbed
    }
    
    /*
     * description: attempts to login with the provided info
     * return: User
     * precondition: user is not already logged in, user is registered
     * postcondition: the user is marked as logged in and
     */
    public Boolean login(String UUID, String password) {
        currentUser = table.login(UUID, password);
        
        if(currentUser == null) {
            //error window
            return false;
        }else {
        }
        
        return true;
    }
    
    private User currentUser;
    private UserCollection table;
}
