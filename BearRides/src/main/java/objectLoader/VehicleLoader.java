package objectLoader;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class VehicleLoader extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "SELECT id, model, picture, passengerCap, storageSpace from Vehicle";
        
        return true;
    }
}