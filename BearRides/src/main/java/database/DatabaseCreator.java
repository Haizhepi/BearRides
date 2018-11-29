package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DatabaseCreator {
    private static DatabaseCreator singleton = null;
    private Connection connection = null;
    
    private DatabaseCreator() {
        try {
            Class.forName(DatabaseProtocol.getDbDriver());
        } catch (ClassNotFoundException e) {
            LogManager.getLogger().error("Where is your Derby JDBC Driver?", e);
            return;
        }
        try {
            connection = DriverManager.getConnection(DatabaseProtocol.getDbConnection(), DatabaseProtocol.getDbUser(),
                    DatabaseProtocol.getDbPassword());
        } catch (SQLException e) {
            LogManager.getLogger().error("Connection Failed! Check output console", e);
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
                LogManager.getLogger().error(e.getMessage(), e);
            }
            
            connection = null;
        }
    }
    
    public Connection getConnection() {
        return connection;
    }
}
