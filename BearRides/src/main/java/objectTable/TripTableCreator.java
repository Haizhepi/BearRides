package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class TripTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        
        SQLStatement = "CREATE TABLE Trip("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "driver BIGINT NOT NULL, " //foreign key
                + "message BIGINT NOT NULL, " //foreign key
                //+ "requirements STRING_SET, " //nested table of CLOB
                + "originTime BIGINT, "
                + "destinTime BIGINT, "
                + "returnTime BIGINT, "
                + "originLoc CLOB, "
                + "destinLoc CLOB, "
                + "returnLoc CLOB, "
                + "passengerCap INTEGER, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (driver) REFERENCES UserTable(id), "
                + "FOREIGN KEY (message) REFERENCES Message(id) )";
        
        return true;
    }
}
