package objectDeleter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleDeleter implements SQLStatementExecuter {
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: executes without return
     * return: void
     * precondition: void
     * postcondition: vehicle object is deleted
     */
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }
    
    /*
     * description: executes with return
     * return: void
     * precondition: void
     * postcondition: vehicle object is deleted
     */
    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Long key = vehicle.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("DELETE FROM Vehicle WHERE id = " + key);
            statement.execute("UPDATE UserTable SET car = NULL WHERE car = " + key);
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
