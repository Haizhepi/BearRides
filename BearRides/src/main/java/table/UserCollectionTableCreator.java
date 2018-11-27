package table;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class UserCollectionTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        SQLStatement =
                "CREATE TABLE UserCollection("
                + "mailMan BIGINT NOT NULL );"; //foreign key
        
        return true;
    }
}
