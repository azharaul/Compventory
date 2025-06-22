/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JTable;


/**
 *
 * @author auliazhar
 */
public interface BarangRepository {

    /**
     *
     * @param table
     * @param conn
     */
    public void showTableListBarang(JTable table, Connection conn);
     
    /**
     *
     * @param parentComponent
     * @param table
     * @param username
     */
    public void tambahBarangStock(Component parentComponent, JTable table, String username);
     
    /**
     *
     * @param parentComponent
     * @param table
     * @param username
     */
    public void KurangiStockBarang(Component parentComponent, JTable table, String username);
     
    /**
     *
     * @param parentComponent
     * @param table
     */
    public void tambahBarangBaru(Component parentComponent, JTable table);
     
    /**
     *
     * @param table
     * @param parentComponent
     * @param button
     * @param button2
     */
    public void lihatRiwayatBarang(JTable table, Component parentComponent, JButton button, JButton button2);
     
    /**
     *
     * @param table
     * @param conn
     * @param username
     */
    public void userBeliBarang(JTable table, Connection conn, String username);
     
    /**
     *
     * @param jenis
     * @param jumlah
     * @param keterangan
     * @param username
     * @param status
     */
    public void catatTransaksiKeuangan(String jenis, int jumlah, String keterangan, String username, int status);
}


