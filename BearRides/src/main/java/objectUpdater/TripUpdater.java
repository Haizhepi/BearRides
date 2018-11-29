package objectUpdater;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;

public class TripUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean beforeHook(Statement statement, Object object) {
        Trip trip = (Trip) object;
        Long key = trip.getPrimaryKey();
        

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
            String batch = "INSERT INTO TripRequirement (tid, req) VALUES ("
                    + trip.getPrimaryKey()
                    + ", " + requirement
                    + ")";
            try {
                statement.addBatch(batch);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for(User user : trip.getRiders()) {
            String batch = "INSERT INTO TripRider (tid, uid) VALUES ("
                    + trip.getPrimaryKey()
                    + ", " + user.getPrimaryKey()
                    + ")";
            try {
                statement.addBatch(batch);
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
