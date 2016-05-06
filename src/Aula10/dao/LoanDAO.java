package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Item;
import Aula10.model.Loan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by gabriel on 02/05/16.
 */
public class LoanDAO {
    private static DBHelper helper;
    private static PreparedStatement stmt = null;

    public LoanDAO() throws SQLException {
        helper = new DBHelper();
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS loan ( " +
            "id_loan INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "id_friend INTEGER REFERENCES friends(id_friend) ON UPDATE CASCADE ON DELETE RESTRICT, " +
            "loan_date TEXT); ";

    public static final String CREATE_FOREIGN_TABLE = "CREATE TABLE IF NOT EXISTS loan_has_item (" +
            "has_loan INTEGER REFERENCES loan(id_loan) ON UPDATE CASCADE ON DELETE RESTRICT, " +
            "has_item INTEGER REFERENCES items(id_item) ON UPDATE CASCADE ON DELETE RESTRICT); ";

    private static final String INSERT =
            "INSERT INTO loan (id_friend, loan_date) VALUES (?, ?); ";

    private static final String DELETE =
            "DELETE FROM loan WHERE id_loan = ?";

    private static final String INSERT_FOREIGN =
            "INSERT INTO loan_has_item (has_item, has_loan) VALUES (?, ?); ";

    private static final String LIST =
            "SELECT * FROM loan l " +
                "INNER JOIN friends f ON l.id_friend = f.id_friend " +
                "INNER JOIN loan_has_item lhi ON l.id_loan = lhi.has_loan " +
                "INNER JOIN items it ON lhi.has_item = it.id_item;";


    public void createLoan (Loan l) {
        int id_loan;
        try {
            stmt = helper.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, l.getId_friend());
            stmt.setString(2, l.getLoan_date());
            //System.out.println(stmt);
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id_loan = generatedKeys.getInt(1);
                }
                else {throw new SQLException("Aplicação retornou id com status 0. ");}
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar empréstimo. "+ e.getMessage());
            throw new RuntimeException(e);
        }
        try {
            int[] aux = l.getLoan_has_item();
            //System.out.println(id_loan);
            stmt = helper.prepareStatement(INSERT_FOREIGN);
            for (int id_item : aux) {
                stmt.setInt(1, id_item);
                stmt.setInt(2, id_loan);
                stmt.addBatch();
            }
            stmt.executeBatch();
            stmt.close();
            helper.close();
            System.out.println("Empréstimo salvo!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar empréstimo. "+ e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public void updateLoan(int id_loan) {

    }

    public void removeLoan(int id_loan) {
        try {
            stmt = helper.prepareStatement(DELETE);
            stmt.setInt(1, id_loan);
            //System.out.println(stmt);
            stmt.executeUpdate();
            stmt.close();
            helper.close();
            System.out.println("Empréstimo finalizado.");
        } catch (SQLException e) {
            System.out.println("Erro ao finalizar empréstimo. ");
            throw new RuntimeException(e);
        }
    }

    public boolean getLoan(int id_loan) {

        return true;
    }

    public ArrayList<Object> listLoan() {
        ArrayList<Object> loans = new ArrayList<>();
        try {
            stmt = helper.prepareStatement(LIST);
            ResultSet rs = stmt.executeQuery();
            int last_id=0;
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int id_loan = rs.getInt("id_loan");
                    int id_friend = rs.getInt("id_friend");
                    String name_friend = rs.getString("name_friend");
                    String loan_date = rs.getString("loan_date");
                    int has_loan = rs.getInt("has_loan");
                    //int id_item = rs.getInt("id_item");
                    String name_item = rs.getString("name_item");

                    if (last_id != id_loan) {
                        System.out.println("("+ id_loan +") Emprestado para "+ name_friend +", no dia "+ loan_date +" os itens: ");
                    }
                    if (id_loan == has_loan) {
                        System.out.println(" # "+ name_item );
                        last_id = id_loan;
                    }
                    Loan l = new Loan(id_loan, null, id_friend, loan_date);
                    loans.add(l);
                }
            }
            else {
                System.out.println("Parece que não há empréstimos. ");
            }
            stmt.close();
            helper.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return loans;
    }

}
