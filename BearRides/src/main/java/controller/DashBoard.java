/*
 * Contributors: Ash
 * Description: this serves as a collection of our controllers
 * Date Last Modified: 10/22/2018
 */

package controller;

public class DashBoard {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public DashBoard() {
        pc = new PanelController();
        mc = new MessageCollectionController();
        uc = new UserCollectionController();
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
    }
    
    public void load() {
    }
    
    //variable not to be saved upon shutdown
    private PanelController pc;
    private MessageCollectionController mc;
    private UserCollectionController uc;
}
