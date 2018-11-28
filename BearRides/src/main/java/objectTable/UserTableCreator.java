package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class UserTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "CREATE TABLE UserTable("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "email CLOB NOT NULL, "
                + "passHash INTEGER NOT NULL, "
                + "gender CHAR NOT NULL, "
                + "name CLOB NOT NULL, "
                + "contact CLOB NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "picture CLOB, "
                + "isDriver CHAR NOT NULL, "
                + "car BIGINT, " //foreign key
                + "rating INTEGER NOT NULL, "
                + "ratingCount INTEGER NOT NULL, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY (car) REFERENCES Vehicle(id) )";
        
        return true;
    }
}
