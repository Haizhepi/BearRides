package objectSaver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Message;

public class MessageSaver extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        Message message = (Message) object;
        Long key = message.getPrimaryKey();
        
        SQLStatement = "INSERT INTO Message ("
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
                + "', " + message.getTrip().getPrimaryKey()
                + ")";
        
        return true;
    }
    
    @Override
    protected void afterHook(Statement statement, Object object) {
        Message message = (Message) object;
        Long key = message.getPrimaryKey();
        
        if(key == null) {
            try {
                ResultSet rs = statement.getGeneratedKeys();
                
                if(rs.next()) {
                    message.setPrimaryKey(rs.getLong(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
