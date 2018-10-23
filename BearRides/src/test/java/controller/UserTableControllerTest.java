package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class UserTableControllerTest {
    UserTableController userTableController = null;
    @BeforeEach
    void init() {
        userTableController = new UserTableController(new File("File"));
    }

    @Test
    void testConstructor() {
        UserTableController userTableController1 = new UserTableController(null);
    }

    @Test
    void testConstructor0() {
         UserTableController userTableController1 = new UserTableController(new File("Invalid"));
    }

    @Test
    void testLogin() {
        userTableController.login(null, null);
        userTableController.login("123", null);
        userTableController.login(null, "123");


    }

}