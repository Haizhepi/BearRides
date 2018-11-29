package objectTable;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;

public class MessageTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Statement statement, Object object) {
        
        SQLStatement = "CREATE TABLE Message("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "umid LONG VARCHAR NOT NULL, "
                + "title LONG VARCHAR NOT NULL, "
                + "hidden CHAR NOT NULL, "
                + "notification CHAR NOT NULL, "
                + "creator BIGINT NOT NULL, " //foreign key
                + "postTime LONG VARCHAR NOT NULL, "
                + "body LONG VARCHAR NOT NULL, "
                + "trip BIGINT NOT NULL, " //foreign key
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY(creator) REFERENCES UserTable(id), "
                + "FOREIGN KEY(trip) REFERENCES Trip(id) )";
        
        return true;
    }
}
