package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripRiderTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        SQLStatement = "CREATE TABLE TripRider("
                + "uid BIGINT NOT NULL,"
                + "tid BIGINT NOT NULL,"
                + "PRIMARY KEY (uid, tid)) ";
        return true;
    }
}
