package Aula10.control;

import Aula10.dao.ItemDAO;
import Aula10.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gabriel on 02/05/16.
 */
public class ItemControl {

    private static ArrayList<Item> items = new ArrayList<>();
    private static ItemDAO itd;
    private static Item it;

    public static final String ITEM_HEADER =
            "+------------------------- ITENS --------------------------+";
    public static final String ITEM_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Selecionar: (ID do item)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    public static void newItem() throws SQLException {
        itd = new ItemDAO();
        it = Item.readNewItem();
        itd.createItem(it);
    }

    public static void updateItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        itd.updateItem(id_item);
    }

    public static void removeItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        itd.removeItem(id_item);
    }

    public static void listItem() throws SQLException {
        itd = new ItemDAO();
        items = itd.listItems();
    }
}
