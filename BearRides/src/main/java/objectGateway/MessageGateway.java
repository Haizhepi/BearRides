package objectGateway;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import database.SQLStatementExecuter;
import object.Message;
import object.Trip;
import object.User;
import objectDeleter.MessageDeleter;
import objectLoader.MessageLoader;
import objectSaver.MessageSaver;
import objectUpdater.MessageUpdater;

public class MessageGateway extends Gateway<Message> {
    private static Map<Long, Message> messages;

    public MessageGateway(Connection con) {
        connection = con;
    }

    @Override
    public Gateway<Message> save(Object object) {
        
        if(((Message) object).getPrimaryKey() == null) {
            new MessageSaver().execute(connection, object);
        } else {
            new MessageUpdater().execute(connection, object);
        }
        
        return this;
    }

    @Override
    public Gateway<Message> delete(Object object) {
        SQLStatementExecuter executer = new MessageDeleter();
        executer.execute(connection, object);
        
        return this;
    }

    @Override
    protected Map<Long, Message> load() {
        ResultSet rs = new MessageLoader().executeQuery(connection, null);
        Map<Long, Message> messages = new HashMap<Long, Message>();
        
        TripGateway tripGateway = new TripGateway(connection);
        Map<Long, Trip> trips = tripGateway.getLoaded();
        
        UserGateway userGateway = new UserGateway(connection);
        Map<Long, User> users = userGateway.getLoaded();
        
        try {
            if (rs.next() == false) {
                System.out.println("ResultSet is empty in Java");
            } else {
                do {
                    Message message = new Message(users.get(rs.getLong("creator")));
                    message.setUmid(rs.getString("umid"));
                    message.setTitle(rs.getString("title"));
                    message.setHidden(rs.getString("hidden") == "1");
                    message.setPostTime(rs.getString("postTime"));
                    message.setBody(rs.getString("body"));
                    message.setTrip(trips.getOrDefault(rs.getLong("trip"), null));
                    message.setNotification(rs.getString("notification") == "1");
                    message.setPrimaryKey(rs.getLong("id"));
                    
                    if(message.isNotification()) {
                        users.get(message.getCreator().getPrimaryKey()).insertNotification(message);
                    }
                    
                    Trip trip = message.getTrip();
                    if(trip != null) {
                        trip.setMessage(message);
                    }
                    
                    messages.put(message.getPrimaryKey(), message);
                } while (rs.next());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return messages;
    }
    
    @Override
    public Map<Long, Message> getLoaded() {

        if(messages == null) {
            this.load();
        }
        
        return messages;
    }

    @Override
    public Message find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}