/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.sql.Connection;
import javax.swing.JTable;

/**
 *
 * @author auliazhar
 */
public interface KeuanganService {
    public void ShowKeuanganLogs(Connection conn, JTable table);
}
