package objectUpdater;

import java.sql.Connection;

import database.SQLStatementExecuter;
import object.User;

public class UserUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean beforeHook(Connection connection, Object object) {
        User user = (User) object;
        
        if(user.getPrimaryKey() != null) {
            SQLStatement = "UPDATE UserTable"
                    + " SET email = '" + user.getEmail() //CLOB
                    + "' SET passHash = " + user.getPassHash() //INTEGER
                    + " SET gender = '" + ((user.getGender() == true) ? 1 : 0) //CHAR
                    + "' SET name = '" + user.getName() //CLOB
                    + "' SET contact = '" + user.getContact() //CLOB
                    + "' SET age = " + user.getAge() //INTEGER
                    + " SET picture = '" + user.getPicture() //CLOB
                    + "' SET isDriver = '" + ((user.isDriver() == true) ? 1 : 0) //CHAR
                    + "' SET car = " + user.getVehicle().getPrimaryKey() //BIGINT
                    + " SET rating = " + user.getRating() //INTEGER
                    + " SET ratingCount = " + user.getRatingCount() //INTEGER
                    + " WHERE id = " + user.getPrimaryKey() + ";";
        }else {
            return false;
        }
        return true;
    }
}
