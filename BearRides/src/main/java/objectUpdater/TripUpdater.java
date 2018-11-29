package objectUpdater;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
                    + " SET originTime = " + trip.getOriginTime().getTime() //BIGINT
                    + " SET destinTime = " + trip.getDestinTime().getTime() //BIGINT
                    + " SET returnTime = " + trip.getReturnTime().getTime() //BIGINT
                    + " SET originLoc = '" + trip.getOriginLoc() //LONG VARCHAR
                    + "' SET destinLoc = '" + trip.getDestinLoc() //LONG VARCHAR
                    + "' SET returnLoc = '" + trip.getReturnLoc() //LONG VARCHAR
                    + "' SET passengerCap = " + trip.getPassengerCap() //INTEGER
                    + " WHERE id = " + key);
            
            statement.execute("DELETE FROM TripRequirement WHERE tid = " + key);
            statement.execute("DELETE FROM TripRider WHERE tid = " + key);
            
            for(String requirement : trip.getRequirements()) {
                statement.execute("INSERT INTO TripRequirement (tid, req) VALUES ("
                        + trip.getPrimaryKey()
                        + ", " + requirement
                        + ")");
            }

            for(User user : trip.getRiders()) {
                statement.execute("INSERT INTO TripRider (tid, uid) VALUES ("
                        + trip.getPrimaryKey()
                        + ", " + user.getPrimaryKey()
                        + ")");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return statement;
    }
}
