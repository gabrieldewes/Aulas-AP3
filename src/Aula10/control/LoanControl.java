package Aula10.control;

import Aula10.dao.FriendDAO;
import Aula10.dao.LoanDAO;
import Aula10.model.Loan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by gabriel on 02/05/16.
 */
public class LoanControl {
    public static Scanner in = new Scanner(System.in);
    private static ArrayList<Object> loans = new ArrayList<>();
    private static LoanDAO ld;
    private static Loan l;

    private static final String LOAN_HEADER = "\n" +
            "+--------------------- EMPRÉSTIMOS ------------------------+";

    private static final String LOAN_FOOTER =
            "+----------------------------------------------------------+ \n" +
            "| Selecionar: (ID do empréstimo)                  Sair (0) | \n" +
            "+----------------------------------------------------------+ \n" +
            "- Sua opção: ";

    public static void newLoan() throws SQLException {
        int idf = 0;
        int[] lhi = {0};
        String aux = "1";
        Scanner in = new Scanner(System.in);
        System.out.println(LOAN_HEADER);
        while (!aux.contentEquals("0")) {
            if (FriendControl.listFriend()) {
                System.out.println(FriendControl.FRIEND_FOOTER);
                while (idf == 0) {
                    String str = in.next();
                    if (str.contentEquals("0")) {
                        aux = "0";
                        break;
                    }
                    else
                        idf = MainControl.strToInt(str);
                }
                in.nextLine();
                if (!aux.contentEquals("0")) {
                    FriendDAO fd = new FriendDAO();
                    if (fd.getFriend(idf)) {
                        System.out.println("\nSelecione os itens: ");
                        if (ItemControl.listItem()) {
                            System.out.println("OBS: separe por vírgula para vários itens.");
                            System.out.print(ItemControl.ITEM_FOOTER);
                            String str = in.nextLine();
                            if (str.contentEquals("0")) {
                                System.out.println("Cancelado.");
                                break;
                            }
                            try {
                                lhi = MainControl.strToIntArray(str);
                            } catch (Exception e) {
                                e.getMessage();
                            }
                            /*for (int j = 0; j < lhi.length; j++) {
                                System.out.println(lhi[j]);
                            }*/
                            if (lhi.length > 1) {
                                ld = new LoanDAO();
                                l = Loan.readNewLoan(idf, lhi);
                                if (l != null) {
                                    ld.createLoan(l);
                                    aux = "0";
                                }
                            } else
                                System.out.println("Adicione itens. ");
                        } else {
                            System.out.println("Cadastre itens. ");
                            aux = "0";
                        }
                    } else
                        idf = 0;
                }
            } else {
                System.out.println("Cadastre amigos. ");
                aux = "0";
            }
        }
    }

    private static void updateLoan(int id_loan) throws SQLException {
        ld = new LoanDAO();
    }

    private static void removeLoan(int id_loan) throws SQLException {
        ld = new LoanDAO();
        ld.removeLoan(id_loan);
    }

    private static boolean listLoan() throws SQLException {
        ld = new LoanDAO();
        loans = ld.listLoan();
        return loans.size() > 0;
    }

    public static void loanManager() throws SQLException {
        int id=1;
        String aux = "1";
        boolean sair = false;
        while (!sair) {
            System.out.println(LOAN_HEADER);
            if (listLoan()) {
                System.out.println(LOAN_FOOTER);
                aux = in.next();
                if (!aux.contentEquals("0")) {
                    id = MainControl.strToInt(aux);
                    if (id != 0) {
                        ld = new LoanDAO();
                        if (ld.getLoan(id)) {
                            while (!aux.contentEquals("0")) {
                                System.out.println(MainControl.OPTION_FOOTER);
                                aux = in.next();
                                switch (aux) {
                                    case "1": {
                                        updateLoan(id);
                                        aux="0";
                                    }
                                    break;
                                    case "2": {
                                        if (MainControl.confirm())
                                            removeLoan(id);
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
