/*
 * Contributors: Ash
 * Description: this serves as a collection of our controllers
 * Date Last Modified: 10/22/2018
 */

package controller;

import collection.IOBuffers;

public class DashBoard {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public DashBoard() {
        pc = new PanelController();
        tc = new MessageCollectionController();
        uc = new UserCollectionController();
        buffers = new IOBuffers();
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
    public MessageCollectionController getMessageTableController() {
        return tc;
    }
    
    /*
     * description: getter
     * return: uc
     * precondition: void
     * postcondition: nothing is changed
     */
    public UserCollectionController getUserTableController() {
        return uc;
    }
    
    public void save() {
        tc.save(buffers);
        uc.save(buffers);
    }
    
    public void load() {
        tc.load(buffers);
        uc.load(buffers);
    }
    
    //variable not to be saved upon shutdown
    private IOBuffers buffers;
    private PanelController pc;
    private MessageCollectionController tc;
    private UserCollectionController uc;
}
