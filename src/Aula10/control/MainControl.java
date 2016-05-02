package Aula10.control;

import java.sql.SQLException;
import java.util.Scanner;
import static Aula10.control.FriendControl.*;
import static Aula10.control.ItemControl.*;

/**
 * Created by gabriel on 01/05/16.
 */
public class MainControl {
    public static Scanner in = new Scanner(System.in);

    protected static final String DEFAULT_MENU =
            "+-------------------------------------+ \n" +
            "| ITENS       | Novo (1) | Listar (2) | \n" +
            "|-------------------------------------| \n" +
            "| AMIGOS      | Novo (3) | Listar (4) | \n" +
            "|-------------------------------------| \n" +
            "| EMPRÉSTIMOS | Novo (5) | Listar (6) | \n" +
            "|-------------------------------------| \n" +
            "| Reiniciar (7) |            Sair (0) | \n" +
            "+-------------------------------------+ \n" +
            "- Sua opção: ";

    private static final String OPTION_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Alterar (1) | Apagar (2)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    protected static void friendManager() throws SQLException {
        int id=0;
        String aux = "1";
        System.out.println(FRIEND_HEADER);
        FriendControl.listFriend();
        while (!aux.contentEquals("0")) {
            System.out.println(FRIEND_FOOTER);
            aux = in.next();
            if (!aux.contentEquals("0")) {
                try {
                    id = Integer.parseInt(aux);
                } catch (NumberFormatException n) {
                    System.out.println("Erro: " + n.getMessage());
                }
                aux = "1";
                while (!aux.contentEquals("0")) {
                    System.out.println(OPTION_FOOTER);
                    aux = in.next();
                    switch (aux) {
                        case "1": {
                            FriendControl.updateFriend(id);
                            aux = "0";
                        }
                            break;
                        case "2": {
                            FriendControl.removeFriend(id);
                            aux = "0";
                        }
                            break;
                        case "0":
                            break;
                        default:
                            System.out.println("Inválido. ");
                            break;
                    }
                }
            }
        }
    }

    protected static void itemManager() throws SQLException {
        int id=0;
        String aux="1";
        System.out.println(ITEM_HEADER);
        ItemControl.listItem();
        while (!aux.contentEquals("0")) {
            System.out.println(ITEM_FOOTER);
            aux = in.next();
            if (!aux.contentEquals("0")) {
                try { id = Integer.parseInt(aux); }
                catch (NumberFormatException n) { System.out.println("Erro: " + n.getMessage()); }
                aux = "1";
                while (!aux.contentEquals("0")) {
                    System.out.println(OPTION_FOOTER);
                    aux = in.next();
                    switch (aux) {
                        case "1": {
                            ItemControl.updateItem(id);
                            aux = "0";
                        }
                            break;
                        case "2": {
                            ItemControl.removeItem(id);
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
