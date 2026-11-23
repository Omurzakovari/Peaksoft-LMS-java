package LMS.services;

public interface AdminService {
    boolean signIn(String username, String password);
    void changePassword(String oldPassword, String newPassword);
}
