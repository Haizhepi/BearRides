package com.csi3471.app;

import objectTable.*;
import org.junit.jupiter.api.Test;

import database.DatabaseCreator;
import database.SQLStatementExecuter;

public class VehicleTableTest {
    
    @Test
    public void createTable() {
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
}
