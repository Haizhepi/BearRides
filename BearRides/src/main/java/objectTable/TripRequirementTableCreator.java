package objectTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class TripRequirementTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE TripRequirement("
                    + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "tid BIGINT NOT NULL,"
                    + "req LONG VARCHAR NOT NULL,"
                    + "PRIMARY KEY (id))");
            
        } catch (SQLException e) {
            if(!e.toString().contains("already exists in Schema")) {
                e.printStackTrace();
            }
        }
        
        return statement;
    }
}
