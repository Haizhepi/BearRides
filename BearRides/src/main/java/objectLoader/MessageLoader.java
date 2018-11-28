package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class MessageLoader extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT id, umid, title, hidden, creator, postTime, body, trip from Message";
        
        return true;
    }
}
