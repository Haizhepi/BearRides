package objectDeleter;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.Message;

public class MessageDeleter extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        Message message = (Message) object;
        
        SQLStatement = "DELETE FROM Message WHERE id = " + message.getPrimaryKey() + ";"
                + "DELETE FROM Trip WHERE message = " + message.getPrimaryKey() + ";"
                + "DELETE FROM User WHERE BIGINT(" + message.getPrimaryKey() + ") MEMBER OF notifications;"; //need to test!
        
        return true;
    }
}
