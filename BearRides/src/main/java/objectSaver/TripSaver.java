package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripSaver implements SQLStatementExecuter {
    
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

            
            statement.executeUpdate("INSERT INTO Trip ("
                    + ((key != null) ? "id, " : "")
                    + "driver, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap) VALUES "
                    + "(" + ((key != null) ? key + ", " : "")
                    + trip.getDriver().getPrimaryKey()
                    + ", " + trip.getOriginTime().getTime()
                    + ", " + trip.getDestinTime().getTime()
                    + ", " + trip.getReturnTime().getTime()
                    + ", '" + trip.getOriginLoc()
                    + "', '" + trip.getDestinLoc()
                    + "', '" + trip.getReturnLoc()
                    + "', " +trip.getPassengerCap()
                    + ")", Statement.RETURN_GENERATED_KEYS);
            
            if(key == null) {
                try {
                    ResultSet rs = statement.getGeneratedKeys();
                    
                    if(rs.next()) {
                        trip.setPrimaryKey(rs.getLong(1));
                    }
                } catch (SQLException e) {
                    LogManager.getLogger().error(e.getMessage(), e);
                }
            }


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