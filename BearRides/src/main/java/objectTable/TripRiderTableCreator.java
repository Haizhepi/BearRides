package objectTable;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRiderTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        SQLStatement = "CREATE TABLE TripRider("
                + "tid BIGINT NOT NULL,"
                + "uid BIGINT NOT NULL,"
                + "PRIMARY KEY (tid, uid)) ";
        return true;
    }
}
