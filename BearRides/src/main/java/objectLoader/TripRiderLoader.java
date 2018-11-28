package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripRiderLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT uid, tid from TripRider";
        
        return true;
    }
}
