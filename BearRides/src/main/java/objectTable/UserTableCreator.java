package objectTable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class UserTableCreator implements SQLStatementExecuter {
    
    @Override
    public void execute(Connection connection, Object object) {
        executeQuery(connection, object);
    }

    @Override
    public Statement executeQuery(Connection connection, Object object) {
        Statement statement = null;
        
        try {
            statement = connection.createStatement();
            
            statement.execute("CREATE TABLE UserTable("
                    + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                    + "email LONG VARCHAR NOT NULL, "
                    + "passHash INTEGER NOT NULL, "
                    + "gender CHAR NOT NULL, "
                    + "name LONG VARCHAR NOT NULL, "
                    + "contact LONG VARCHAR NOT NULL, "
                    + "age INTEGER NOT NULL, "
                    + "picture LONG VARCHAR, "
                    + "isDriver CHAR NOT NULL, "
                    + "car BIGINT, " //foreign key
                    + "rating INTEGER NOT NULL, "
                    + "ratingCount INTEGER NOT NULL, "
                    + "PRIMARY KEY (id), "
                    + "FOREIGN KEY (car) REFERENCES Vehicle(id) )");
            
        } catch (SQLException e) {
            if(!e.toString().contains("already exists in Schema")) {
                e.printStackTrace();
            }
        }
        
        return statement;
    }
}
