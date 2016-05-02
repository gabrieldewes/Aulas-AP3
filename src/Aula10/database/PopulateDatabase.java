package Aula10.database;

import org.sqlite.SQLiteConnection;

import java.io.*;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gabriel on 01/05/16.
 */
public class PopulateDatabase {

    public void populate(SQLiteConnection db) throws IOException, SQLException {
        Statement stmt = db.createStatement();
        try {
            String line;
            BufferedReader input = openSQLfile( "assets/scripts/Insert.sql" );
            while ((line = input.readLine()) != null) {
                stmt.executeUpdate(line);
                System.out.println(line);
            }
            input.close();
        }
        catch (Exception err) {
            err.printStackTrace();
        }

    }

    private static BufferedReader openSQLfile(String SQL_FILE) throws FileNotFoundException {
        return new BufferedReader( new FileReader(SQL_FILE) );
    }
}
