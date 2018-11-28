package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
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
    
    @Override
    protected void afterHook(Statement statement, Object object) {
        Vehicle vehicle = (Vehicle) object;
        ResultSet rs = null;
        try {
            rs = statement.getGeneratedKeys();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        try {
            if(rs.next()) {
                try {
                    vehicle.setPrimaryKey(rs.getLong(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
