package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Message;

public class MessageUpdater extends SQLStatementExecuter {

    @Override
    public Boolean beforeHook(Connection connection, Object object) {
        Message message = (Message) object;
        
        if(message.getPrimaryKey() != null) {
            SQLStatement = "UPDATE Message"
                    + " SET umid = '" + message.getUMID() //LONG VARCHAR
                    + "' SET title = '" + message.getTitle() //LONG VARCHAR
                    + "' SET hidden = '" + ((message.isHidden() == true) ? 1 : 0) //CHAR
                    + "' SET notification = '" + ((message.isNotification() == true) ? 1 : 0) //CHAR
                    + "' SET creator = " + message.getCreator().getPrimaryKey() //BIGINT foreign key
                    + " SET postTime = '" + message.getPostTime() //LONG VARCHAR
                    + "' SET body = '" + message.getBody() //LONG VARCHAR
                    + "' SET trip = " + message.getTrip().getPrimaryKey() //BIGINT foreign key
                    + " WHERE id = " + message.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
