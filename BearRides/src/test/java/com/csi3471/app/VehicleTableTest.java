package com.csi3471.app;

import org.junit.jupiter.api.Test;

import database.DatabaseCreator;
import database.SQLStatementExecuter;
import objectTable.VehicleTableCreator;

public class VehicleTableTest {
    
    @Test
    public void createTable() {
        SQLStatementExecuter tableCreator = new VehicleTableCreator();
        tableCreator.execute(DatabaseCreator.getInstance().getConnection(), null);
    }
}
