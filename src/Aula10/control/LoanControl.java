package Aula10.control;

import Aula10.dao.LoanDAO;
import Aula10.model.Loan;

import java.sql.SQLException;

/**
 * Created by gabriel on 02/05/16.
 */
public class LoanControl {
    private static LoanDAO ld;
    private static Loan l;

    public static void newLoan() throws SQLException {
        ld = new LoanDAO();
        l = Loan.readNewLoan();
        ld.createLoan(l);
    }

    public static void listLoan() throws SQLException {
        ld = new LoanDAO();
        ld.listLoan();
    }
}
