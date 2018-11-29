/*
 * Contributors: Ash
 * Description: This class serves to handle shutting down the program
 * Date Last Modified: 10/22/2018
 */

package main;

import controller.DashBoard;

public class Shutdown {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
	public Shutdown(DashBoard db) {
	    db.save();
	    System.exit(0);
	}
}