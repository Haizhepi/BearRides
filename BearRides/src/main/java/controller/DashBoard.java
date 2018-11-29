/*
 * Contributors: Ash
 * Description: this serves as a collection of our controllers
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.sql.Connection;

import database.DatabaseCreator;
import object.Message;
import object.User;
import objectGateway.MessageGateway;
import objectGateway.TripGateway;
import objectGateway.UserGateway;
import objectGateway.VehicleGateway;

public class DashBoard {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public DashBoard() {
        pc = new PanelController();
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
    
    public void remove(User user) {
        
    }
    
    public void remove(Message message) {
        
    }
    
    //variable not to be saved upon shutdown
    private PanelController pc;
    private MessageCollectionController mc;
    private UserCollectionController uc;
    private DatabaseCreator dc;
}
