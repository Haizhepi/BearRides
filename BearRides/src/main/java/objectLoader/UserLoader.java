package objectLoader;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class UserLoader extends SQLStatementExecuter {
    
    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "SELECT id, email, passHash, gender, name, contact, age, picture, isDriver, car, rating, ratingCount from UserTable";
        
        return true;
    }
}
