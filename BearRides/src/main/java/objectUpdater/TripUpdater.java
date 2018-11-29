package objectUpdater;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripUpdater implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("UPDATE Trip"
                    + " SET driver = " + trip.getDriver().getPrimaryKey() //BIGINT foreign key
                    + ", originTime = " + trip.getOriginTime().getTime() //BIGINT
                    + ", destinTime = " + trip.getDestinTime().getTime() //BIGINT
                    + ", returnTime = " + trip.getReturnTime().getTime() //BIGINT
                    + ", originLoc = '" + trip.getOriginLoc() //LONG VARCHAR
                    + "', destinLoc = '" + trip.getDestinLoc() //LONG VARCHAR
                    + "', returnLoc = '" + trip.getReturnLoc() //LONG VARCHAR
                    + "', passengerCap = " + trip.getPassengerCap() //INTEGER
                    + " WHERE id = " + key);
            
            statement.execute("DELETE FROM TripRequirement WHERE tid = " + key);
            statement.execute("DELETE FROM TripRider WHERE tid = " + key);
            
            for(String requirement : trip.getRequirements()) {
                statement.execute("INSERT INTO TripRequirement (tid, req) VALUES ("
                        + trip.getPrimaryKey()
                        + ", '" + requirement
                        + "')");
            }

            for(User user : trip.getRiders()) {
                statement.execute("INSERT INTO TripRider (tid, uid) VALUES ("
                        + trip.getPrimaryKey()
                        + ", " + user.getPrimaryKey()
                        + ")");
            }
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
