/*
 * Contributors: Ash
 * Description: this serves as a collection of our controllers
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.sql.Connection;

import database.DatabaseCreator;
import object.Message;
import object.Trip;
import object.User;
import object.Vehicle;
import objectGateway.MessageGateway;
import objectGateway.TripGateway;
import objectGateway.UserGateway;
import objectGateway.VehicleGateway;

public class DashBoard {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public DashBoard() {
        pc = new PanelController(this);
        mc = new MessageCollectionController();
        uc = new UserCollectionController();
        dc = DatabaseCreator.getInstance();
    }
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: pc
     * precondition: void
     * postcondition: nothing is changed
     */
    public PanelController getPanelController() {
        return pc;
    }
    
    /*
     * description: getter
     * return: tc
     * precondition: void
     * postcondition: nothing is changed
     */
    public MessageCollectionController getMessageCollectionController() {
        return mc;
    }
    
    /*
     * description: getter
     * return: uc
     * precondition: void
     * postcondition: nothing is changed
     */
    public UserCollectionController getUserCollectionController() {
        return uc;
    }
    
    public void save() {
        Connection connection = dc.getConnection();
        UserGateway userGateway = new UserGateway(connection);
        VehicleGateway vehicleGateway = new VehicleGateway(connection);
        TripGateway tripGateway = new TripGateway(connection);
        MessageGateway messageGateway = new MessageGateway(connection);
        
        for(User user : uc.getUsers()) {
            vehicleGateway.save(user.getVehicle());
            userGateway.save(user);
        }
        
        for(Message message : mc.getMessages()) {
            tripGateway.save(message.getTrip());
            messageGateway.save(message);
        }
    }
    
    public void load() {
        Connection connection = dc.getConnection();
        UserGateway userGateway = new UserGateway(connection);
        MessageGateway messageGateway = new MessageGateway(connection);
        
        for(User user : userGateway.getLoaded().values()) {
            uc.register(user);
        }
        
        for(Message message : messageGateway.getLoaded().values()) {
            mc.postMessage(message);
        }
    }
    
    public static void removeFromDatabase(User user) {
        UserGateway userGateway = new UserGateway(DatabaseCreator.getInstance().getConnection());
        
        userGateway.delete(user);
    }
    
    public static void removeFromDatabase(Vehicle vehicle) {
        VehicleGateway vehicleGateway = new VehicleGateway(DatabaseCreator.getInstance().getConnection());
        
        vehicleGateway.delete(vehicle);
    }
    
    public static void removeFromDatabase(Message message) {
        MessageGateway messageGateway = new MessageGateway(DatabaseCreator.getInstance().getConnection());
        
        messageGateway.delete(message);
    }
    
    public static void removeFromDatabase(Trip trip) {
        TripGateway tripGateway = new TripGateway(DatabaseCreator.getInstance().getConnection());
        
        tripGateway.delete(trip);
    }
    
    //variable not to be saved upon shutdown
    private PanelController pc;
    private MessageCollectionController mc;
    private UserCollectionController uc;
    private DatabaseCreator dc;
}
