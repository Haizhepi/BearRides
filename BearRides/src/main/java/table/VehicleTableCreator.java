package table;

import java.sql.Connection;

public class VehicleTableCreator extends TableCreator {

    @Override
    protected void hook(Connection connection) {
        createTableSQL =
                "CREATE TABLE Vehicle("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "model CLOB NOT NULL, "
                + "picture CLOB, "
                + "passengerCap INTEGER NOT NULL, "
                + "storageSpace CLOB, "
                + "PRIMARY KEY (id) );";
    }
}
