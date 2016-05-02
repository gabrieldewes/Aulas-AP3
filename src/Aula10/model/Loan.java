package Aula10.model;

import Aula10.control.MainControl;
import Aula10.dao.FriendDAO;
import Aula10.dao.ItemDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gabriel on 02/05/16.
 */
public class Loan {
    private int id_loan;
    private int[] loan_has_item;
    private int id_friend;
    private String loan_date;

    public Loan (int idl, int[] lhi, int idf, String ld) {
        this.setId_loan(idl);
        this.setLoan_has_item(lhi);
        this.setId_friend(idf);
        this.setLoan_date(ld);
    }

    public static Loan readNewLoan () throws SQLException {
        int idf = 0;
        int[] lhi = {0};
        int i=0;
        boolean exit=false;
        Scanner in = new Scanner(System.in);

        FriendDAO fd = new FriendDAO();
        fd.listFriend();
        System.out.print("ID do amigo: ");
        while (idf == 0) {
            String str = in.next();
            idf = MainControl.strToInt(str);
        }
        in.nextLine();
        ItemDAO it = new ItemDAO();
        it.listItems();
        System.out.println("OBS: separe por vírgula para vários itens.");
        System.out.print("ID do item: ");
        String str = in.nextLine();
        try { lhi = MainControl.strToIntArray(str); }
        catch (Exception e) { e.getMessage(); }
        for (int j=0; j<lhi.length; j++) {
            System.out.print(lhi[j] +", ");
        }

        System.out.println("Data de empréstimo: ");
        String ld = in.next();
        return new Loan(0, lhi, idf, ld);
    }

    public int getId_loan() {
        return id_loan;
    }
    public void setId_loan(int id_loan) {
        this.id_loan = id_loan;
    }
    public int[] getLoan_has_item() {
        return loan_has_item;
    }
    public void setLoan_has_item(int[] loan_has_item) {
        this.loan_has_item = loan_has_item;
    }
    public int getId_friend() {
        return id_friend;
    }
    public void setId_friend(int id_friend) {
        this.id_friend = id_friend;
    }
    public String getLoan_date() {
        return loan_date;
    }
    public void setLoan_date(String loan_date) {
        this.loan_date = loan_date;
    }
}
