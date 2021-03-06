/*
 * Contributors: Ash
 * Description: this serves as our controller for UserTable
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.util.Collection;

import collection.UserCollection;
import object.User;

public class UserCollectionController {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public UserCollectionController() {
        this.table = new UserCollection();
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
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: user mapped by uuid
     * precondition: void
     * postcondition: nothing is changed
     */
    public Collection<User> getUsers() {
        return table.getAll();
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
    public User login(String UUID, String password) {
        return table.login(UUID, password);
    }
    
    /*
     * description: attempts to logout with the provided info
     * return: User
     * precondition: user is logged in, user is registered
     * postcondition: the user is logged out
     */
    public Boolean logout(User user) {
        if(table.authenticate(user)) {
            table.logout(user);
            return true;
        }
        return false;
    }
    
    private User currentUser;
    private UserCollection table;
}
