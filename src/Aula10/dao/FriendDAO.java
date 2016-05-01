package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Friend;
import org.sqlite.SQLiteConnection;

import javax.naming.Context;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;

/**
 * Created by gabriel on 30/04/16.
 */
public class FriendDAO {

    private DBHelper helper;
    private static PreparedStatement stmt = null;

    public FriendDAO() throws SQLException {
        helper = new DBHelper();
    }

    public static final String create_table = "CREATE TABLE IF NOT EXISTS amigos (" +
            "id_friend INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name_friend TEXT," +
            "address_friend TEXT," +
            "phone_friend INTEGER);";

    private static final String insert =
            "INSERT INTO amigos (name_friend, address_friend, phone_friend)" +
            " VALUES (?,?,?)";

    private static final String update =
            "UPDATE amigos SET name_friend=?, address_friend=?, phone_friend=? WHERE id_friend=?";

    private static final String delete =
            "DELETE FROM amigos WHERE id_friend = ?";

    private static final String select =
            "SELECT * FROM amigos WHERE id_friend=?";

    private static final String list =
            "SELECT * FROM amigos";

    public void createFriendship (Friend f) {
        try {
            stmt = helper.prepareStatement(insert);
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getAddress());
            stmt.setLong(3, f.getPhone());
            System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Amigo salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar amizade. ");
            throw new RuntimeException(e);
        }

    }

    public void updateFriendship (int id_friend) {
        Friend f = Friend.readNewFriend();
        try {
            stmt = helper.prepareStatement(update);
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getAddress());
            stmt.setLong(3, f.getPhone());
            stmt.setInt(4, id_friend);
            System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Amigo alterado.");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar amizade. ");
            throw new RuntimeException(e);
        }
    }

    public void removeFriendship (int id_friend) {
        try {
            stmt = helper.prepareStatement(delete);
            stmt.setInt(1, id_friend);
            System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Amigo removido.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover amizade. ");
            throw new RuntimeException(e);
        }
    }

    public void listFriendships() {
        try {
            stmt =  helper.prepareStatement(list);
            ResultSet rs = stmt.executeQuery();
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    int id = rs.getInt("id_friend");
                    String name = rs.getString("name_friend");
                    String address = rs.getString("address_friend");

                    System.out.println(id + " - "+ name + " : " + address);
                }
            }
            else { System.out.println("Parece que você não fez amizades ainda. "); }
            stmt.close();
            helper.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}