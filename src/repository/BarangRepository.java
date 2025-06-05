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
     public void showTableListBarang(JTable table, Connection conn);
     
     public void tambahBarangStock(Component parentComponent, JTable table, String username);
     
     public void KurangiStockBarang(Component parentComponent, JTable table, String username);
     
     public void tambahBarangBaru(Component parentComponent, JTable table);
     
     public void lihatRiwayatBarang(JTable table, Component parentComponent, JButton button, JButton button2);
     
     public void userBeliBarang(JTable table, Connection conn, String username);
     
     public void catatTransaksiKeuangan(String jenis, int jumlah, String keterangan, String username, int status);
}


