
package service;
import java.sql.Connection;
import javax.swing.JTable;

/**
 *
 * @author Zildjian XTO
 */
public interface KeuanganService {

    /**
     *
     * @param conn
     * @param table
     */
    public void ShowKeuanganLogs(Connection conn, JTable table);
}
