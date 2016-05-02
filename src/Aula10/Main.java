package Aula10;

import Aula10.control.MainControl;
import java.sql.SQLException;
import java.util.Scanner;

import static Aula10.control.FriendControl.*;
import static Aula10.control.ItemControl.*;

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
public class Main extends MainControl {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        //DBHelper hp = new DBHelper();
        //hp.onCreate(hp);
        //hp.onCreate2(hp);
        //hp.onDelete(hp);

        //ItemDAO itd = new ItemDAO();
        //Item it = Item.readNewItem();
        //itd.createItem(it);
        //items = itd.listItems();

        //FriendDAO fd = new FriendDAO();
        //Friend f = Friend.readNewFriend();
        //fd.createFriend(f);
        //friends = fd.listFriend();
        //fd.updateFriend(2);
        //fd.removeFriend(2);

        String aux="1";
        while (!aux.contentEquals("0")) {
            System.out.println(DEFAULT_MENU);
            aux = in.next();
            switch (aux) {
                case "1":
                    newItem();
                    break;
                case "2":
                    itemManager();
                    break;
                case "3":
                    newFriend();
                    break;
                case "4":
                    friendManager();
                    break;

                case "0":
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Inválido. ");
                    break;
            }
        }

    }

}
