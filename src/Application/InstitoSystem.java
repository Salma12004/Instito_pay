package Application;
import java.util.*;
import java.util.Scanner;

import User.UserDB;


public class InstitoSystem {
    UserDB userDB;

    private void LoginForm(){
        System.out.println("Enter your username");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        Login login = new Login(userName,password);
        if(login.checkLogin(userDB)){
            System.out.println("Login successfully");
        }
        else{
            System.out.println("Invalid username or password");
        }

    }
    void chooseRegisterionType(int choice){
        if(choice==1){
            Bankregistration bank = new Bankregistration();
            bank.register();
        }
        else if(choice==2){
            WalletRegistration wallet = new WalletRegistration();
            wallet.register();
        }
        else{
            System.out.println("Invalid choice");
        }
    }
    private void RegisterForm(){
        System.out.println("Do you want to register using 1.bank account 2.wallet provider ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        chooseRegisterionType(choice);
    }

    public void displayMenu() {

    }

    

}
