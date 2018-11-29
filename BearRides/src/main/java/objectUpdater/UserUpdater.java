package objectUpdater;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.User;
import object.Vehicle;

public class UserUpdater implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        User user = (User) object;
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            Vehicle vehicle = user.getVehicle();
            
            statement.execute("UPDATE UserTable"
                    + " SET email = '" + user.getEmail() //VAR CHAR
                    + "', passHash = " + user.getPassHash() //INTEGER
                    + ", gender = '" + ((user.getGender() == true) ? 1 : 0) //CHAR
                    + "', name = '" + user.getName() //VAR CHAR
                    + "', contact = '" + user.getContact() //VAR CHAR
                    + "', age = " + user.getAge() //INTEGER
                    + ", picture = '" + user.getPicture() //VAR CHAR
                    + "', isDriver = '" + ((user.isDriver() == true) ? 1 : 0) //CHAR
                    + "', car = " + ((vehicle == null) ? "NULL" : vehicle.getPrimaryKey()) //BIGINT
                    + ", rating = " + user.getRating() //INTEGER
                    + ", ratingCount = " + user.getRatingCount() //INTEGER
                    + " WHERE id = " + user.getPrimaryKey());
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
