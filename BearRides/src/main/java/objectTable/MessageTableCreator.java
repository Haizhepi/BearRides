package objectTable;

import java.sql.Connection;

import database.SQLStatementExecuter;

public class MessageTableCreator extends SQLStatementExecuter {

    @Override
    protected Boolean beforeHook(Connection connection, Object object) {
        
        SQLStatement = "CREATE TABLE Message("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "umid CLOB NOT NULL, "
                + "title CLOB NOT NULL, "
                + "hidden CHAR NOT NULL, "
                + "notification CHAR NOT NULL, "
                + "creator BIGINT NOT NULL, " //foreign key
                + "postTime CLOB NOT NULL, "
                + "body CLOB NOT NULL, "
                + "PRIMARY KEY (id), "
                + "FOREIGN KEY(creator) REFERENCES UserTable(id)) ";
                //+ "FOREIGN KEY(trip) REFERENCES Trip(id) )";
        
        return true;
    }
}
