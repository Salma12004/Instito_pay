package Application;
import java.util.Scanner;
import User.UserDB;


public class InstoSystem {

    private void loadDummyData(){
        UserDB.getInstance().addUserBank("Ahmed", "01005181038", "Ahmed123", "1234567891234567", "BankMisr");
        UserDB.getInstance().addUserBank("Mohamed", "01112509992", "Mohamed123", "2345678912345670", "BankMisr");
        UserDB.getInstance().addUserBank("Ali", "01112501234", "Ali123", "3456791234567120", "BankMisr");
        
        UserDB.getInstance().addUserBank("Karim", "01000401038", "Mahmoud123", "1134567891234567", "BankCIB");
        UserDB.getInstance().addUserBank("Salma", "01012345678", "Hassan123", "1045678912345670", "BankCIB");
        UserDB.getInstance().addUserBank("Shrouk", "01143332642", "Khaled123", "9456791234567120", "BankCIB");


        UserDB.getInstance().addUserWallet("Shahd", "01005182020", "Ahmed123", "VodafoneCash");
        UserDB.getInstance().addUserWallet("Habiba", "01002502010", "Mohamed123", "VodafoneCash");
        UserDB.getInstance().addUserWallet("Youssef", "01002501223", "Ali123", "VodafoneCash");
        
        UserDB.getInstance().addUserWallet("Nada", "01105182020", "Mahmoud123", "EtisalatCash");
        UserDB.getInstance().addUserWallet("Kenzy", "01112502010", "Hassan123", "EtisalatCash");
        UserDB.getInstance().addUserWallet("Marwan", "01102501223", "Khaled123", "EtisalatCash");
    }

    public InstoSystem() {
        loadDummyData();
    }

    private void LoginForm(){
        System.out.println("Enter your username");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Enter your password");
        String password = sc.nextLine();
        Login login = new Login(userName, password);
        login.login();
        // displayUserMenu(login.user);
        
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

    private void RegisterForm(){
        System.out.println("Do you want to register using 1.bank account 2.wallet provider ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        chooseRegisterionType(choice);
    }

    public void displayMenu() {
        while(true){
            System.out.println("Welcome to InstitoPay System");
            System.out.println("1-Login");
            System.out.println("2-Register");
            System.out.println("3-Exit");
            System.out.println("4-Print users");
            Scanner sc = new Scanner(System.in);
            // try (Scanner sc = new Scanner(System.in)) {
                int choice = sc.nextInt();
                if(choice==1){
                    LoginForm();
                }
                else if(choice==2){
                    RegisterForm();
                }
                else if(choice==3){
                    break;
                }
                else if(choice==4){
                    UserDB.getInstance().printBankUsers();
                    UserDB.getInstance().printWalletUsers();
                }
                else{
                    System.out.println("Invalid choice");
                }
            // }
        }
    }

    

}