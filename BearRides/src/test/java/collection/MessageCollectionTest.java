package collection;

import object.Message;
import object.Trip;
import object.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MessageCollectionTest {
    MessageCollection messageCollection = null;
    Message m = null;
    User user = null;

    @BeforeEach
    void init() {
        messageCollection = new MessageCollection();
        user = new User("1", "1");
        m = new Message(user);
        m.setBody("test");
    }

    @Test
    void insert() {
        assertTrue(messageCollection.insert(m));
    }

    @Test
    void removeAll() {
        User user2 = new User("2", "2");
        Message m2 = new Message(user2);
        m2.setBody("test2");
        messageCollection.insert(m);
        messageCollection.insert(m2);
        messageCollection.removeAll(user);
        assertTrue(messageCollection.getMessages().size() == 1);
    }

    @Test
    void remove() {
        messageCollection.insert(m);
        messageCollection.remove(m);
        assertTrue(messageCollection.getMessages().size() == 0);
    }


    @Test
    void checkFor() {
        User u2 = new User("2", "2");
        Message m2 = new Message(u2);
        m2.setBody("test2??");
        messageCollection.insert(m);
        assertTrue(messageCollection.checkFor(m));
    }

    @Test
    void fromUser() {
        User u2 = new User("2", "2");
        assertTrue(messageCollection.fromUser(u2).size() == 0);
    }

    @Test
    void pushReminders() {
        m.setTrip(new Trip(user, new Date(1000), 1));
        messageCollection.insert(m);
        messageCollection.pushReminders(new Date(1000));
        Iterator<Message> itr = user.getNotifications().iterator();
        Message me = itr.next();
        assertTrue(me.isNotification());
    }
}