package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import database.SQLStatementExecuter;
import object.Trip;
import objectDeleter.TripDeleter;
import objectLoader.TripLoader;
import objectLoader.UnlinkedTrip;
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
    public List<Trip> load() {
        SQLStatementExecuter executer = new TripLoader();
        ResultSet rs = executer.executeQuery(connection, null);
        List<Trip> trips = new ArrayList<Trip>();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    UnlinkedTrip trip = new UnlinkedTrip(rs.getLong("creator"), rs.getLong("trip"), Arrays.asList((Long[]) (rs.getArray("requirements")).getArray()));
                    trip.setDestinLoc(rs.getString("destinLoc"));
                    trip.setDestinTime(new Date(rs.getLong("destinTime")));
                    trip.setOriginLoc(rs.getString("originLoc"));
                    trip.setOriginTime(new Date(rs.getLong("originTime")));
                    
                    trips.add(trip);
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
