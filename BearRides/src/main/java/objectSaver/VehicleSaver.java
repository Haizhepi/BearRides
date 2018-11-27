package objectSaver;

import java.sql.Connection;

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
        
        return true;
    }
}
