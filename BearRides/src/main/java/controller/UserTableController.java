/*
 * Contributors: Ash
 * Description: define input and out buffers for program here
 * Date Last Modified: 10/22/2018
 */

package controller;

import object.User;
import table.UserTable;

public class UserTableController {
    
    public UserTableController() {
        this.table = new UserTable();
    }
    
    /*
     * description: attempts to login with the provided info
     * return: User
     * precondition: user is not already logged in, user is registered
     * postcondition: the user is marked as logged in and
     */
    public User login(String UUID, String password) {
        User attempt = table.login(UUID, password);
        
        if(attempt == null) {
            //error window
        }else {
        }
        
        return attempt;
    }
    
    public Boolean register(User user) {
        if(user.getUUID().contains("@baylor.edu")) {
        	return table.insert(user);
        } else {
        }
        
        return false;
    }
    
    public Boolean remove(User user) {
    	return table.remove(user);
    }

    public Boolean recover(User user) {
        //stubbed
        return null;
    }

    public void reverifyAll() {
        //stubbed
    }
    
    public Boolean setInfo(User newUser, User oldUser) {
        //stubbed
        return null;
    }
    
    private UserTable table;
}
