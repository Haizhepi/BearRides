package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;

import com.google.common.collect.Multimap;
import com.google.common.collect.TreeMultimap;

import database.SQLStatementExecuter;
import object.Trip;
import object.User;
import objectDeleter.TripDeleter;
import objectLoader.TripLoader;
import objectLoader.TripRequirementLoader;
import objectLoader.TripRiderLoader;
import objectSaver.TripSaver;
import objectUpdater.TripUpdater;

public class TripGateway extends Gateway<Trip> {
    private static Map<Long, Trip> trips;

    public TripGateway(Connection con) {
        connection = con;
    }

    @Override
    public Gateway<Trip> save(Object object) {
        
        if(object != null) {
            if(((Trip) object).getPrimaryKey() == null) {
                new TripSaver().execute(connection, object);
            } else {
                new TripUpdater().execute(connection, object);
            }
        }
        
        return this;
    }

    @Override
    public Gateway<Trip> delete(Object object) {
        SQLStatementExecuter executer = new TripDeleter();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    protected Map<Long, Trip> load() {
        Statement statement = new TripLoader().executeQuery(connection, null);
        
        UserGateway userGateway = new UserGateway(connection);
        Map<Long, User> users = userGateway.getLoaded();
        
        trips = new HashMap<Long, Trip>();
        Multimap<Long, String> tripRequirement = TreeMultimap.create();
        Multimap<Long, Long> tripRider = TreeMultimap.create();
        
        //map the requirements
        try {
            Statement trStatement = new TripRequirementLoader().executeQuery(connection, null);
            ResultSet trSet = trStatement.getResultSet();
            
            if (trSet.next() == false) {
            } else {
                do {
                    tripRequirement.put(trSet.getLong("tid"), trSet.getString("req"));
                } while (trSet.next());
            }
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        //map the riders
        try {
            Statement trStatement = new TripRiderLoader().executeQuery(connection, null);
            ResultSet trSet = trStatement.getResultSet();
            
            if (trSet.next() == false) {
            } else {
                do {
                    Long tid = trSet.getLong("tid"), uid = trSet.getLong("uid");
                    
                    tripRider.put(tid, uid);
                } while (trSet.next());
            }
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        //map the trips
        try {
            ResultSet rs = statement.getResultSet();
            
            if (rs.next() == false) {
            } else {
                do {
                    Long key = rs.getLong("id");
                    
                    Trip trip = new Trip(users.get(rs.getLong("driver")), new Date(rs.getLong("originTime")), rs.getInt("passengerCap"));
                    trip.setDestinTime(new Date(rs.getLong("destinTime")));
                    trip.setReturnTime(new Date(rs.getLong("returnTime")));
                    trip.setOriginLoc(rs.getString("originLoc"));
                    trip.setDestinLoc(rs.getString("destinloc"));
                    trip.setReturnLoc(rs.getString("returnLoc"));
                    trip.setPassengerCap(rs.getInt("passengerCap"));
                    trip.setPrimaryKey(key);
                    
                    for(String requirement : tripRequirement.get(key)) {
                        trip.insertRequirement(requirement);
                    }
                    
                    for(Long rider : tripRider.get(key)) {
                        User user = users.get(rider);
                        
                        user.insertTrip(trip);
                        trip.insertRider(user);
                    }
                    
                    trips.put(key, trip);
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
        
        return trips;
    }
    
    @Override
    public Map<Long, Trip> getLoaded() {
        
        if(trips == null) {
            this.load();
        }
        
        return trips;
    }

    @Override
    public Trip find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
