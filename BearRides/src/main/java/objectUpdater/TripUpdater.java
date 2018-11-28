package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Trip;

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
                    + " SET originLoc = '" + trip.getOriginLoc() //CLOB
                    + "' SET destinLoc = '" + trip.getDestinLoc() //CLOB
                    + "' SET returnLoc = '" + trip.getReturnLoc() //CLOB
                    + "' SET passengerCap = " + trip.getPassengerCap() //INTEGER
                    + " WHERE id = " + key + ";";
        }else {
            return false;
        }
        return true;
    }
}
