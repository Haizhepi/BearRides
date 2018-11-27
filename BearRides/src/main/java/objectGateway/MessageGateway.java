package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.SQLStatementExecuter;
import object.Message;
import objectDeleter.MessageDeleter;
import objectLoader.MessageLoader;
import objectLoader.UnlinkedMessage;
import objectSaver.MessageSaver;

public class MessageGateway extends Gateway<Message> {

    public MessageGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<Message> save(Object object) {
        SQLStatementExecuter executer = new MessageSaver();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    public Gateway<Message> delete(Object object) {
        SQLStatementExecuter executer = new MessageDeleter();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    public List<Message> load() {
        SQLStatementExecuter executer = new MessageLoader();
        ResultSet rs = executer.executeQuery(connection, null);
        List<Message> messages = new ArrayList<Message>();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    UnlinkedMessage message = new UnlinkedMessage(rs.getLong("creator"), rs.getLong("trip"));
                    message.setBody(rs.getString("body"));
                    message.setHidden(rs.getBoolean("hidden"));
                    message.setPostTime(rs.getString("postTime"));
                    message.setPrimaryKey(rs.getLong("id"));
                    message.setTitle(rs.getString("title"));
                    message.setUmid(rs.getString("umid"));
                    
                    messages.add(message);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return messages;
    }

    @Override
    public Message find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}