/*
* Contributors: Ash
* Date Last Modified: 10/17/18
 */

package controller;

import object.User;
import table.UserTable;

public class UserTableController {

    /*
     * description: attempts to login with the provided info
     * return: User
     * precondition: user is not already logged in, user is registered
     * postcondition: the user is marked as logged in and 
     */
    public static User login(UserTable table) throws Exception {
        return null;
    }
    
    public static Boolean register(UserTable table, User user) throws Exception {
        return null;
    }
    
    public static Boolean remove(UserTable table, String UUID) {
        return null;
    }

    public static Boolean recover(UserTable table, User user) {
        return null;
    }

    public static void reverifyAll(UserTable table) {
        // stubbed
    }
}
