package objectLoader;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRiderLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "SELECT uid, tid from TripRider";
        
        return true;
    }
}
