package object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void constructor() {
        User user = new User("1", "!");
        Message m = new Message(user);
        assertNotNull(m);
    }

    @Test
    void equals() {
        User u1 = new User("1", "1");
        User u2 = new User("1", "1");
        Message m1 = new Message(u1);
        Message m2 = new Message(u2);
        Message m3 = m2;
        assertNotEquals(m1, m2);
        assertEquals(m2, m3);
        assertNotEquals(m3, m1);
    }

    @Test
    void compareTo() {
        User u1 = new User("1", "1");
        User u2 = new User("1", "1");
        Message m1 = new Message(u1);
        Message m2 = new Message(u2);
        assertTrue(m1.compareTo(m2) < 0);
    }
}