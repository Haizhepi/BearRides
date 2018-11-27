package table;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class TableCreator {
    protected String createTableSQL = null;
    
    protected abstract void hook(Connection connection);
    
    public void createTable(Connection connection) {
        hook(connection);
        
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            System.out.println(createTableSQL);
            // execute the SQL stetements
            statement.execute(createTableSQL);
            
            System.out.println("Table is created!");
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