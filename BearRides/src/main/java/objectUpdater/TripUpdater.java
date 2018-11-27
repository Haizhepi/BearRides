package objectUpdater;

import java.sql.Connection;
import object.Trip;
import object.User;

public class TripUpdater extends Updater {
    
    @Override
    public Boolean hook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        
        if(trip.getPrimaryKey() != null) {
            UpdateSQL = "CREATE TABLE nestedRiders (rider BIGINT);"
                    + "CREATE TABLE nestedRequirements (requirement CLOB);";
            
            for(User rider : trip.getRiders()) {
                UpdateSQL += "INSERT INTO nestedRiders VALUES (" + rider.getPrimaryKey() + ");";
            }
            
            for(String requirement : trip.getRequirements()) {
                UpdateSQL += "INSERT INTO nestedRequirements VALUES ('" + requirement + "');";
            }
            
            UpdateSQL += "UPDATE Trip"
                    + " SET driver = " + trip.getDriver().getPrimaryKey() //BIGINT foreign key
                    + " SET message = " + trip.getMessage().getPrimaryKey() //BIGINT foreign key
                    + " SET riders = nestedRiders" //nested table of BIGINT foreign keys
                    + " SET requirements = nestedRequirements" //nested table of BIGINT foreign keys
                    + " SET originTime = " + trip.getOriginTime().getTime() //BIGINT
                    + " SET destinTime = " + trip.getDestinTime().getTime() //BIGINT
                    + " SET returnTime = " + trip.getOriginTime().getTime() //BIGINT
                    + " SET originLoc = '" + trip.getOriginLoc() //CLOB
                    + "' SET destinLoc = '" + trip.getDestinLoc() //CLOB
                    + "' SET returnLoc = '" + trip.getReturnLoc() //CLOB
                    + "' SET passengerCap = " + trip.getPassengerCap() //INTEGER
                    + " WHERE id = " + trip.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
