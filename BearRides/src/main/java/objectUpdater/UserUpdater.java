package objectUpdater;

import java.sql.Connection;
import java.util.Iterator;
import java.util.Set;

import database.DatabaseProtocol;
import database.SQLStatementExecuter;
import object.Message;
import object.User;

public class UserUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean hook(Connection connection, Object object) {
        User user = (User) object;
        
        if(user.getPrimaryKey() != null) {
            SQLStatement = "UPDATE User"
                    + " SET email = '" + user.getEmail() //CLOB
                    + "' SET passHash = " + user.getPassHash() //INTEGER
                    + " SET gender = " + ((user.getGender() == true) ? 1 : 0) //BIT
                    + " SET name = '" + user.getName() //CLOB
                    + "' SET contact = '" + user.getContact() //CLOB
                    + "' SET age = " + user.getAge() //INTEGER
                    + " SET picture = '" + user.getPicture() //CLOB
                    + "' SET isDriver = " + ((user.isDriver() == true) ? 1 : 0) //BIT
                    + " SET car = " + user.getVehicle() //BIGINT
                    + " SET rating = " + user.getRating() //INTEGER
                    + " SET ratingCount = " + user.getRatingCount() //INTEGER
                    + " SET notifications = " + DatabaseProtocol.dataTypes.foreignKeySet.toString()
                    + "( "; //nested table of BIGINT foreign keys
            
            Set<Message> notifications = user.getNotifications();
            for(Iterator<Message> i = notifications.iterator(); i.hasNext();) {
                SQLStatement += i.next().getPrimaryKey() + ((i.hasNext()) ? " " : " , ");
            }
            
            SQLStatement += ") WHERE id = " + user.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
