package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;

import database.SQLStatementExecuter;
import object.Message;
import object.Trip;

public class MessageSaver implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Message message = (Message) object;
        Long key = message.getPrimaryKey();
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            Trip trip = message.getTrip();
            
            statement.executeUpdate("INSERT INTO Message ("
                    + ((key != null) ? "id, " : "")
                    + "umid, title, hidden, notification, creator, postTime, body, trip) VALUES "
                    + "(" + ((key != null) ? key + ", " : "")
                    + "'" + message.getUMID()
                    + "', '" + message.getTitle()
                    + "', '" + ((message.isHidden() == true) ? 1 : 0)
                    + "', '" + ((message.isNotification() == true) ? 1 : 0)
                    + "', " + message.getCreator().getPrimaryKey()
                    + ", '" + message.getPostTime()
                    + "', '" + message.getBody()
                    + "', " + ((trip == null) ? "NULL" : trip.getPrimaryKey())
                    + ")", Statement.RETURN_GENERATED_KEYS);
            
            if(key == null) {
                try {
                    ResultSet rs = statement.getGeneratedKeys();
                    
                    if(rs.next()) {
                        message.setPrimaryKey(rs.getLong(1));
                    }
                } catch (SQLException e) {
                    LogManager.getLogger().error(e.getMessage(), e);
                }
            }
            
        } catch (SQLException e) {
            LogManager.getLogger().error(e.getMessage(), e);
        }
        
        return statement;
    }
}
