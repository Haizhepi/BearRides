package objectLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;

public class TripLoader implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.executeQuery("SELECT id, driver, originTime, destinTime, returnTime, originLoc, destinLoc, returnLoc, passengerCap from Trip");
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
