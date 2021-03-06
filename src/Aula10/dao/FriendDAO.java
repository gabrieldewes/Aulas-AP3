package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Friend;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by gabriel on 30/04/16.
 */
public class FriendDAO {

    private static DBHelper helper;
    private static PreparedStatement stmt = null;

    public FriendDAO() throws SQLException {
        helper = new DBHelper();
    }

    public static final String create_table = "CREATE TABLE IF NOT EXISTS friends (" +
            "id_friend INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name_friend TEXT," +
            "address_friend TEXT," +
            "phone_friend INTEGER);";

    private static final String insert =
            "INSERT INTO friends (name_friend, address_friend, phone_friend)" +
            " VALUES (?,?,?)";

    private static final String update =
            "UPDATE friends SET name_friend=?, address_friend=?, phone_friend=? WHERE id_friend=?";

    private static final String delete =
            "DELETE FROM friends WHERE id_friend = ?";

    private static final String select =
            "SELECT * FROM friends WHERE id_friend=?";

    private static final String list =
            "SELECT * FROM friends";

    private static final String count =
            "SELECT COUNT(id_friend) FROM friends; ";

    public void createFriend(Friend f) {
        try {
            stmt = helper.prepareStatement(insert);
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getAddress());
            stmt.setLong(3, f.getPhone());
            //System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Amigo salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar amizade. ");
            throw new RuntimeException(e);
        }

    }

    public void updateFriend (int id_friend) throws SQLException {
        Friend f = Friend.readNewFriend();
        helper = new DBHelper();
        try {
            stmt = helper.prepareStatement(update);
            stmt.setString(1, f.getName());
            stmt.setString(2, f.getAddress());
            stmt.setLong(3, f.getPhone());
            stmt.setInt(4, id_friend);
            //System.out.println(stmt);
            stmt.executeUpdate();
            stmt.close();
            helper.close();
            System.out.println("Amigo alterado.");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar amizade. ");
            throw new RuntimeException(e);
        }
    }

    public void removeFriend (int id_friend) {
        try {
            stmt = helper.prepareStatement(delete);
            stmt.setInt(1, id_friend);
            //System.out.println(stmt);
            stmt.executeUpdate();
            stmt.close();
            helper.close();
            System.out.println("Amigo removido.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover amizade. ");
            throw new RuntimeException(e);
        }
    }

    public static boolean getFriend(int id_friend) throws SQLException {
        try {
            stmt = helper.prepareStatement(select);
            stmt.setInt(1, id_friend);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    System.out.println(
                            "- Nome: "+ rs.getString("name_friend") +
                            ", endereço: "+ rs.getString("address_friend") +
                            ", telefone: "+ rs.getInt("phone_friend"));
                    return true;
                }
            } else
                System.out.println("Amigo não encontrado. ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            helper.close();
        }
        return false;
    }

    public ArrayList<Friend> listFriend() throws SQLException {
        ArrayList<Friend> friends = new ArrayList<>();
        try {
            stmt = helper.prepareStatement(list);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id_friend");
                    String name = rs.getString("name_friend");
                    String address = rs.getString("address_friend");
                    long phone = rs.getInt("phone_friend");

                    Friend f = new Friend(id, name, address, phone);
                    friends.add(f);
                    System.out.println("(" + id + ") - "+ name + " : " + address +" : "+ phone);
                }
            }
            else { System.out.println("Parece que você não fez amizades ainda. "); }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            helper.close();
        }
        return friends;
    }

}
