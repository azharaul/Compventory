package repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import service.DBConnectionService;

/**
 *
 * @author Zildjian XTO
 */
public class KeuanganRepositoryImpl implements KeuanganRepository{

    /**
     *
     * @return
     */
    @Override
    public int getSaldo() {
        int saldo = 0;
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT saldo FROM keuangan WHERE id = 1");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                saldo = rs.getInt("saldo"); 
            }
        } catch (SQLException e) {
            System.err.println("Failed to take balance: " + e.getMessage());
        }
        return saldo;
    }

    /**
     *
     * @param saldoBaru
     */
    @Override
    public void setSaldo(int saldoBaru) {
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE keuangan SET saldo = ? WHERE id = 1")) {

            ps.setInt(1, saldoBaru);  
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to update balance: " + e.getMessage());
        }
    }

}
