package objectTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRiderTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE TripRider("
                    + "tid BIGINT NOT NULL,"
                    + "uid BIGINT NOT NULL,"
                    + "PRIMARY KEY (tid, uid))");
            
        } catch (SQLException e) {
            if(!e.toString().contains("already exists in Schema")) {
                e.printStackTrace();
            }
        }
        
        return statement;
    }
}
