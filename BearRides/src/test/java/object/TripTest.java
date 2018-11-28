package object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TripTest {
    Trip trip = null;

    @BeforeEach
    void init() {
        trip = new Trip(new User("1", "1"), new Date(10000), 1);
    }

    @Test
    void removeRider() {
        User u1 = new User("1", "1");
        User u2 = new User("2", "2");
        assertFalse(trip.removeRider(u1));
        assertTrue(trip.removeRider(u2));
    }

    @Test
    void removeRequirement() {
        String req1 = "test1";
        String req2 = "test2";
        trip.insertRequirement(req1);
        assertFalse(trip.removeRequirement(req2));
        assertTrue(trip.removeRequirement(req1));
    }

    @Test
    void equals() {
        Trip trip2 = new Trip(new User("1", "1"), new Date(10000), 1);
        assertEquals(trip, trip2);
    }

    @Test
    void compareTo() {
        Trip trip2 = new Trip(new User("1", "1"), new Date(20000), 1);
        assertTrue(trip.compareTo(trip2) > 0);
    }
}