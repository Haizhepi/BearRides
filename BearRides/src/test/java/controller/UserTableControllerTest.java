package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTableControllerTest {
    UserCollectionController userTableController = null;
    @BeforeEach
    void init() {
        userTableController = new UserCollectionController();
    }

    @Test
    void testConstructor() {
        new UserCollectionController();
    }

    @Test
    void testConstructor0() {
         new UserCollectionController();
    }

    @Test
    void testLogin() {
        userTableController.login(null, null);
        userTableController.login("123", null);
        userTableController.login(null, "123");
    }

}