package objectLoader;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class VehicleLoader implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.executeQuery("SELECT id, model, picture, passengerCap, storageSpace from Vehicle");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return statement;
    }
}
