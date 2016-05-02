package Aula10.control;

import Aula10.database.DBHelper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

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

    static final String OPTION_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Alterar (1) | Apagar (2)                        Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";


    protected static void reinitialize() throws SQLException {
        DBHelper helper = new DBHelper();
        System.out.println("Apagando tabelas...");
        helper.onDelete(helper);
        System.out.println("Recriando tabelas...");
        helper.onCreate2(helper);
        //helper.onCreate(helper);
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
                vet[i] = in;

        }
        return vet;
    }
}
