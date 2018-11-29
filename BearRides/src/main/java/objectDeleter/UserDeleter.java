package objectDeleter;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserDeleter extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        
        SQLStatement = "DELETE FROM UserTable WHERE id = " + key + ";"
                + "DELETE FROM Message WHERE creator = " + key + ";"
                + "DELETE FROM Trip WHERE driver = " + key + ";"
                + "DELETE FROM TripRider WHERE uid = " + key + ";";
        
        Vehicle vehicle = user.getVehicle();
        if(vehicle != null) {
            SQLStatement += "DELETE FROM Vehicle WHERE id = " + vehicle.getPrimaryKey() + ";";
        }
        
        return true;
    }
}
