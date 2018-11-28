package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripRequirementTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        SQLStatement = "CREATE TABLE TripRequirement("
                + "tid BIGINT NOT NULL,"
                + "req CLOB NOT NULL,"
                + "PRIMARY KEY (tid)) ";
        return true;
    }
}
