package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripUserRelationTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        SQLStatement = "CREATE TABLE Relation("
                + "UID BIGINT NOT NULL,"
                + "TID BIGINT NOT NULL,"
                + "PRIMARY KEY (UID, TID)) ";
        return true;
    }
}
