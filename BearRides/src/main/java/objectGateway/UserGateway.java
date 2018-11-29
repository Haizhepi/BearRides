package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import object.User;
import object.Vehicle;
import objectDeleter.UserDeleter;
import objectLoader.UserLoader;
import objectSaver.UserSaver;
import objectUpdater.UserUpdater;

public class UserGateway extends Gateway<User> {
    private static Map<Long, User> users;

    public UserGateway(Connection con) {
        connection = con;
    }

    @Override
    public Gateway<User> save(Object object) {
        if(((User) object).getPrimaryKey() == null) {
            new UserSaver().execute(connection, object);
        } else {
            new UserUpdater().execute(connection, object);
        }
        
        return this;
    }

    @Override
    public Gateway<User> delete(Object object) {
        new UserDeleter().execute(connection, object);
        return this;
    }

    @Override
    protected Map<Long, User> load() {
        Statement statement = new UserLoader().executeQuery(connection, null);
        users = new HashMap<Long, User>();
        
        VehicleGateway vehicleGateway = new VehicleGateway(connection);
        Map<Long, Vehicle> vehicles = vehicleGateway.getLoaded();
        
        try {
            ResultSet rs = statement.getResultSet();
            
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    User user = new User(rs.getString("email"), rs.getInt("passHash"));
                    user.setAge(rs.getInt("age"));
                    user.setContact(rs.getString("contact"));
                    user.setGender(rs.getString("gender") == "1");
                    user.setName(rs.getString("name"));
                    user.setPicture(rs.getString("picture"));
                    user.setPrimaryKey(rs.getLong("id"));
                    user.setVehicle(vehicles.getOrDefault(rs.getLong("car"), null));
                    user.setRating(rs.getInt("rating"));
                    user.setRatingCount(rs.getInt("ratingCount"));
                    
                    users.put(user.getPrimaryKey(), user);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return users;
    }
    
    @Override
    public Map<Long, User> getLoaded() {
        
        if(users == null) {
            this.load();
        }
        
        return users;
    }

    @Override
    public User find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
