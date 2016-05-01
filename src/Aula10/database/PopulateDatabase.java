package Aula10.database;

import org.sqlite.SQLiteConnection;

import java.io.*;

/**
 * Created by gabriel on 01/05/16.
 */
public class PopulateDatabase {

    private static void populate(SQLiteConnection db) throws IOException {
        try {
            String line;
            BufferedReader input = openSQLfile( "assets/scripts/Insert.sql" );
            while ((line = input.readLine()) != null) {
                db.prepareStatement(line);
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
