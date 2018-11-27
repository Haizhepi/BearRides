package table;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class UserTableCreator extends SQLStatementExecuter {
    
    @Override
    protected Boolean hook(Connection connection, Object object) {
        
        SQLStatement = "CREATE TABLE User("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "email CLOB NOT NULL, "
                + "passHash INTEGER NOT NULL, "
                + "gender BIT NOT NULL, "
                + "name CLOB NOT NULL, "
                + "contact CLOB NOT NULL, "
                + "age INTEGER NOT NULL, "
                + "picture CLOB, "
                + "isDriver BIT NOT NULL, "
                + "car BIGINT, " //foreign key
                + "rating INTEGER NOT NULL, "
                + "ratingCount INTEGER NOT NULL, "
                + "notifications FOREIGN_KEY_SET, " //nested table of BIGINT foreign keys
                + "PRIMARY KEY (id) );";
        
        return true;
    }
}
