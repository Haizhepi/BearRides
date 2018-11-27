package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Message;

public class MessageUpdater extends SQLStatementExecuter {

    @Override
    public Boolean hook(Connection connection, Object object) {
        Message message = (Message) object;
        
        if(message.getPrimaryKey() != null) {
            SQLStatement = "UPDATE Message"
                    + " SET umid = '" + message.getUMID() //CLOB
                    + "' SET title = '" + message.getTitle() //CLOB
                    + "' SET hidden = " + ((message.isHidden() == true) ? 1 : 0) //BIT
                    + " SET creator = " + message.getCreator().getPrimaryKey() //BIGINT foreign key
                    + " SET postTime = '" + message.getPostTime() //CLOB
                    + "' SET body = '" + message.getBody() //CLOB
                    + "' SET trip = " + message.getTrip().getPrimaryKey() //BIGINT foreign key
                    + " WHERE id = " + message.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
