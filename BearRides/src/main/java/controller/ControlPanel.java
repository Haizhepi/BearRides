/*
 * Contributors: Ash
 * Description: this serves as a collection of our controllers
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.io.File;

public class ControlPanel {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public ControlPanel(File file) {
        pc = new PanelController();
        tc = new MessageTableController(file);
        uc = new UserTableController(file);
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
    public MessageTableController getMessageTableController() {
        return tc;
    }
    
    /*
     * description: getter
     * return: uc
     * precondition: void
     * postcondition: nothing is changed
     */
    public UserTableController getUserTableController() {
        return uc;
    }
    
    /*~~~~~~~~~~~~ Setters  ~~~~~~~~~~~~*/
    
    /*
     * description: setter
     * return: pc
     * precondition: void
     * postcondition: pc is set
     */
    public void setPanelController(PanelController pc) {
        this.pc = pc;
    }
    
    /*
     * description: setter
     * return: tc
     * precondition: void
     * postcondition: tc is set
     */
    public void setTableController(MessageTableController tc) {
        this.tc = tc;
    }
    
    /*
     * description: setter
     * return: uc
     * precondition: void
     * postcondition: uc is set
     */
    public void setUserTableController(UserTableController uc) {
        this.uc = uc;
    }
    
    //variable not to be saved upon shutdown
    private PanelController pc;
    private MessageTableController tc;
    private UserTableController uc;
}
