package objectTable;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class VehicleTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "CREATE TABLE Vehicle("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "model LONG VARCHAR NOT NULL, "
                + "picture LONG VARCHAR, "
                + "passengerCap INTEGER NOT NULL, "
                + "storageSpace LONG VARCHAR, "
                + "PRIMARY KEY (id) )";
        
        return true;
    }
}