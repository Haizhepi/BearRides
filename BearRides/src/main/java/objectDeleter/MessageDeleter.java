package objectDeleter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Message;

public class MessageDeleter implements SQLStatementExecuter {
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: executes without return
     * return: void
     * precondition: void
     * postcondition: message object is deleted
     */
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }
    
    /*
     * description: executes with return
     * return: void
     * precondition: void
     * postcondition: message object is deleted
     */
    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Message message = (Message) object;
        Long key = message.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("DELETE FROM Message WHERE id = " + key);
            statement.execute("DELETE FROM Trip WHERE message = " + key);
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
