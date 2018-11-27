package objectSaver;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleSaver extends SQLStatementExecuter{

    @Override
    protected Boolean hook(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        
        SQLStatement = "INSERT INTO Vehicle (model, picture, passengerCap, storageSpace) VALUES "
                + "('" + vehicle.getModel()
                + "', '" + vehicle.getPicture()
                + "', " + vehicle.getPassengerCap()
                + ", '" + vehicle.getStorageSpace()
                + "');";
        
        return true;
    }
}
