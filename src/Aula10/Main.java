package Aula10;

import Aula10.dao.FriendDAO;
import Aula10.dao.ItemDAO;
import Aula10.database.DBHelper;
import Aula10.model.Friend;
import Aula10.model.Item;
import Aula10.model.ItemType;
import org.sqlite.SQLiteConnection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by gabriel on 30/04/16.
 */
/*
    Inventário
    Você esta cansando de emprestar suas coisas (CDS, Livros, Eletrônicos) para seus amigos e não receber eles novamente.
    Pensando nisso crie um programa de repositório para os seus itens.
    Todos os seus itens devem possuir data de compra, valor pago por ele e o nome.
    Os CD devem possuir a quantidade de faixas, nome da Banda/Cantor e álbum e estado de conservação (Bom, Ruim, Arranhado...).
    Os livros devem possuir o titulo e se já foi ou não lido.
    Nesse programa você pode cadastrar seus amigos, e emprestar um item para ele informando o dia previsto para entrega.
    O programa deve então:
    Possibilitar o cadastro (CRUD) de itens e de pessoas;
    Possibilitar o empréstimo do item assim como a devolução do mesmo.
    Visualizar quais estão emprestados e para quem esta emprestado.
    Mostrar os itens que você possui.
*/
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {
        DBHelper hp = new DBHelper();
        //hp.onCreate(hp);
        //hp.onCreate2(hp);
        //hp.onDelete(hp);

        ItemDAO itd = new ItemDAO();
        //Item it = Item.readNewItem();
        //itd.createItem(it);
        //itd.listItems();

        FriendDAO fd = new FriendDAO();
        //Friend f = Friend.readNewFriend();
        //fd.createFriendship(f);
        //fd.listFriendships();
        //fd.updateFriendship(2);
        //fd.removeFriendship(2);

    }

}
