package objectDeleter;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.Message;

public class MessageDeleter extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        Message message = (Message) object;
        
        SQLStatement = "DELETE FROM Message WHERE id = " + message.getPrimaryKey() + ";"
                + "DELETE FROM Trip WHERE message = " + message.getPrimaryKey() + ";";
        
        return true;
    }
}
