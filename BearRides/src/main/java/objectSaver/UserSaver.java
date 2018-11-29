package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserSaver implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            Vehicle vehicle = user.getVehicle();
            
            statement.executeUpdate("INSERT INTO UserTable ("
                    + ((key != null) ? "id, " : "")
                    + "email, passHash, gender, name, contact, age, picture, isDriver, car, rating, ratingCount) VALUES "
                    + "(" + ((key != null) ? key + ", " : "")
                    + "'" + user.getEmail()
                    + "', " + user.getPassHash()
                    + ", '" + ((user.getGender() == true) ? 1 : 0)
                    + "', '" + user.getName()
                    + "', '" + user.getContact()
                    + "', " + user.getAge()
                    + ", '" + user.getPicture()
                    + "', '" + ((user.isDriver() == true) ? 1 : 0)
                    + "', " + ((vehicle == null) ? "NULL" : vehicle.getPrimaryKey())
                    + ", " + user.getRating()
                    + ", " + user.getRatingCount()
                    + ")", Statement.RETURN_GENERATED_KEYS);
            
            if(key == null) {
                try {
                    ResultSet rs = statement.getGeneratedKeys();
                    
                    if(rs.next()) {
                        user.setPrimaryKey(rs.getLong(1));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return statement;
    }
}
