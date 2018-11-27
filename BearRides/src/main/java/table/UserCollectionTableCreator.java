package table;

import java.sql.Connection;

public class UserCollectionTableCreator extends TableCreator {

    @Override
    protected void hook(Connection connection) {
        createTableSQL =
                "CREATE TABLE UserCollection("
                + "mailMan BIGINT NOT NULL );"; //foreign key
    }
}
