package objectGateway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import object.User;
import object.Vehicle;
import objectDeleter.UserDeleter;
import objectLoader.ClobStringConversion;
import objectLoader.UserLoader;
import objectSaver.UserSaver;

public class UserGateway extends Gateway<User> {

    public UserGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<User> save(Object object) {
        new UserSaver().execute(connection, object);
        return this;
    }

    @Override
    public Gateway<User> delete(Object object) {
        new UserDeleter().execute(connection, object);
        return this;
    }

    @Override
    public Map<Long, User> load() {
        ResultSet rs = new UserLoader().executeQuery(connection, null);
        Map<Long, User> users = new HashMap<Long, User>();
        
        VehicleGateway vehicleGateway = new VehicleGateway(connection);
        Map<Long, Vehicle> vehicles = vehicleGateway.load();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    User user = new User(ClobStringConversion.convert(rs.getClob("email")), rs.getInt("passHash"));
                    user.setAge(rs.getInt("age"));
                    user.setContact(ClobStringConversion.convert(rs.getClob("contact")));
                    user.setGender(rs.getString("gender") == "1");
                    user.setName(ClobStringConversion.convert(rs.getClob("name")));
                    user.setPicture(ClobStringConversion.convert(rs.getClob("picture")));
                    user.setPrimaryKey(rs.getLong("id"));
                    user.setVehicle(vehicles.getOrDefault(rs.getLong("car"), null));
                    user.setRating(rs.getInt("rating"));
                    user.setRatingCount(rs.getInt("ratingCount"));
                    
                    users.put(user.getPrimaryKey(), user);
                } while (rs.next());
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        
        return users;
    }

    @Override
    public User find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
