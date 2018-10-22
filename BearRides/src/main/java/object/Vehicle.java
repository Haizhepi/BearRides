/*
 * Contributors: Ash
 * Description: This class serves as our data structure for users
 * Date Last Modified: 10/22/2018
 */

package object;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {
    
    /*¯`·._.·(¯`·._.· Construction ·._.·´¯)·._.·´¯)*/
    
    public Vehicle(String model, Integer passengerCap) {
        this.model = model;
        this.passengerCap = passengerCap;
    }
    
    /*¯`·._.·(¯`·._.· Getters ·._.·´¯)·._.·´¯)*/
    
    /*
     * description: getter
     * return: model
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getModel() {
        return model;
    }
    
    /*
     * description: getter
     * return: picture
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getPicture() {
        return picture;
    }
    
    /*
     * description: getter
     * return: passengerCap
     * precondition: void
     * postcondition: nothing is changed
     */
    public Integer getPassengerCap() {
        return passengerCap;
    }
    
    /*
     * description: getter
     * return: storageSpace
     * precondition: void
     * postcondition: nothing is changed
     */
    public String getStorageSpace() {
        return storageSpace;
    }

    /*¯`·._.·(¯`·._.· Setters ·._.·´¯)·._.·´¯*/
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: model is set
     */
    public void setModel(String model) {
        this.model = model;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: picture is set
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: passengerCap is set
     */
    public void setPassengerCap(Integer passengerCap) {
        this.passengerCap = passengerCap;
    }
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: storageSpace is set
     */
    public void setStorageSpace(String storageSpace) {
        this.storageSpace = storageSpace;
    }
    
    /*¯`·._.·(¯`·._.· Utilities ·._.·´¯)·._.·´¯*/
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((passengerCap == null) ? 0
                : passengerCap.hashCode());
        result = prime * result + ((picture == null) ? 0 : picture.hashCode());
        result = prime * result
                + ((storageSpace == null) ? 0 : storageSpace.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vehicle other = (Vehicle) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (passengerCap == null) {
            if (other.passengerCap != null)
                return false;
        } else if (!passengerCap.equals(other.passengerCap))
            return false;
        if (picture == null) {
            if (other.picture != null)
                return false;
        } else if (!picture.equals(other.picture))
            return false;
        if (storageSpace == null) {
            if (other.storageSpace != null)
                return false;
        } else if (!storageSpace.equals(other.storageSpace))
            return false;
        return true;
    }
    
    //variables to be saved upon shutdown, must be tagged with @XmlElement
    @XmlElement
    private String model;
    @XmlElement
    private String picture;
    @XmlElement
    private Integer passengerCap;
    @XmlElement
    private String storageSpace;
}