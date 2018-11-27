package table;

import java.sql.Connection;

public class MessageTableCreator extends TableCreator {

    @Override
    protected void hook(Connection connection) {
        createTableSQL =
                "CREATE TABLE Message("
                + "id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
                + "umid CLOB NOT NULL, "
                + "title CLOB NOT NULL, "
                + "hidden BIT NOT NULL, "
                + "creator BIGINT NOT NULL, " //foreign key
                + "postTime CLOB NOT NULL, "
                + "body CLOB NOT NULL, "
                + "trip BIGINT, " //foreign key
                + "PRIMARY KEY (id) );";
    }
}
