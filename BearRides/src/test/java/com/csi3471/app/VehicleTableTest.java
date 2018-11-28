package com.csi3471.app;

import object.Vehicle;
import objectSaver.VehicleSaver;
import objectTable.*;
import org.junit.jupiter.api.Test;

import database.DatabaseCreator;
import database.SQLStatementExecuter;

public class VehicleTableTest {
    
    @Test
    public void createTableTest() {
        SQLStatementExecuter tableCreatorV = new VehicleTableCreator();
        tableCreatorV.execute(DatabaseCreator.getInstance().getConnection(), null);
        SQLStatementExecuter tableCreatorU = new UserTableCreator();
        tableCreatorU.execute(DatabaseCreator.getInstance().getConnection(), null);
        SQLStatementExecuter tableCreatorR = new TripUserRelationTableCreator();
        tableCreatorR.execute(DatabaseCreator.getInstance().getConnection(), null);
        SQLStatementExecuter tableCreatorM = new MessageTableCreator();
        tableCreatorM.execute(DatabaseCreator.getInstance().getConnection(), null);
        SQLStatementExecuter tableCreatorT = new TripTableCreator();
        tableCreatorT.execute(DatabaseCreator.getInstance().getConnection(), null);
    }

    @Test
    public void insertTest() {
        Vehicle vehicle = new Vehicle("diet coke", 10);
        VehicleSaver vehicleSaver = new VehicleSaver();
        vehicleSaver.execute(DatabaseCreator.getInstance().getConnection(), vehicle);
    }
}
