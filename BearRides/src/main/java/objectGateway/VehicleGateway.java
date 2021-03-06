package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import object.Vehicle;
import objectDeleter.VehicleDeleter;
import objectLoader.VehicleLoader;
import objectSaver.VehicleSaver;
import objectUpdater.VehicleUpdater;

public class VehicleGateway extends Gateway<Vehicle> {
    private static Map<Long, Vehicle> vehicles;

    public VehicleGateway(Connection con) {
        connection = con;
    }

    @Override
    public Gateway<Vehicle> save(Object object) {
        
        if(object != null) {
            if(((Vehicle) object).getPrimaryKey() == null) {
                new VehicleSaver().execute(connection, object);
            } else {
                new VehicleUpdater().execute(connection, object);
            }
        }
        
        return this;
    }

    @Override
    public Gateway<Vehicle> delete(Object object) {
        new VehicleDeleter().execute(connection, object);
        return this;
    }

    @Override
    protected Map<Long, Vehicle> load() {
        Statement statement = new VehicleLoader().executeQuery(connection, null);
        vehicles = new HashMap<Long, Vehicle>();
        
        try {
            ResultSet rs = statement.getResultSet();
            
            if (rs.next() == false) {
            } else {
                do {
                    Vehicle vehicle = new Vehicle(rs.getString("model"), rs.getInt("passengerCap"));
                    vehicle.setPrimaryKey(rs.getLong("id"));
                    vehicle.setPicture(rs.getString("picture"));
                    vehicle.setStorageSpace(rs.getString("storageSpace"));
                    
                    vehicles.put(vehicle.getPrimaryKey(), vehicle);
                } while (rs.next());
            }
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    LogManager.getLogger().error(e.getMessage(), e);
                }
            }
        }
        
        return vehicles;
    }
    
    @Override
    public Map<Long, Vehicle> getLoaded() {
        
        if(vehicles == null) {
            this.load();
        }
        
        return vehicles;
    }

    @Override
    public Vehicle find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
