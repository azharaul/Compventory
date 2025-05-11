/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Connection conn = DBConnectionService.getConnection();
            if (conn != null) {
                conn.close(); // tutup lagi setelah cek berhasil
                LoginPage loginpage = new LoginPage();
                loginpage.setVisible(true);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
                "Gagal terhubung ke database.\nPeriksa koneksi atau pengaturan database.", 
                "Kesalahan Koneksi", 
                JOptionPane.ERROR_MESSAGE);
            System.exit(1); // keluar dari program
        }
    }
    
}

