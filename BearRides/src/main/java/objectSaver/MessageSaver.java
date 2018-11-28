package objectSaver;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Message;

public class MessageSaver extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        Message message = (Message) object;
        Long key = message.getPrimaryKey();
        
        SQLStatement = "INSERT INTO Message ("
                + ((key != null) ? "id, " : "")
                + "umid, title, hidden, notification, creator, postTime, body, trip) VALUES "
                + "(" + ((key != null) ? key + ", " : "")
                + "'" + message.getUMID()
                + "', '" + message.getTitle()
                + "', " + ((message.isHidden() == true) ? 1 : 0)
                + ", " + ((message.isNotification() == true) ? 1 : 0)
                + ", " + message.getCreator().getPrimaryKey()
                + ", '" + message.getPostTime()
                + "', '" + message.getBody()
                + "', " + message.getTrip().getPrimaryKey()
                + ");";
        
        return true;
    }
}
