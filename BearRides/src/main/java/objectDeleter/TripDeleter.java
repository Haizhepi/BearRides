package objectDeleter;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Trip;

public class TripDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean hook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        
        SQLStatement = "DELETE FROM Trip WHERE id = " + trip.getPrimaryKey() + ";"
                + "UPDATE Message SET trip = NULL WHERE trip = " + trip.getPrimaryKey() + ";";
        
        return true;
    }
}
