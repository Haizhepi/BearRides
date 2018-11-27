package objectUpdater;

import java.sql.Connection;

import object.Vehicle;

public class VehicleUpdater extends Updater {

    @Override
    public Boolean hook(Connection connection, Object object) {
        Vehicle vehicle = (Vehicle) object;
        
        if(vehicle.getPrimaryKey() != null) {
            UpdateSQL = "UPDATE Vehicle"
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
