package repository;

/**
 *
 * @author Zildjian XTO
 */
public interface AkunRepository {

    /**
     *
     * @param username
     * @param password
     * @param role
     * @param gender
     * @return
     */
    boolean register(String username, String password, String role, String gender);
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    boolean login(String username, String password);
    
    /**
     *
     * @param username
     * @return
     */
    String getRole(String username);
    
    /**
     *
     * @return
     */
    static String showEror() {
        return "Failed to Retrieve";
    }
    
    /**
     *
     * @return
     */
    default String hasingError() {
        return "Hashing Error";
    }
    
}
