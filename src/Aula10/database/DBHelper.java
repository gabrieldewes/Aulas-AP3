package Aula10.database;

import Aula10.dao.FriendDAO;
import Aula10.dao.ItemDAO;
import Aula10.dao.LoanDAO;
import org.sqlite.SQLiteConnection;
import org.sqlite.SQLiteDataSource;
import org.sqlite.javax.SQLitePooledConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * Created by gabriel on 30/04/16.
 */
public class DBHelper extends SQLiteConnection {
    static final int DB_VERSION = 1;
    private static final String DB_NAME = "db/Aula10.db";
    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String DB_DRIVER = "jdbc:sqlite:";

    public DBHelper() throws SQLException {
        super( DB_DRIVER, DB_NAME );
    }

    /* Método Noob
    public static Connection getConn () {
        try {
            Class.forName( DRIVER );
            connection = DriverManager.getConnection( DB_DRIVER + DB_NAME );
            System.out.println("Conexão estabelecida.");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return connection;
    }
    */

    public void onCreate(SQLiteConnection db) throws SQLException {
        Statement statement = db.createStatement();
        statement.executeUpdate(FriendDAO.create_table);
        statement.executeUpdate(ItemDAO.create_table);
        statement.executeUpdate(LoanDAO.CREATE_TABLE);
        statement.executeUpdate(LoanDAO.CREATE_FOREIGN_TABLE);
    }

    public void onCreate2(SQLiteConnection db) throws SQLException {
        Statement stmt = db.createStatement();
        try {
            String line;
            BufferedReader input =
                    new BufferedReader
                            (new FileReader("assets/scripts/CreateTable.sql"));
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

    public void onUpgrade(int oldVersion, int newVersion) {

    }

    public void onDelete (SQLiteConnection db) throws SQLException {
        Statement statement = db.createStatement();
        statement.executeUpdate("DROP TABLE friends;");
        statement.executeUpdate("DROP TABLE items;");
        statement.executeUpdate("DROP TABLE loan;");
        statement.executeUpdate("DROP TABLE loan_has_item;");
    }

}
