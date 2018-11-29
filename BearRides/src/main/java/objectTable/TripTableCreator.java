package objectTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE Trip("
                    + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "driver BIGINT NOT NULL, " //foreign key
                    + "originTime BIGINT, "
                    + "destinTime BIGINT, "
                    + "returnTime BIGINT, "
                    + "originLoc LONG VARCHAR, "
                    + "destinLoc LONG VARCHAR, "
                    + "returnLoc LONG VARCHAR, "
                    + "passengerCap INTEGER, "
                    + "PRIMARY KEY (id), "
                    + "FOREIGN KEY (driver) REFERENCES UserTable(id) )");
            
        } catch (SQLException e) {
            if(!e.toString().contains("already exists in Schema")) {
                e.printStackTrace();
            }
        }
        
        return statement;
    }
}
