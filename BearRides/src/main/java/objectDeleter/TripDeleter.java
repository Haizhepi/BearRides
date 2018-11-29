package objectDeleter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Trip;

public class TripDeleter implements SQLStatementExecuter {
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: executes without return
     * return: void
     * precondition: void
     * postcondition: trip object is deleted
     */
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    /*
     * description: executes with return
     * return: void
     * precondition: void
     * postcondition: trip object is deleted
     */
    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("DELETE FROM Trip WHERE id = " + key);
            statement.execute("DELETE FROM TripRequirement WHERE tid = " + key);
            statement.execute("DELETE FROM TripRider WHERE tid = " + key);
            statement.execute("UPDATE Message SET trip = NULL WHERE trip = " + key);
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
