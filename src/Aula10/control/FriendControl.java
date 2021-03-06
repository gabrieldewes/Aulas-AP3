package Aula10.control;

import Aula10.dao.FriendDAO;
import Aula10.model.Friend;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gabriel on 02/05/16.
 */
public class FriendControl {
    public static Scanner in = new Scanner(System.in);

    private static ArrayList<Friend> friends = new ArrayList<>();
    private static FriendDAO fd;
    private static Friend f;

    private static final String FRIEND_HEADER =
            "+------------------------ AMIGOS --------------------------+";
    public static final String FRIEND_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Selecionar: (ID do amigo)                       Sair (0) |\n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    public static void newFriend() throws SQLException {
        fd = new FriendDAO();
        f = Friend.readNewFriend();
        fd.createFriend(f);
    }

    private static void updateFriend(int id_friend) throws SQLException {
        fd = new FriendDAO();
        if (fd.getFriend(id_friend))
            fd.updateFriend(id_friend);
    }

    private static void removeFriend(int id_friend) throws SQLException {
        fd = new FriendDAO();
        fd.removeFriend(id_friend);
    }

    public static boolean listFriend() throws SQLException {
        fd = new FriendDAO();
        friends = fd.listFriend();
        return friends.size() > 0;
    }

    public static void friendManager() throws SQLException {
        int id=1;
        String aux = "1";
        boolean sair = false;
        while (!sair) {
            System.out.println(FRIEND_HEADER);
            if (listFriend()) {
                System.out.println(FRIEND_FOOTER);
                aux = in.next();
                if (!aux.contentEquals("0")) {
                    id = MainControl.strToInt(aux);
                    if (id != 0) {
                        fd = new FriendDAO();
                        if (fd.getFriend(id)) {
                            //aux = "1";
                            while (!aux.contentEquals("0")) {
                                System.out.println(MainControl.OPTION_FOOTER);
                                aux = in.next();
                                switch (aux) {
                                    case "1": {
                                        updateFriend(id);
                                        aux="0";
                                    }
                                    break;
                                    case "2": {
                                        if (MainControl.confirm())
                                            removeFriend(id);
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
