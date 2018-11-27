package objectGateway;

import java.sql.Connection;
import java.util.List;

import object.Vehicle;

public class VehicleGateway extends Gateway<Vehicle> {

    public VehicleGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<Vehicle> save(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Gateway<Vehicle> delete(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Vehicle> load() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Vehicle find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
