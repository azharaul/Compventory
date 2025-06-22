package entity;
import service.DBConnectionService;
import view.LoginPage;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Azhar Aulia Priatna
 * @author Zildjian XTO
 * @author Aditya Wijaya Putra
 */
public class Compventory {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Connection conn = DBConnectionService.getConnection();
            if (conn != null) {
                conn.close();
                LoginPage loginpage = new LoginPage("t");
                loginpage.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database.\nPlease check the connection or database settings.", "Connection Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
}

