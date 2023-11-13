package Application;
import java.util.*;
import java.util.Scanner;

import APIs.Bank;
import APIs.BankCIB;
import APIs.BankMisr;
import User.UserDB;

// import User.UserDB;


public class InstitoSystem {
    UserDB userDB;
    public BankMisr bankMisr=BankMisr.getInstance();
    public BankCIB bankCIB=BankCIB.getInstance();

    private void loadDummyData(){
        
            userDB = new UserDB();

        userDB.addUserBank("Ahmed", "01005181038", "Ahmed123", "1234567891234567", "BankMisr");
        userDB.addUserBank("Mohamed", "01112509992", "Mohamed123", "2345678912345670", "BankMisr");
        userDB.addUserBank("Ali", "01112501234", "Ali123", "3456791234567120", "BankMisr");
       
        userDB.addUserBank("Mahmoud", "01000401038", "Mahmoud123", "1134567891234567", "BankCIB");
        userDB.addUserBank("Hassan", "01012345678", "Hassan123", "1045678912345670", "BankCIB");
        userDB.addUserBank("Khaled", "01143332642", "Khaled123", "9456791234567120", "BankCIB");


        userDB.addUserWallet("Ahmed", "01005182020", "Ahmed123", "VodafoneCash");
        userDB.addUserWallet("Mohamed", "01002502010", "Mohamed123", "VodafoneCash");
        userDB.addUserWallet("Ali", "01002501223", "Ali123", "VodafoneCash");
       
        userDB.addUserWallet("Mahmoud", "01105182020", "Mahmoud123", "EtislatCash");
        userDB.addUserWallet("Hassan", "01112502010", "Hassan123", "EtislatCash");
        userDB.addUserWallet("Khaled", "01102501223", "Khaled123", "EtislatCash");
    }

    public InstitoSystem() {
    
        loadDummyData();
    }

    private void LoginForm(){
        System.out.println("Enter your username");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        Login login = new Login(userName,password);
        // if(login.checkLogin(userDB)){
        //     System.out.println("Login successfully");
        // }
        // else{
        //     System.out.println("Invalid username or password");
        // }

    }
    private void chooseRegisterionType(int choice){
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
    public void RegisterForm(){
        System.out.println("Do you want to register using 1.bank account 2.wallet provider ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        chooseRegisterionType(choice);
    }

    public void displayMenu() {

    }

    

}
