package com.csi3471.app;

import object.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {

    private User user = null;

    @BeforeEach
    void init() {

    }

    @Test
    void testConstructor1() {
        assertThrows(RuntimeException.class, () -> {
            user = new User("Yunzhe_Liu@baylor.edu", null);
        });
    }

    @Test
    void testConstructor2() {
        //assertThrows(RuntimeException.class, () -> {
        //    user = new User(null, "Guess");
        //});
    }
}
