package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleSaver implements SQLStatementExecuter{
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Long key = vehicle.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.executeUpdate("INSERT INTO Vehicle ("
                    + ((key != null) ? "id, " : "")
                    + "model, picture, passengerCap, storageSpace) VALUES "
                    + "(" + ((key != null) ? key + ", " : "")
                    + "'" + vehicle.getModel()
                    + "', '" + vehicle.getPicture()
                    + "', " + vehicle.getPassengerCap()
                    + ", '" + vehicle.getStorageSpace()
                    + "')", Statement.RETURN_GENERATED_KEYS);
            
            if(key == null) {
                try {
                    ResultSet rs = statement.getGeneratedKeys();
                    
                    if(rs.next()) {
                        vehicle.setPrimaryKey(rs.getLong(1));
                    }
                } catch (SQLException e) {
                    LogManager.getLogger().error(e.getMessage(), e);
                }
            }
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
