package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class VehicleLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT id, model, picture, passengerCap, storageSpace from Vehicle";
        
        return true;
    }
}
