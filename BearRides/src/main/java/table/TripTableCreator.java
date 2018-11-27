package table;

import java.sql.Connection;

public class TripTableCreator extends TableCreator {

    @Override
    protected void hook(Connection connection) {
        
        createTableSQL = 
                "CREATE TABLE Trip("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "driver BIGINT NOT NULL, " //foreign key
                + "message BIGINT NOT NULL, " //foreign key
                + "riders FOREIGN_KEY_SET, " //nested table of foreign keys
                + "requirements STRING_SET, " //nested table of foreign keys
                + "originTime BIGINT, "
                + "destinTime BIGINT, "
                + "returnTime BIGINT, "
                + "originLoc CLOB, "
                + "destinLoc CLOB, "
                + "returnLoc CLOB, "
                + "passengerCap INTEGER, "
                + "PRIMARY KEY (id) );";
    }
}
