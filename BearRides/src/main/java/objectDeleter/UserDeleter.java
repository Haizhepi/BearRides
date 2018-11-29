package objectDeleter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserDeleter implements SQLStatementExecuter {
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: executes without return
     * return: void
     * precondition: void
     * postcondition: user object is deleted
     */
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }
    
    /*
     * description: executes with return
     * return: void
     * precondition: void
     * postcondition: user object is deleted
     */
    @Override
    public Statement executeQuery(Connection connection, Object object) {
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
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
