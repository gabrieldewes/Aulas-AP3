package Aula10.control;

import Aula10.dao.FriendDAO;
import Aula10.model.Friend;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gabriel on 02/05/16.
 */
public class FriendControl {

    private static ArrayList<Friend> friends = new ArrayList<>();
    private static FriendDAO fd;
    private static Friend f;

    public static final String FRIEND_HEADER =
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

    public static void updateFriend(int id_friend) throws SQLException {
        fd = new FriendDAO();
        fd.updateFriend(id_friend);
    }

    public static void removeFriend(int id_friend) throws SQLException {
        fd = new FriendDAO();
        fd.removeFriend(id_friend);
    }

    public static void listFriend() throws SQLException {
        fd = new FriendDAO();
        friends = fd.listFriend();
    }
}
