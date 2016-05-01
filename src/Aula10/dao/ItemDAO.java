package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Item;
import Aula10.model.ItemType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gabriel on 01/05/16.
 */
public class ItemDAO {

    private static DBHelper helper;
    private static PreparedStatement stmt = null;

    public ItemDAO () throws SQLException {
        helper = new DBHelper();
    }

    public static final String create_table = "CREATE TABLE IF NOT EXISTS items (" +
            "id_item INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name_item TEXT," +
            "buy_date TEXT," +
            "price DOUBLE," +
            "cons_state TEXT," +
            "type INTEGER);";

    private static final String insert =
            "INSERT INTO items (name_item, buy_date, price, cons_state, type)" +
                    " VALUES (?,?,?,?,?)";

    private static final String update =
            "UPDATE items SET name_item=?, buy_date=?, price=?, cons_state=?, type=? WHERE id_item=?";

    private static final String delete =
            "DELETE FROM items WHERE id_item = ?";

    private static final String select =
            "SELECT * FROM items WHERE id_item=?";

    private static final String list =
            "SELECT * FROM items";

    public void createItem(Item it) {
        try {
            stmt = helper.prepareStatement(insert);
            stmt.setString(1, it.getName());
            stmt.setString(2, it.getBuy_date());
            stmt.setDouble(3, it.getPrice());
            stmt.setString(4, it.getCons_state());
            stmt.setInt(5, it.getType().getValor());

            System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Item salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar item. ");
            throw new RuntimeException(e);
        }

    }

    public void listItems () {
        try {
            stmt = helper.prepareStatement(list);
            ResultSet rs = stmt.executeQuery();
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    int id = rs.getInt("id_item");
                    String name = rs.getString("name_item");
                    String date = rs.getString("buy_date");
                    double price = rs.getDouble("price");
                    String cons_state = rs.getString("cons_state");
                    int type = rs.getInt("type");

                    for (ItemType it:ItemType.values()) {
                        if (it.getValor() == type) {
                            System.out.println("ID: "+ id +": Tipo: "+ it.name() +" : "+ name +" : "+ date +" : "+ price + " : "+ cons_state);
                        }
                    }
                }
            }
            else { System.out.println("Parece que você não cadastrou itens ainda. "); }
            stmt.close();
            helper.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
