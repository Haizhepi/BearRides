package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLStatementExecuter {
    protected String SQLStatement = null;
    
    protected abstract Boolean hook(Connection connection, Object object);
        
    public void execute(Connection connection, Object object) {
        
        if(hook(connection, object)) {
            Statement statement = null;
            
            try {
                statement = connection.createStatement();
                // execute update SQL stetement
                statement.execute(SQLStatement);
                System.out.println("Record is updated to DBUSER table!");
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
        
        if(hook(connection, object)) {
            Statement statement = null;
            
            try {
                statement = connection.createStatement();
                // execute select SQL stetement
                rs = statement.executeQuery(SQLStatement);
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
