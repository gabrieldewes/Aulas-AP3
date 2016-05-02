package Aula10.dao;

import Aula10.database.DBHelper;
import Aula10.model.Loan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by gabriel on 02/05/16.
 */
public class LoanDAO {
    private static DBHelper helper;
    private static PreparedStatement stmt = null;

    public LoanDAO() throws SQLException {
        helper = new DBHelper();
    }

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS loan (" +
            "id_loan INTEGER PRIMARY KEY AUTOINCREMENT," +
            "id_friend INTEGER," +
            "loan_date TEXT); ";

    public static final String CREATE_FOREIGN_TABLE = "CREATE TABLE IF NOT EXISTS loan_has_item (" +
            "id_loan INTEGER, " +
            "id_item INTEGER); ";

    private static final String INSERT =
            "INSERT INTO loan (id_friend, loan_date) VALUES (?, ?); ";

    private static final String INSERT_FOREIGN =
            "INSERT INTO loan_has_item (id_item, id_loan) VALUES (?, ?); ";

    private static final String LIST =
            "SELECT * FROM loan " +
                "INNER JOIN loan_has_item ON loan.id_loan = loan_has_item.id_loan " +
                "INNER JOIN items ON loan_has_item.id_item = items.id_item;";


    public void createLoan (Loan l) {
        int id_loan;
        try {
            stmt = helper.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, l.getId_friend());
            stmt.setString(2, l.getLoan_date());
            System.out.println(stmt);
            stmt.execute();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id_loan = generatedKeys.getInt(1);
                }
                else {throw new SQLException("Não retornou chaves.");}
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
            for (int i=0; i<aux.length; i++) {
                stmt.setInt(1, aux[i]);
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

    public void listLoan() {
        try {
            stmt = helper.prepareStatement(LIST);
            ResultSet rs = stmt.executeQuery();
            if (rs.getFetchSize() >= 0) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id_loan") +", "+ rs.getString("loan_date") +", "+ rs.getString("name_item"));
                }
            }
            stmt.close();
            helper.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
