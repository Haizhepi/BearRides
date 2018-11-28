package objectLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobStringConversion { 
    public static String convert(Clob clob) throws IOException, SQLException{
        if (clob == null) {
            return  "";
        } else {
        }

        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = new BufferedReader(clob.getCharacterStream());
        String string;

        while ((string = bufferedReader.readLine()) != null) {
            stringBuffer.append(string);
        }
        return stringBuffer.toString();
    }
}