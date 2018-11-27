package database;

public class DatabaseProtocol {
    private static final String DB_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String DB_CONNECTION = "jdbc:derby:ex1connect;create=true";
    private static final String DB_USER = "imY&Y@";
    private static final String DB_PASSWORD = "EW2hKr!j@^Rr";
    
    public static enum dataTypes{
        foreignKeySet("FOREIGN_KEY_SET"), stringSet("STRING_SET");
        
        private dataTypes(String sql) {
            this.sql = sql;
        }
        
        @Override
        public String toString() {
            return sql;
        }
        
        private String sql;
    }
    
    public static String getDbDriver() {
        return DB_DRIVER;
    }
    public static String getDbConnection() {
        return DB_CONNECTION;
    }
    public static String getDbUser() {
        return DB_USER;
    }
    public static String getDbPassword() {
        return DB_PASSWORD;
    }
}
