package objectLoader;

import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripLoader extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "SELECT id, driver, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap from Trip";
        
        return true;
    }
}
