package objectUpdater;

import java.sql.Connection;

import object.User;

public class UserUpdater extends Updater {
    
    @Override
    public Boolean hook(Connection connection, Object object) {
        User user = (User) object;
        
        if(user.getPrimaryKey() != null) {
            UpdateSQL = "UPDATE User"
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
                    + " SET notifications = " + "" //nested table of BIGINT foreign keys
                    + " WHERE id = " + user.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
