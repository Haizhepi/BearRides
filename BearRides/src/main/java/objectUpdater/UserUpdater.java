package objectUpdater;

import java.sql.Connection;
import java.sql.Statement;

import database.SQLStatementExecuter;
import object.User;

public class UserUpdater extends SQLStatementExecuter {
    
    @Override
    public Boolean beforeHook(Statement statement, Object object) {
        User user = (User) object;
        

        SQLStatement = "UPDATE UserTable"
                + " SET email = '" + user.getEmail() //VAR CHAR
                + "' SET passHash = " + user.getPassHash() //INTEGER
                + " SET gender = '" + ((user.getGender() == true) ? 1 : 0) //CHAR
                + "' SET name = '" + user.getName() //VAR CHAR
                + "' SET contact = '" + user.getContact() //VAR CHAR
                + "' SET age = " + user.getAge() //INTEGER
                + " SET picture = '" + user.getPicture() //VAR CHAR
                + "' SET isDriver = '" + ((user.isDriver() == true) ? 1 : 0) //CHAR
                + "' SET car = " + user.getVehicle().getPrimaryKey() //BIGINT
                + " SET rating = " + user.getRating() //INTEGER
                + " SET ratingCount = " + user.getRatingCount() //INTEGER
                + " WHERE id = " + user.getPrimaryKey() + ";";

        return true;
    }
}
