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

    private static final String ITEM_HEADER =
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
        itd.updateItem(id_item);
    }

    private static void removeItem(int id_item) throws SQLException {
        itd = new ItemDAO();
        itd.removeItem(id_item);
    }

    private static void listItem() throws SQLException {
        itd = new ItemDAO();
        items = itd.listItems();
    }

    public static void itemManager() throws SQLException {
        int id=0;
        String aux="1";
        System.out.println(ITEM_HEADER);
        listItem();
        while (!aux.contentEquals("0")) {
            System.out.println(ITEM_FOOTER);
            aux = in.next();
            if (!aux.contentEquals("0")) {
                try { id = Integer.parseInt(aux); }
                catch (NumberFormatException n) { System.out.println("Erro: " + n.getMessage()); }
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
                            removeItem(id);
                            aux = "0";
                        }
                        break;
                        default:
                            System.out.println("Inválido. ");
                    }
                }
            }
        }
    }
}
