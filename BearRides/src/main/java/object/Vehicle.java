/*
 * Contributors: Ash
 * Description: this class serves as any vehicle a user might have
 * Date Last Modified: 10/22/2018
 */

package object;

public class Vehicle {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/
    
    public Vehicle(String model, Integer passengerCap) {
        this.model = model;
        this.passengerCap = passengerCap;
    }
    
    /*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
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
    
    /*
     * description: getter
     * return: primaryKey
     * precondition: void
     * postcondition: nothing is changed
     */
    public Long getPrimaryKey() {
        return primaryKey;
    }

    /*~~~~~~~~~~~~ Setters  ~~~~~~~~~~~~*/
    
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
    
    /*
     * description: setter
     * return: void
     * precondition: void
     * postcondition: primaryKey is set
     */
    public void setPrimaryKey(Long key) {
        primaryKey = key;
    }
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
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
    
    //variables to be saved upon shutdown
    private Long primaryKey = null;
    
    private String model;
    private String picture;
    private Integer passengerCap;
    private String storageSpace;
}