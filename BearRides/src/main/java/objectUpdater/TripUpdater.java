package objectUpdater;

import java.sql.Connection;
import java.util.List;

import database.DatabaseProtocol;
import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean hook(Connection connection, Object object) {
        Trip trip = (Trip) object;
        
        if(trip.getPrimaryKey() != null) {
            SQLStatement = "UPDATE Trip"
                    + " SET driver = " + trip.getDriver().getPrimaryKey() //BIGINT foreign key
                    + " SET message = " + trip.getMessage().getPrimaryKey() //BIGINT foreign key
                    + " SET riders = " + DatabaseProtocol.dataTypes.foreignKeySet.toString() //nested table of BIGINT foreign keys
                    + "( ";
            
            List<User> riders = trip.getRiders();
            for(int i = 0, j = riders.size(); i < j; i++) {
                SQLStatement += riders.get(i).getPrimaryKey() + ((i == j - 1) ? " " : " , ");
            }
            
            SQLStatement += ") SET requirements = " + DatabaseProtocol.dataTypes.stringSet.toString() //nested table of CLOB
                    + "( ";
            
            List<String> requirements = trip.getRequirements();
            for(int i = 0, j = riders.size(); i < j; i++) {
                SQLStatement += "'" + requirements.get(i) + "'" + ((i == j - 1) ? " " : " , ");
            }
            
            SQLStatement += ") SET originTime = " + trip.getOriginTime().getTime() //BIGINT
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
