package objectDeleter;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statementn, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Long key = vehicle.getPrimaryKey();
        
        SQLStatement = "DELETE FROM Vehicle WHERE id = " + key + ";"
                + "UPDATE UserTable SET car = NULL WHERE car = " + key + ";";
        
        return true;
    }
}
