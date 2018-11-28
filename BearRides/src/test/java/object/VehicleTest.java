package object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void equals() {
        Vehicle v1 = new Vehicle("1", 1);
        Vehicle v2 = new Vehicle("1", 1);
        Vehicle v3 = new Vehicle("1", 0);
        assertEquals(v1, v2);
        assertNotEquals(v2, v3);
    }
}