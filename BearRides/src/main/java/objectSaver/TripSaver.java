package objectSaver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripSaver extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        
        SQLStatement = "INSERT INTO Trip ("
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
                + ");";
                
        for(String requirement : trip.getRequirements()) {
            String batch = "INSERT INTO TripRequirement (tid, req) VALUES ("
                    + trip.getPrimaryKey()
                    + ", " + requirement
                    + ");";
            
            try {
                statement.addBatch(batch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        for(User user : trip.getRiders()) {
            String batch = "INSERT INTO TripRider (tid, uid) VALUES ("
                    + trip.getPrimaryKey()
                    + ", " + user.getPrimaryKey()
                    + ");";
            
           try {
                statement.addBatch(batch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return true;
    }
    
    @Override
    protected void afterHook(Statement statement, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        
        if(key == null) {
            try {
                ResultSet rs = statement.getGeneratedKeys();
                
                if(rs.next()) {
                    trip.setPrimaryKey(rs.getLong(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}