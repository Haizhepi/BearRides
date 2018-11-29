package objectUpdater;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Message;

public class MessageUpdater implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Message message = (Message) object;
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("UPDATE Message"
                    + " SET umid = '" + message.getUMID() //LONG VARCHAR
                    + "', title = '" + message.getTitle() //LONG VARCHAR
                    + "', hidden = '" + ((message.isHidden() == true) ? 1 : 0) //CHAR
                    + "', notification = '" + ((message.isNotification() == true) ? 1 : 0) //CHAR
                    + "', creator = " + message.getCreator().getPrimaryKey() //BIGINT foreign key
                    + ", postTime = '" + message.getPostTime() //LONG VARCHAR
                    + "', body = '" + message.getBody() //LONG VARCHAR
                    + "', trip = " + message.getTrip().getPrimaryKey() //BIGINT foreign key
                    + " WHERE id = " + message.getPrimaryKey());
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return statement;
    }
}
