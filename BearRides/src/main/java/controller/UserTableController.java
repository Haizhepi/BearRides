/*
* Contributors: Ash
* Date Last Modified: 10/17/18
 */

package controller;

import java.util.List;

import object.User;
import table.UserTable;

public class UserTableController {

    /*
     * description: attempts to login with the provided info
     * return: User
     * precondition: user is not already logged in, user is registered
     * postcondition: the user is marked as logged in and
     */
    public static User login(UserTable table, String UUID, String password) throws Exception {
        User attempt = table.login(UUID, password);
        
        if(attempt == null) {
        	throw new Exception("User Not Found");
        }
        
    	return attempt;
    }
    
    public static void register(UserTable table, User user) throws Exception {
        if(!user.getUUID().contains("_") && user.getUUID().equals("@baylor.edu")) {
        	throw new Exception("Invalid Baylor Email-Address");
        } else if (user.getName().contains("[a-zA-Z]+")) {
        	throw new Exception("Name Contains Non-Letter Input");
        }
        
        table.register(user);
    }
    
    public static Boolean remove(UserTable table, User user) {
    	return table.remove(user);
    }

    public static Boolean recover(UserTable table, User user) {
        return null;
    }

    public static void reverifyAll(UserTable table) {
        // stubbed
    }
    
    public static List<String> getPrivateInfo(UserTable table, User user) {
        return null;
    }
    
    public static List<String> getPublicInfo(UserTable table, User user) {
        return null;
    }
    
    public static Boolean setInfo(List<String> info) {
        return null;
    }
    
}
