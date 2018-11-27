package objectSaver;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;

import database.DatabaseProtocol;
import database.SQLStatementExecuter;
import object.Message;
import object.User;

public class UserSaver extends SQLStatementExecuter {

    @Override
    protected Boolean hook(Connection connection, Object object) {
        User user = (User) object;
        Long key = user.getPrimaryKey();
        
        SQLStatement = "INSERT INTO User ("
                + ((key != null) ? "id, " : "")
                + "email, passHash, gender, name, contact, age, picture, isDriver, car, rating, ratingCount, notifications) VALUES "
                + "(" + ((key != null) ? key + ", " : "")
                + "'" + user.getEmail()
                + "', " + user.getPassHash()
                + ", " + ((user.getGender() == true) ? 1 : 0)
                + ", '" + user.getName()
                + "', '" + user.getContact()
                + "', " + user.getAge()
                + ", '" + user.getPicture()
                + "', " + ((user.isDriver() == true) ? 1 : 0)
                + ", " + user.getVehicle().getPrimaryKey()
                + ", " + user.getRating()
                + ", " + user.getRatingCount()
                + ", " + DatabaseProtocol.dataTypes.foreignKeySet
                + "( ";
                
        Set<Message> notifications = user.getNotifications();
        for(Iterator<Message> i = notifications.iterator(); i.hasNext();) {
            SQLStatement += i.next().getPrimaryKey() + ((i.hasNext()) ? " " : " , ");
        }
        
        SQLStatement += "));";
        
        return true;
    }
}
