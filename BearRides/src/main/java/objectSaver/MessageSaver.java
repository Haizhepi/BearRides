package objectSaver;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Message;

public class MessageSaver extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        Message message = (Message) object;
        
        SQLStatement = "INSERT INTO Message (umid, title, hidden, creator, postTime, body, trip) VALUES "
                + "('" + message.getUMID()
                + "', '" + message.getTitle()
                + "', " + ((message.isHidden() == true) ? 1 : 0)
                + ", " + message.getCreator().getPrimaryKey()
                + ", '" + message.getPostTime()
                + "', '" + message.getBody()
                + "', " + message.getTrip().getPrimaryKey()
                + ");";
        
        return true;
    }
}
