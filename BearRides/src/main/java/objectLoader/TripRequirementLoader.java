package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripRequirementLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT tid, req from TripRider";
        
        return true;
    }
}
