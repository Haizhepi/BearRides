package object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = null;

    @BeforeEach
    void init() {
        user = new User("a", "1");
    }

    @Test
    void insertRating() {
        user.setRating(10);
        user.insertRating(5);
        assertEquals(user.getRating(), new Integer(7));
        Message m1 = new Message(user);
        m1.setBody("test");
        user.insertNotification(m1);
    }

    @Test
    void insertNotification() {

        Set<Message> set =  user.getNotifications();
        assertEquals(set.size(), 1);
        Iterator<Message> itr = set.iterator();
        Message m = itr.next();
        assertEquals(m.getBody(), "test");
    }


    @Test
    void removeNotification() {
        Message m = new Message(user);
        m.setBody("test?");
        user.removeNotification(m);
        Set<Message> set =  user.getNotifications();
        assertEquals(set.size(), 1);
        Message m1 = new Message(user);
        m1.setBody("test");
        user.removeNotification(m1);
        set =  user.getNotifications();
        assertEquals(set.size(), 0);

    }



    @Test
    void equals() {
        User u1 = new User("1", "2");
        User u2 = new User("1", "2");
        User u3 = new User("1", "!");
        assertEquals(u1, u2);
        assertNotEquals(u2, u3);
    }

    @Test
    void compareTo() {
        User u1 = new User("1", "2");
        User u2 = new User("2", "2");
        assertTrue(u1.compareTo(u2) > 0);
    }
}