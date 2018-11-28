package objectGateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import object.Vehicle;
import objectDeleter.VehicleDeleter;
import objectLoader.ClobStringConversion;
import objectLoader.VehicleLoader;
import objectSaver.VehicleSaver;

public class VehicleGateway extends Gateway<Vehicle> {

    public VehicleGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<Vehicle> save(Object object) {
        new VehicleSaver().execute(connection, object);
        return this;
    }

    @Override
    public Gateway<Vehicle> delete(Object object) {
        new VehicleDeleter().execute(connection, object);
        return this;
    }

    @Override
    public Map<Long, Vehicle> load() {
        ResultSet rs = new VehicleLoader().executeQuery(connection, null);
        Map<Long, Vehicle> vehicles = new HashMap<Long, Vehicle>();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    Vehicle vehicle = new Vehicle(ClobStringConversion.convert(rs.getClob("model")), rs.getInt("passengerCap"));
                    vehicle.setPrimaryKey(rs.getLong("id"));
                    vehicle.setPicture(ClobStringConversion.convert(rs.getClob("picture")));
                    vehicle.setStorageSpace(ClobStringConversion.convert(rs.getClob("storageSpace")));
                    
                    vehicles.put(vehicle.getPrimaryKey(), vehicle);
                } while (rs.next());
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        return vehicles;
    }

    @Override
    public Vehicle find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
