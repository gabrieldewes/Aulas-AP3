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
    private static ItemDAO itd = null;
    private static Item it;

    public ItemControl() throws SQLException {
        if (itd != null) {
            itd = new ItemDAO();
        }
    }

    private static final String ITEM_HEADER = "\n" +
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

    private static void updateItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        if (itd.getItem(id_item))
            itd.updateItem(id_item);
    }

    private static void removeItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        itd.removeItem(id_item);
    }

    public static boolean listItem() throws SQLException {
        itd = new ItemDAO();
        items = itd.listItems();
        return items.size() > 0;
    }

    public static void itemManager() throws SQLException {
        int id=1;
        String aux = "1";
        boolean sair = false;
        while (!sair) {
            System.out.println(ITEM_HEADER);
            if (listItem()) {
                System.out.println(ITEM_FOOTER);
                aux = in.next();
                if (!aux.contentEquals("0")) {
                    id = MainControl.strToInt(aux);
                    if (id != 0) {
                        itd = new ItemDAO();
                        if (itd.getItem(id)) {
                            //aux = "1";
                            while (!aux.contentEquals("0")) {
                                System.out.println(MainControl.OPTION_FOOTER);
                                aux = in.next();
                                switch (aux) {
                                    case "1": {
                                        updateItem(id);
                                        aux="0";
                                    }
                                    break;
                                    case "2": {
                                        if (MainControl.confirm())
                                            removeItem(id);
                                        aux="0";
                                    }
                                    break;
                                    case "0": {
                                        aux = "0";
                                        id=0;
                                        //sair=true;
                                        break;
                                    }
                                    default:
                                        System.out.println("Inválido. ");
                                        break;
                                }
                            }
                        }
                    } else
                        System.out.println("Inválido. Digite novamente: ");
                } else
                    sair=true;
            } else
                sair=true;
        }
    }
}
