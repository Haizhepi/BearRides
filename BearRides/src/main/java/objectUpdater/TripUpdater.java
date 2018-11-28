package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean beforeHook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        
        if(key != null) {
            SQLStatement = "UPDATE Trip"
                    + " SET driver = " + trip.getDriver().getPrimaryKey() //BIGINT foreign key
                    + " SET originTime = " + trip.getOriginTime().getTime() //BIGINT
                    + " SET destinTime = " + trip.getDestinTime().getTime() //BIGINT
                    + " SET returnTime = " + trip.getReturnTime().getTime() //BIGINT
                    + " SET originLoc = '" + trip.getOriginLoc() //LONG VARCHAR
                    + "' SET destinLoc = '" + trip.getDestinLoc() //LONG VARCHAR
                    + "' SET returnLoc = '" + trip.getReturnLoc() //LONG VARCHAR
                    + "' SET passengerCap = " + trip.getPassengerCap() //INTEGER
                    + " WHERE id = " + key + ";"
                    + "DELETE FROM TripRequirement WHERE tid = " + key + ";"
                    + "DELETE FROM TripRider WHERE tid = " + key + ";";
            
            for(String requirement : trip.getRequirements()) {
                SQLStatement += "INSERT INTO TripRequirement (tid, req) VALUES ("
                        + trip.getPrimaryKey()
                        + ", " + requirement
                        + ");";
            }
            
            for(User user : trip.getRiders()) {
                SQLStatement += "INSERT INTO TripRider (tid, uid) VALUES ("
                        + trip.getPrimaryKey()
                        + ", " + user.getPrimaryKey()
                        + ");";
            }
        }else {
            return false;
        }
        return true;
    }
}
