package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Trip;

public class TripSaver extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        
        SQLStatement = "INSERT INTO Trip ("
                + ((key != null) ? "id, " : "")
                + "driver, message, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap) VALUES "
                + "(" + ((key != null) ? key + ", " : "")
                + trip.getDriver().getPrimaryKey()
                + ", " + trip.getMessage().getPrimaryKey()
                + ", " + trip.getOriginTime().getTime()
                + ", " + trip.getDestinTime().getTime()
                + ", " + trip.getReturnTime().getTime()
                + ", '" + trip.getOriginLoc()
                + "', '" + trip.getDestinLoc()
                + "', '" + trip.getReturnLoc()
                + "', " +trip.getPassengerCap()
                + ");";
        
        return null;
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