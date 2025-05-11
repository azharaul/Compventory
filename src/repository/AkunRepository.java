/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

/**
 *
 * @author auliazhar
 */
public interface AkunRepository {
    boolean register(String username, String password, String role);
    boolean login(String username, String password);
    String getRole(String username);
}
