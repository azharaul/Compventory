
package service;
import java.sql.Connection;
import javax.swing.JTable;

/**
 *
 * @author Zildjian XTO
 * @author Azhar Aulia
 */
public interface KeuanganService {

    /**
     *
     * @param conn
     * @param table
     */
    public void ShowKeuanganLogs(Connection conn, JTable table);
}
