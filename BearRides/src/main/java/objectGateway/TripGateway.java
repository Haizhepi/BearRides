package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;
import objectDeleter.TripDeleter;
import objectLoader.TripLoader;
import objectSaver.TripSaver;

public class TripGateway extends Gateway<Trip> {

    public TripGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<Trip> save(Object object) {
        SQLStatementExecuter executer = new TripSaver();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    public Gateway<Trip> delete(Object object) {
        SQLStatementExecuter executer = new TripDeleter();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    public Map<Long, Trip> load() {
        ResultSet rs = new TripLoader().executeQuery(connection, null);
        Map<Long, Trip> trips = new HashMap<Long, Trip>();
        
        UserGateway userGateway = new UserGateway(connection);
        Map<Long, User> users = userGateway.load();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    Trip trip = new Trip(users.get(rs.getLong("driver")), new Date(rs.getLong("originTime")), rs.getInt("passengerCap"));
                    
                    
                    trips.put(null, null);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return trips;
    }

    @Override
    public Trip find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
