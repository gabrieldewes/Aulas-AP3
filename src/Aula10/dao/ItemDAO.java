package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Item;
import Aula10.model.ItemType;
import org.sqlite.SQLiteConnection;
import org.sqlite.SQLiteDataSource;

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

    public ItemDAO() throws SQLException {
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
            //System.out.println(stmt);
            stmt.execute();
            stmt.close();
            helper.close();
            System.out.println("Item salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar item. ");
            throw new RuntimeException(e);
        }

    }

    public void updateItem (int id_item) throws SQLException {
        Item it = Item.readNewItem();
        helper = new DBHelper();
        try {
            stmt = helper.prepareStatement(update);
            stmt.setString(1, it.getName());
            stmt.setString(2, it.getBuy_date());
            stmt.setDouble(3, it.getPrice());
            stmt.setString(4, it.getCons_state());
            stmt.setInt(5, it.getType().getValor());
            stmt.setInt(6, id_item);
            //System.out.println(stmt);
            stmt.executeUpdate();
            stmt.close();
            helper.close();
            System.out.println("Item alterado!");
        } catch (SQLException e) {
            System.out.println("Erro ao alterar item. ");
            throw new RuntimeException(e);
        }

    }

    public void removeItem (int id_item) {
        try {
            stmt = helper.prepareStatement(delete);
            stmt.setInt(1, id_item);
            //System.out.println(stmt);
            stmt.executeUpdate();
            stmt.close();
            helper.close();
            System.out.println("Item removido.");
        } catch (SQLException e) {
            System.out.println("Erro ao remover item. ");
            throw new RuntimeException(e);
        }
    }

    public boolean getItem (int id_item) throws SQLException {
        try {
            stmt = helper.prepareStatement(select);
            stmt.setInt(1, id_item);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id_item");
                    String name = rs.getString("name_item");
                    String date = rs.getString("buy_date");
                    double price = rs.getDouble("price");
                    String cons_state = rs.getString("cons_state");
                    int type = rs.getInt("type");

                    for (ItemType it:ItemType.values()) {
                        if (it.getValor() == type) {
                            System.out.println("Nome: "+ name +", Categoria: "+ it.name() +", Comprado em: "+ date +", por "+ price + ". Está "+ cons_state);
                            return true;
                        }
                    }
                }
            } else
                System.out.println("Item não encontrado. ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            helper.close();
        }
        return false;
    }

    public ArrayList<Item> listItems () throws SQLException {
        ArrayList<Item> items = new ArrayList<>();
        try {
            stmt = helper.prepareStatement(list);
            ResultSet rs = stmt.executeQuery();
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id = rs.getInt("id_item");
                    String name = rs.getString("name_item");
                    String date = rs.getString("buy_date");
                    double price = rs.getDouble("price");
                    String cons_state = rs.getString("cons_state");
                    int type = rs.getInt("type");

                    for (ItemType it:ItemType.values()) {
                        if (it.getValor() == type) {
                            System.out.println("("+ id +") - "+ name +" : "+ it.name() +" : "+ date +" : "+ price + " : "+ cons_state);
                            Item itm = new Item(id, it, date, price, cons_state, name);
                            items.add(itm);
                        }
                    }
                }
            }
            else { System.out.println("Parece que você não cadastrou itens ainda. "); }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            helper.close();
        }
        return items;
    }
}
