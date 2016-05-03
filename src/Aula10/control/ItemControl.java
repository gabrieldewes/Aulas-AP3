package Aula10.control;

import Aula10.dao.ItemDAO;
import Aula10.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gabriel on 02/05/16.
 */
public class ItemControl {
    public static Scanner in = new Scanner(System.in);
    private static ArrayList<Item> items = new ArrayList<>();
    private static ItemDAO itd;
    private static Item it;

    public ItemControl() throws SQLException {

    }

    private static final String ITEM_HEADER = "\n" +
            "+------------------------- ITENS --------------------------+";
    private static final String ITEM_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Selecionar: (ID do item)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    public static void newItem() throws SQLException {
        itd = new ItemDAO();
        it = Item.readNewItem();
        itd.createItem(it);
    }

    private static void updateItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        if (itd.getItem(id_item))
            itd.updateItem(id_item);
    }

    private static void removeItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        itd.removeItem(id_item);
    }

    private static boolean listItem() throws SQLException {
        itd = new ItemDAO();
        items = itd.listItems();
        return items.size() > 0;
    }

    public static void itemManager() throws SQLException {
        int id=0;
        String aux="1";
        System.out.println(ITEM_HEADER);
        if (listItem()) {
            while (!aux.contentEquals("0")) {
                System.out.println(ITEM_FOOTER);
                aux = in.next();
                if (!aux.contentEquals("0")) {
                    id = MainControl.strToInt(aux);
                    if (id != 0) {
                        itd = new ItemDAO();
                        if (itd.getItem(id)) {
                            aux = "1";
                            while (!aux.contentEquals("0")) {
                                System.out.println(MainControl.OPTION_FOOTER);
                                aux = in.next();
                                switch (aux) {
                                    case "1": {
                                        updateItem(id);
                                        aux = "0";
                                    }
                                    break;
                                    case "2": {
                                        if (MainControl.confirm())
                                            removeItem(id);
                                        aux = "0";
                                    }
                                    break;
                                    default:
                                        System.out.println("Inválido. ");
                                }
                            }
                        }
                    } else
                        System.out.println("Inválido. Digite novamente ");

                }
            }
        }
    }
}
