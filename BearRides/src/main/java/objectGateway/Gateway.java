package objectGateway;

import java.sql.Connection;
import java.util.Map;

public abstract class Gateway<T> {
    protected Connection connection;
    
    public Gateway() {
    }
    
    public abstract Gateway<T> save(Object object);
    
    public abstract Gateway<T> delete(Object object);
    
    protected abstract Map<Long, T> load();
    
    public abstract Map<Long, T> getLoaded();
    
    public abstract T find(Long id);
}
