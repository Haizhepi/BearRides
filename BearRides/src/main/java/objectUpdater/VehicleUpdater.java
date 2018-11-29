package objectUpdater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleUpdater implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public ResultSet executeQuery(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("UPDATE Vehicle"
                    + " SET model = '" + vehicle.getModel() //VAR CHAR
                    + "' SET picture = '" + vehicle.getPicture() //VAR CHAR
                    + "' SET passengerCap = " + vehicle.getPassengerCap() //INTEGER
                    + " SET storageSpace = '" + vehicle.getStorageSpace() //VAR CHAR
                    + "' WHERE id = " + vehicle.getPrimaryKey());
            
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
