package Aula10.control;

import Aula10.database.DBHelper;
import org.sqlite.SQLiteConnection;

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

    public static final String OPTION_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Alterar (1) | Apagar (2)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";





    protected static void reinitialize() throws SQLException {
        DBHelper helper = new DBHelper();
        System.out.println("Apagando tabelas...");
        helper.onDelete(helper);
        System.out.println("Recriando tabelas...");
        //helper.onCreate2(helper);
        helper.onCreate(helper);
    }
}
