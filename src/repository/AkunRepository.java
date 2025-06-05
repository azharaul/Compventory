package repository;

public interface AkunRepository {
    boolean register(String username, String password, String role);
    
    boolean login(String username, String password);
    
    String getRole(String username);
    
    static String showEror() {
        return "Gagal Mengambil";
    }
    
    default String hasingError() {
        return "Hashing Error";
    }
    
}
