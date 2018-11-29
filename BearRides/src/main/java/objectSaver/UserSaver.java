package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;

public class UserSaver extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        
        SQLStatement = "INSERT INTO UserTable ("
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
                + "', " + user.getVehicle().getPrimaryKey()
                + ", " + user.getRating()
                + ", " + user.getRatingCount()
                + ")";
        
        return true;
    }
    
    @Override
    protected void afterHook(Statement statement, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        
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
    }
}
