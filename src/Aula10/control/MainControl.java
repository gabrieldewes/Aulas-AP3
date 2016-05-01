package Aula10.control;

import Aula10.Main;
import Aula10.dao.FriendDAO;
import Aula10.dao.ItemDAO;
import Aula10.model.Friend;
import Aula10.model.Item;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by gabriel on 01/05/16.
 */
public class MainControl {

    private static ArrayList<Friend> friends = new ArrayList<>();
    private static ArrayList<Item> items = new ArrayList<>();

    protected static void newFriend() throws SQLException {
        FriendDAO fd = new FriendDAO();
        Friend f = Friend.readNewFriend();
        fd.createFriend(f);
    }

    protected static void updateFriend(int id_friend ) throws SQLException {
        FriendDAO fd = new FriendDAO();
        fd.updateFriend(id_friend);
    }

    protected static void listFriend() throws SQLException {
        FriendDAO fd = new FriendDAO();
        friends = fd.listFriend();
    }

    protected static void newItem() throws SQLException {
        ItemDAO itd = new ItemDAO();
        Item it = Item.readNewItem();
        itd.createItem(it);
    }

    protected static void updateItem(int id_item ) throws SQLException {
        ItemDAO itd = new ItemDAO();

    }

    protected static void listItem() throws SQLException {
        ItemDAO itd = new ItemDAO();
        items = itd.listItems();
    }

    protected static void newLoan() throws SQLException {

    }

    protected static void listLoan() throws SQLException {

    }
}
