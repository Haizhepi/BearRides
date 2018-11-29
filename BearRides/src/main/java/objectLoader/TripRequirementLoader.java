package objectLoader;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRequirementLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "SELECT tid, req from TripRider";
        
        return true;
    }
}
