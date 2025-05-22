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

    public static void main(String[] args) {
        try {
            Connection conn = DBConnectionService.getConnection();
            if (conn != null) {
                conn.close();
                LoginPage loginpage = new LoginPage("t");
                loginpage.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Gagal terhubung ke database.\nPeriksa koneksi atau pengaturan database.", 
                "Kesalahan Koneksi", 
                JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
}

