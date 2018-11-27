package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleUpdater extends SQLStatementExecuter {

    @Override
    public Boolean hook(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        
        if(vehicle.getPrimaryKey() != null) {
            SQLStatement = "UPDATE Vehicle"
                    + " SET model = '" + vehicle.getModel() //CLOB
                    + "' SET picture = '" + vehicle.getPicture() //CLOB
                    + "' SET passengerCap = " + vehicle.getPassengerCap() //INTEGER
                    + " SET storageSpace = '" + vehicle.getStorageSpace() //CLOB
                    + "' WHERE id = " + vehicle.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
