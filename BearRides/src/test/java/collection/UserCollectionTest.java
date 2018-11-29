package collection;

import object.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserCollectionTest {

    UserCollection userCollection = null;
    User user = null;

    @BeforeEach
    void init() {
        userCollection = new UserCollection();
        user = new User("1", "1");
    }

    @Test
    void insert() {
        assertTrue(userCollection.insert(user));
    }

    @Test
    void remove() {
        userCollection.insert(user);
        userCollection.remove(user);
        assertTrue(userCollection.getAll().size() == 0);
    }

    @Test
    void getAll() {
        User u2 = new User("2", "@");
        userCollection.insert(user);
        userCollection.insert(u2);
        assertTrue(userCollection.getAll().size() == 2);
    }

    @Test
    void checkFor() {
        userCollection.insert(user);
        assertTrue(userCollection.checkFor(user.getEmail()));
    }

    @Test
    void login() {
        userCollection.insert(user);
        assertTrue(userCollection.login("1", "1").equals(user));
    }

    @Test
    void authenticate() {
        userCollection.insert(user);
        //assertTrue(userCollection.);
    }

    @Test
    void logout() {
    }
}