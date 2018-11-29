package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;

public class DatabaseCreator {
    private static DatabaseCreator singleton = null;
    private Connection connection = null;
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
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
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: the singleton instance of this
     * precondition: void
     * postcondition: this is initialized if it wasnt
     */
    public static DatabaseCreator getInstance() {
        if(singleton == null) {
            singleton = new DatabaseCreator();
        }
        
        return singleton;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: frees the connection of this instance and the singleton
     * return: void
     * precondition: void
     * postcondition: connection and this are freed
     */
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
}
