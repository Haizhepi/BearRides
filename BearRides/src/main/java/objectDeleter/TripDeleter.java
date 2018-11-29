package objectDeleter;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Trip;

public class TripDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        
        SQLStatement = "DELETE FROM Trip WHERE id = " + key + ";"
                + "DELETE FROM TripRequirement WHERE tid = " + key + ";"
                + "DELETE FROM TripRider WHERE tid = " + key + ";"
                + "UPDATE Message SET trip = NULL WHERE trip = " + key + ";";
        
        return true;
    }
}
