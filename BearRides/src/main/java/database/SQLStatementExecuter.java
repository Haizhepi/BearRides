package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLStatementExecuter {
    protected String SQLStatement = null;


    protected abstract Boolean beforeHook(Connection connection, Object object);
    protected void afterHook(Statement statement, Object object) {}
    
    public void execute(Connection connection, Object object) {
        
        if(beforeHook(connection, object)) {
            Statement statement = null;
            
            try {
                statement = connection.createStatement();
                // execute update SQL stetement
                statement.executeUpdate(SQLStatement, Statement.RETURN_GENERATED_KEYS);
                afterHook(statement, object);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    public ResultSet executeQuery(Connection connection, Object object) {
        ResultSet rs = null;
        
        if(beforeHook(connection, object)) {
            Statement statement = null;
            
            try {
                statement = connection.createStatement();
                // execute select SQL stetement
                rs = statement.executeQuery(SQLStatement);
                afterHook(statement, object);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return rs;
    }
}
