package objectTable;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRequirementTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        SQLStatement = "CREATE TABLE TripRequirement("
                + "tid BIGINT NOT NULL,"
                + "req LONG VARCHAR NOT NULL,"
                + "PRIMARY KEY (tid)) ";
        return true;
    }
}
