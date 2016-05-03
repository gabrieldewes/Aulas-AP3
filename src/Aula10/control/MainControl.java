package Aula10.control;

import Aula10.database.DBHelper;
import Aula10.database.PopulateDatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gabriel on 01/05/16.
 */
public class MainControl {
    public static Scanner in = new Scanner(System.in);
    private static DBHelper helper;

    protected static final String DEFAULT_MENU =
            "+-------------------------------+-------------------------------+-------------------------------+ \n" +
            "|            ITENS              |           AMIGOS              |        EMPRÉSTIMOS            | \n" +
            "|     Novo (1) | Listar (2)     |     Novo (3) | Listar (4)     |     Novo (5) | Listar (6)     | \n" +
            "+-------------------------------+-------------------------------+-------------------------------+ \n" +
            "|   Popular para teste (8)      |        Reiniciar (9)          |               Sair (0)        | \n" +
            "+-------------------------------+-------------------------------+-------------------------------+ \n" +
            "- Sua opção: ";

    static final String OPTION_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Alterar (1) | Apagar (2)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    protected static void populate() throws SQLException, IOException {
        helper = new DBHelper();
        PopulateDatabase pdb = new PopulateDatabase();
        System.out.println("Inserindo dados...");
        pdb.populate(helper);
        System.out.println("Pronto! ");
        helper.close();
    }

    protected static void reinitialize() throws SQLException {
        helper = new DBHelper();
        System.out.println("Apagando tabelas...");
        helper.onDelete(helper);
        System.out.println("Recriando tabelas...");
        helper.onCreate2(helper);
        //helper.onCreate(helper);
        helper.close();
        System.out.println("Pronto! ");
    }

    public static int strToInt(String str) {
        int id=0;
        try { id = Integer.parseInt(str); }
        catch (NumberFormatException n) { System.out.println("Erro: " + n.getMessage()); }
        return id;
    }

    public static int[] strToIntArray(String str) {
        String aux = "";
        String s = "";
        ArrayList<String> lhi = new ArrayList<>();
        str = str.concat(",");
        for (int i=0; i<str.length(); i++) {
            s = String.valueOf(str.charAt(i));
            if (s.contentEquals(",") || s.contentEquals(".") ) {
                lhi.add(aux);
                System.out.println(lhi);
                aux = "";
            } else {
                s = String.valueOf(str.charAt(i));
                aux = aux.concat(s);
            }
        }
        int[] vet = new int[lhi.size()];
        for (int i=0; i<lhi.size(); i++) {
            int in = MainControl.strToInt(lhi.get(i).trim());
            if (in != 0)
                vet[i] = in;

        }
        return vet;
    }

    public static boolean confirm() {
        System.out.print("Tem certeza? S/N : ");
        String aux = in.next();
        if (aux.contentEquals("s"))
            return true;
        else
            System.out.println("Cancelado. ");
        return false;
    }
}
