package com.csi3471.app;

import objectTable.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import database.DatabaseCreator;
import database.SQLStatementExecuter;
import object.Message;
import object.Trip;
import object.User;
import object.Vehicle;
import objectSaver.MessageSaver;
import objectSaver.TripSaver;
import objectSaver.UserSaver;
import objectSaver.VehicleSaver;

public class DerbyTest {
    
    @Test
    @BeforeAll
    public static void createTableTest() {
        DatabaseCreator db = DatabaseCreator.getInstance();
        Connection connection = db.getConnection();
        SQLStatementExecuter tableCreator;
        
        //clear the previous tables
        Statement statement = null;
        try {
            statement = connection.createStatement();
            
            statement.execute(
                    "SELECT"
                    + " 'ALTER TABLE '||S.SCHEMANAME||'.'||T.TABLENAME||' DROP CONSTRAINT '||C.CONSTRAINTNAME||';'"
                    + " FROM"
                    + " SYS.SYSCONSTRAINTS C,"
                    + " SYS.SYSSCHEMAS S,"
                    + " SYS.SYSTABLES T"
                    + " WHERE"
                    + " C.SCHEMAID = S.SCHEMAID"
                    + " AND"
                    + " C.TABLEID = T.TABLEID"
                    + " AND"
                    + " S.SCHEMANAME = 'BearRides'"
                    + " UNION"
                    + " SELECT 'DROP TABLE ' || schemaname ||'.' || tablename || ';'"
                    + " FROM SYS.SYSTABLES"
                    + " INNER JOIN SYS.SYSSCHEMAS ON SYS.SYSTABLES.SCHEMAID = SYS.SYSSCHEMAS.SCHEMAID"
                    + " where schemaname='BearRides'");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        tableCreator = new VehicleTableCreator();
        tableCreator.execute(connection, null);
        
        tableCreator = new UserTableCreator();
        tableCreator.execute(connection, null);
        
        tableCreator = new TripTableCreator();
        tableCreator.execute(connection, null);
        
        tableCreator = new TripRiderTableCreator();
        tableCreator.execute(connection, null);
        
        tableCreator = new TripRequirementTableCreator();
        tableCreator.execute(connection, null);
        
        tableCreator = new MessageTableCreator();
        tableCreator.execute(connection, null);
    }
    
    @Test
    @AfterAll
    public static void closeConnection() {
        DatabaseCreator.getInstance().freeInstance();
    }
    
    @Test
    public void saveObjectTest() {
        DatabaseCreator db = DatabaseCreator.getInstance();
        Connection connection = db.getConnection();
        SQLStatementExecuter objectSaver;
        
        Vehicle vehicle = new Vehicle("Tesla", 4);
        User user = new User("test@baylor.edu", "foo");
        
        vehicle.setPicture("foo");
        vehicle.setStorageSpace("2 foo");
        
        objectSaver = new VehicleSaver();
        objectSaver.execute(connection, vehicle);
        //vehicle now has a primary key
        
        user.setAge(99);
        user.setContact("2542542544");
        user.setGender(true);
        user.setName("john");
        user.setPicture("url");
        user.insertRating(100);
        user.setVehicle(vehicle);
        
        objectSaver = new UserSaver();
        objectSaver.execute(connection, user);
        //user now has a primary key
        
        Message message = new Message(user);
        Trip trip = new Trip(user, new Date(), 3);
        
        trip.setDestinLoc("there");
        trip.setDestinTime(new Date());
        trip.setOriginLoc("here");
        trip.setOriginTime(new Date());
        trip.setReturnLoc("close to here");
        trip.setReturnTime(new Date());
        trip.insertRequirement("need to be cool yo");
        trip.insertRider(user);
        
        objectSaver = new TripSaver();
        objectSaver.execute(connection, trip);
        //trip now has primary key
        
        message.setBody("testing out here is a body");
        message.setTitle("a really cool title");
        message.setTrip(trip);
        
        objectSaver = new MessageSaver();
        objectSaver.execute(connection, message);
        //message now has primary key but its last
    }
    
    @Test
    public void loadObjectTest() {
        
    }
    
    @Test
    public void updateObjectTest() {
        
    }
    
    @Test
    public void deleteObjectTest() {
        
    }
}
