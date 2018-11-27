package objectSaver;

import java.sql.Connection;
import java.util.List;

import database.DatabaseProtocol;
import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripSaver extends SQLStatementExecuter {
    
    @Override
    protected Boolean hook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        
        SQLStatement = "INSERT INTO Trip (driver, message, riders, requirements, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap) VALUES "
                + "(" + trip.getDriver().getPrimaryKey()
                + ", " + trip.getMessage().getPrimaryKey()
                + ", " + DatabaseProtocol.dataTypes.foreignKeySet
                + "( ";
                
        List<User> riders = trip.getRiders();
        for(int i = 0, j = riders.size(); i < j; i++) {
            SQLStatement += riders.get(i).getPrimaryKey() + ((i == j - 1) ? " " : " , ");
        }
        
        SQLStatement += "), " + DatabaseProtocol.dataTypes.stringSet
                + "( ";
        
        List<String> requirements = trip.getRequirements();
        for(int i = 0, j = riders.size(); i < j; i++) {
            SQLStatement += "'" + requirements.get(i) + "'" + ((i == j - 1) ? " " : " , ");
        }
        
        SQLStatement += "), " + trip.getOriginTime().getTime()
                + ", " + trip.getDestinTime().getTime()
                + ", " + trip.getReturnTime().getTime()
                + ", '" + trip.getOriginLoc()
                + "', '" + trip.getDestinLoc()
                + "', '" + trip.getReturnLoc()
                + "', " +trip.getPassengerCap()
                + ");";
        
        return null;
    }
}
