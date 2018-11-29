package objectLoader;

import java.sql.Statement;

import database.SQLStatementExecuter;

public class MessageLoader extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "SELECT id, umid, title, hidden, creator, postTime, body, trip from Message";
        
        return true;
    }
}
