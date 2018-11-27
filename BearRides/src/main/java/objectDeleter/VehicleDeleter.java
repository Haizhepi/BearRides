package objectDeleter;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean hook(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        
        SQLStatement = "DELETE FROM Vehicle WHERE id = " + vehicle.getPrimaryKey() + ";"
                + "UPDATE User SET car = NULL WHERE car = " + vehicle.getPrimaryKey() + ";";
        
        return true;
    }
}
