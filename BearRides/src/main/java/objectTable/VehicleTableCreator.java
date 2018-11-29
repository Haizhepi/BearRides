package objectTable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class VehicleTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public ResultSet executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE Vehicle("
                    + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "model LONG VARCHAR NOT NULL, "
                    + "picture LONG VARCHAR, "
                    + "passengerCap INTEGER NOT NULL, "
                    + "storageSpace LONG VARCHAR, "
                    + "PRIMARY KEY (id) )");
            
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
