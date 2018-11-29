package database;

import java.sql.Connection;
import java.sql.ResultSet;

public interface SQLStatementExecuter {
    
    public abstract void execute(Connection connection, Object object);
    
    public abstract ResultSet executeQuery(Connection connection, Object object);
}
