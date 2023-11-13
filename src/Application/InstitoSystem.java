package Application;
import java.util.*;
import java.util.Scanner;
import APIs.Bank;
import APIs.BankCIB;
import APIs.BankMisr;
import APIs.EtislatCashProvider;
import APIs.VodafoneCashProvider;
import User.User;
import User.UserBank;
import User.UserDB;


public class InstitoSystem {
    // public BankMisr bankMisr=BankMisr.getInstance();
    // public BankCIB bankCIB=BankCIB.getInstance();
    // public EtislatCashProvider etislatCashProvider=EtislatCashProvider.getInstance();
    // public VodafoneCashProvider vodafoneCashProvider=VodafoneCashProvider.getInstance();

    private void loadDummyData(){
        UserDB.getInstance().addUserBank("Ahmed", "01005181038", "Ahmed123", "1234567891234567", "BankMisr");
        UserDB.getInstance().addUserBank("Mohamed", "01112509992", "Mohamed123", "2345678912345670", "BankMisr");
        UserDB.getInstance().addUserBank("Ali", "01112501234", "Ali123", "3456791234567120", "BankMisr");
       
        UserDB.getInstance().addUserBank("Mahmoud", "01000401038", "Mahmoud123", "1134567891234567", "BankCIB");
        UserDB.getInstance().addUserBank("Hassan", "01012345678", "Hassan123", "1045678912345670", "BankCIB");
        UserDB.getInstance().addUserBank("Khaled", "01143332642", "Khaled123", "9456791234567120", "BankCIB");


        UserDB.getInstance().addUserWallet("Ahmed", "01005182020", "Ahmed123", "VodafoneCash");
        UserDB.getInstance().addUserWallet("Mohamed", "01002502010", "Mohamed123", "VodafoneCash");
        UserDB.getInstance().addUserWallet("Ali", "01002501223", "Ali123", "VodafoneCash");
       
        UserDB.getInstance().addUserWallet("Mahmoud", "01105182020", "Mahmoud123", "EtislatCash");
        UserDB.getInstance().addUserWallet("Hassan", "01112502010", "Hassan123", "EtislatCash");
        UserDB.getInstance().addUserWallet("Khaled", "01102501223", "Khaled123", "EtislatCash");
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

    }

    private void chooseRegisterionType(int choice){
        if(choice==1){
            // Bankregistration bank = new Bankregistration();
            // bank.register();
        Validator validator = new Validator();

                    System.out.println("-----------------Bank registration-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();

        System.out.println("Enter mobile number");
        String mobileNumber = sc.nextLine();
        while(!validator.checkValidNumber(mobileNumber)){
            System.out.println("It is not a valid mobile number, please enter a valid mobile number:");
            mobileNumber = sc.nextLine();
        }

        System.out.println("Enter a strong password:");
        System.out.println(" Here is a format of strong password: ");
        System.out.println("1-Is at least 8 characters long and 12 max.\n2-Must include at least one uppercase and at least one lowercase letters\n3-Must include numbers and special symbols:");
        String password = sc.nextLine();
        while(!validator.checkStrongPassword(password)){
            System.out.println("It is not a strong password, please enter a strong password:");
            password = sc.nextLine();
        }

        int bankType;
        System.out.println("Choose your bank:");
        System.out.println("1-Bank Misr");
        System.out.println("2-Bank CIB");
        bankType = sc.nextInt();
        while(bankType != 1 && bankType != 2){
            System.out.println("Please enter a valid choice:");
            bankType = sc.nextInt();
        }
        sc.nextLine();

        System.out.println("Enter credit card number");
        String creditCard = sc.nextLine();
        while(!validator.checkValidCreditCard(creditCard)){
            System.out.println("It is not a valid credit card number, please enter a valid credit card number:");
            creditCard = sc.nextLine();
        }
        int OTP = validator.sentOTP();
        System.out.println("OTP: " + OTP);
        if(!validator.enterOTP(OTP)){
            System.out.println("Invalid OTP");
        }
        else{
            if(bankType == 1){
                if(!BankMisr.getInstance().checkExistence(mobileNumber , creditCard)){
                    System.out.println("This user does not exist in this bank");
                }
                else{
                    User BankMisr_User= new UserBank(name,  mobileNumber,  password,  creditCard,  "BankMisr");
                    UserDB.getInstance().addUserBank(name, mobileNumber, password, creditCard, "BankMisr");
                }
            }
            else{
                if(!BankCIB.getInstance().checkExistence(mobileNumber , creditCard)){
                    System.out.println("This user does not exist in this bank");
                }
                else{
                    User BankCIB_User= new UserBank(name,  mobileNumber,  password,  creditCard,  "BankCIB");
                    UserDB.getInstance().addUserBank(name, mobileNumber, password, creditCard, "BankCIB");
                      
                }
            } 
        }
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
            Scanner sc = new Scanner(System.in);
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
        }
    }

    

}
