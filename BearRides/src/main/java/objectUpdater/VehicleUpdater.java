package objectUpdater;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Vehicle;

public class VehicleUpdater extends SQLStatementExecuter {

    @Override
    public Boolean beforeHook(Statement statement, Object object) {
        Vehicle vehicle = (Vehicle) object;
        Long key = vehicle.getPrimaryKey();
        

        SQLStatement = "UPDATE Vehicle"
                + " SET model = '" + vehicle.getModel() //VAR CHAR
                + "' SET picture = '" + vehicle.getPicture() //VAR CHAR
                + "' SET passengerCap = " + vehicle.getPassengerCap() //INTEGER
                + " SET storageSpace = '" + vehicle.getStorageSpace() //VAR CHAR
                + "' WHERE id = " + key + ";";

        return true;
    }
}
