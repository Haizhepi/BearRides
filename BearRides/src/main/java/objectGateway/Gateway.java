package objectGateway;

import java.sql.Connection;
import java.util.Map;

public abstract class Gateway<T> {
    protected Connection connection;
    
    /*~~~~~~~~~~~~ Utilities  ~~~~~~~~~~~~*/
    
    /*
     * description: saves the object
     * return: this
     * precondition: void
     * postcondition: the object is saved
     */
    public abstract Gateway<T> save(Object object);
    
    /*
     * description: deletes the object
     * return: this
     * precondition: void
     * postcondition: the object is deleted
     */
    public abstract Gateway<T> delete(Object object);
    
    /*
     * description: loads all of the T type objects
     * return: a map of the id to the object
     * precondition: void
     * postcondition: T type objects are loaded
     */
    protected abstract Map<Long, T> load();
    
    /*
     * description: only loads if not already done
     * return: a map of the id to the object
     * precondition: void
     * postcondition: T type objects might be loaded
     */
    public abstract Map<Long, T> getLoaded();
    
    /*
     * description: finds object
     * return: object
     * precondition: void
     * postcondition: message object is deleted
     */
    public abstract T find(Long id);
}
