package objectGateway;

import java.sql.Connection;
import java.util.List;

public abstract class Gateway<T> {
    protected Connection connection = null;
    
    public Gateway(Connection connection) {
        this.connection = connection;
    }
    
    public abstract Gateway<T> save(Object object);
    
    public abstract Gateway<T> delete(Object object);
    
    public abstract List<T> load();
    
    public abstract T find(Long id);
}
