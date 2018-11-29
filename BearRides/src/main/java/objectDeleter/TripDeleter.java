package objectDeleter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Trip;

public class TripDeleter implements SQLStatementExecuter {

    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public ResultSet executeQuery(Connection connection, Object object) {
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
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return null;
    }
}
