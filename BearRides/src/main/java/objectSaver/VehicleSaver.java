package objectSaver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleSaver extends SQLStatementExecuter{

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
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
                + "')";


        
        return true;
    }

    protected void afterHook(Statement statement, Object object) {
        Vehicle vehicle = (Vehicle)object;
        try {
            vehicle.setPrimaryKey(statement.executeQuery("SELECT IDENTITY_VAL_LOCAL() FROM Vehicle").getLong(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
