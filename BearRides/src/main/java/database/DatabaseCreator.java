package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {
    private static DatabaseCreator singleton = null;
    private Connection connection = null;
    
    private DatabaseCreator() {
        System.out.println("-------- Derby JDBC Connection Testing ------------");
        try {
            Class.forName(DatabaseProtocol.getDbDriver());
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Derby JDBC Driver?");
            e.printStackTrace();
            return;
        }
        System.out.println("Derby JDBC Driver Registered!");
        try {
            connection = DriverManager.getConnection(DatabaseProtocol.getDbConnection(), DatabaseProtocol.getDbUser(),
                    DatabaseProtocol.getDbPassword());
            if (connection != null) {
                System.out.println("You made it, take control your database now!");
                
                String InitializeDatabaseSQL =
                        "CREATE TYPE FOREIGN_KEY_SET AS TABLE OF BIGINT;"
                        + "CREATE TYPE STRING_SET AS TABLE OF CLOB;";
                Statement statement = connection.createStatement();
                
                try {
                    statement.execute(InitializeDatabaseSQL);
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
            } else {
                System.out.println("Failed to make connection!");
            }
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return;
        }
    }
    
    public static DatabaseCreator getInstance() {
        if(singleton == null) {
            singleton = new DatabaseCreator();
        }
        
        return singleton;
    }
    
    public void freeInstance() {
        singleton = null;
        
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            connection = null;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
