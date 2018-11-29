package objectLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;

public class UserLoader implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.executeQuery("SELECT id, email, passHash, gender, name, contact, age, picture, isDriver, car, rating, ratingCount from UserTable");
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
