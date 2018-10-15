package objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicle {
    
    public Vehicle() {
        //stubbed
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((passengerCapacity == null) ? 0
                : passengerCapacity.hashCode());
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
        if (passengerCapacity == null) {
            if (other.passengerCapacity != null)
                return false;
        } else if (!passengerCapacity.equals(other.passengerCapacity))
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
    
    //getters
    public String getModel() {
        return model;
    }
    
    public String getPicture() {
        return picture;
    }
    
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
    
    public String getStorageSpace() {
        return storageSpace;
    }
    
    //setters
    public void setModel(String model) {
        this.model = model;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public void setPassengerCapacity(Integer passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
    
    public void setStorageSpace(String storageSpace) {
        this.storageSpace = storageSpace;
    }
    
    //variables
    @XmlElement
    private String model;
    @XmlElement
    private String picture;
    @XmlElement
    private Integer passengerCapacity;
    @XmlElement
    private String storageSpace;
}