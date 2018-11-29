package objectDeleter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserDeleter implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public ResultSet executeQuery(Connection connection, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("DELETE FROM UserTable WHERE id = " + key);
            statement.execute("DELETE FROM Message WHERE creator = " + key);
            statement.execute("DELETE FROM Trip WHERE driver = " + key);
            statement.execute("DELETE FROM TripRider WHERE uid = " + key);
            
            Vehicle vehicle = user.getVehicle();
            if(vehicle != null) {
                statement.execute("DELETE FROM Vehicle WHERE id = " + vehicle.getPrimaryKey());
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return null;
    }
}
