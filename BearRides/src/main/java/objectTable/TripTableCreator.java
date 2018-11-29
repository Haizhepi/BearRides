package objectTable;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "CREATE TABLE Trip("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "driver BIGINT NOT NULL, " //foreign key
                + "originTime BIGINT, "
                + "destinTime BIGINT, "
                + "returnTime BIGINT, "
                + "originLoc LONG VARCHAR, "
                + "destinLoc LONG VARCHAR, "
                + "returnLoc LONG VARCHAR, "
                + "passengerCap INTEGER, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (driver) REFERENCES UserTable(id) )";
        
        return true;
    }
}
