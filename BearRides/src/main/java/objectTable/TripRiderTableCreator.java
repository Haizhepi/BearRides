package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripRiderTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        SQLStatement = "CREATE TABLE TripRider("
                + "tid BIGINT NOT NULL,"
                + "uid BIGINT NOT NULL,"
                + "PRIMARY KEY (tid, uid)) ";
        return true;
    }
}
