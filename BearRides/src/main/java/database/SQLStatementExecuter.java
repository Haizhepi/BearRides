package database;

import java.sql.Connection;
import java.sql.Statement;

public interface SQLStatementExecuter {
    
    public abstract void execute(Connection connection, Object object);
    
    public abstract Statement executeQuery(Connection connection, Object object);
}
