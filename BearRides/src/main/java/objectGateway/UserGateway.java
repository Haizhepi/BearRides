package objectGateway;

import java.sql.Connection;
import java.util.List;

import object.User;

public class UserGateway extends Gateway<User> {

    public UserGateway(Connection connection) {
        super(connection);
    }

    @Override
    public Gateway<User> save(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Gateway<User> delete(Object object) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> load() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User find(Long id) {
        // TODO Auto-generated method stub
        return null;
    }
}
