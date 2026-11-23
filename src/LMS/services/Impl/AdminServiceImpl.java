package LMS.services.Impl;

import LMS.services.AdminService;

public class AdminServiceImpl implements AdminService {
    private String username = "admin";
    private String password = "1234";

    @Override
    public boolean signIn(String username, String password) {
        if (this.username.equals(username)
                && this.password.equals(password)) {
            System.out.println("Кош келиңиз, Admin!");
            return true;
        } else {
            System.out.println("Логин же пароль туура эмес!");
            return false;
        }
    }

    @Override
    public void changePassword(String oldPassword,
                               String newPassword) {

        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Пароль ийгиликтүү өзгөртүлдү!");
        } else {
            System.out.println("Эски пароль туура эмес!");
        }
    }
}
