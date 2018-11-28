package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripLoader extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT id, driver, message, riders, requirements, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap from Trip";
        
        return true;
    }
}
