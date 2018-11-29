package objectUpdater;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;

public class UserUpdater implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public ResultSet executeQuery(Connection connection, Object object) {
        User user = (User) object;
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("UPDATE UserTable"
                    + " SET email = '" + user.getEmail() //VAR CHAR
                    + "' SET passHash = " + user.getPassHash() //INTEGER
                    + " SET gender = '" + ((user.getGender() == true) ? 1 : 0) //CHAR
                    + "' SET name = '" + user.getName() //VAR CHAR
                    + "' SET contact = '" + user.getContact() //VAR CHAR
                    + "' SET age = " + user.getAge() //INTEGER
                    + " SET picture = '" + user.getPicture() //VAR CHAR
                    + "' SET isDriver = '" + ((user.isDriver() == true) ? 1 : 0) //CHAR
                    + "' SET car = " + user.getVehicle().getPrimaryKey() //BIGINT
                    + " SET rating = " + user.getRating() //INTEGER
                    + " SET ratingCount = " + user.getRatingCount() //INTEGER
                    + " WHERE id = " + user.getPrimaryKey());
            
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
        
        return null;
    }
}
