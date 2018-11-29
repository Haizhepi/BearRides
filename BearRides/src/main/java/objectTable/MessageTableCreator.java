package objectTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;

public class MessageTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE Message("
                    + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "umid LONG VARCHAR NOT NULL, "
                    + "title LONG VARCHAR NOT NULL, "
                    + "hidden CHAR NOT NULL, "
                    + "notification CHAR NOT NULL, "
                    + "creator BIGINT NOT NULL, " //foreign key
                    + "postTime LONG VARCHAR NOT NULL, "
                    + "body LONG VARCHAR NOT NULL, "
                    + "trip BIGINT NOT NULL, " //foreign key
                    + "PRIMARY KEY (id), "
                    + "FOREIGN KEY(creator) REFERENCES UserTable(id), "
                    + "FOREIGN KEY(trip) REFERENCES Trip(id) )");
            
        } catch (SQLException e) {
            if(!e.toString().contains("already exists in Schema")) {
                LogManager.getLogger().error(e.getMessage(), e);
            }
        }
        
        return statement;
    }
}
