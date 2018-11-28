package objectDeleter;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        User user = (User) object;
        
        SQLStatement = "DELETE FROM User WHERE id = " + user.getPrimaryKey() + ";"
                + "DELETE FROM Message WHERE creator = " + user.getPrimaryKey() + ";"
                + "DELETE FROM Trip WHERE driver = " + user.getPrimaryKey() + ";"
                + "DELETE FROM Trip WHERE BIGINT(" + user.getPrimaryKey() + ") MEMBER OF riders;"; //need to test!
        
        Vehicle vehicle = user.getVehicle();
        if(vehicle != null) {
            SQLStatement += "DELETE FROM Vehicle WHERE id = " + vehicle.getPrimaryKey() + ";";
        }
        
        return true;
    }
}
