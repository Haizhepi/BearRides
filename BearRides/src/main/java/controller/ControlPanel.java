package controller;

import java.io.File;

public class ControlPanel {
    public ControlPanel(File file) {
        pc = new PanelController();
        tc = new MessageTableController(file);
        uc = new UserTableController(file);
    }
    
    public PanelController getPanelController() {
        return pc;
    }
    public MessageTableController getMessageTableController() {
        return tc;
    }
    public UserTableController getUserTableController() {
        return uc;
    }
    
    public void setPanelController(PanelController pc) {
        this.pc = pc;
    }
    public void setTableController(MessageTableController tc) {
        this.tc = tc;
    }
    public void setUserTableController(UserTableController uc) {
        this.uc = uc;
    }
    
    private PanelController pc;
    private MessageTableController tc;
    private UserTableController uc;
}
