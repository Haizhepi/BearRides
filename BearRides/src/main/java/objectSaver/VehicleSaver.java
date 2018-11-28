package objectSaver;

import java.sql.Connection;
import java.sql.SQLException;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleSaver extends SQLStatementExecuter{

    @Override
    protected Boolean hook(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Long key = vehicle.getPrimaryKey();
        
        SQLStatement = "INSERT INTO Vehicle ("
                + ((key != null) ? "id, " : "")
                + "model, picture, passengerCap, storageSpace) VALUES "
                + "(" + ((key != null) ? key + ", " : "")
                + "'" + vehicle.getModel()
                + "', '" + vehicle.getPicture()
                + "', " + vehicle.getPassengerCap()
                + ", '" + vehicle.getStorageSpace()
                + "');";
        
        try {
            vehicle.setPrimaryKey(connection.createStatement().executeQuery("SELECT LAST_INSERT_ID;").getLong(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return true;
    }
}
