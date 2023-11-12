package Application;

import User.UserDB;

public class Login {
    String userName;
    String password;
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public boolean checkLogin(UserDB userDB){
        //check dataBase
        return true;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }

}
