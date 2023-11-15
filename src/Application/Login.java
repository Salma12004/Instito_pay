package Application;
import java.util.Scanner;
import Transaction.*;
import User.User;
import User.UserBank;
import User.UserDB;
import User.UserWallet;

/**
 * The Login class represents the user login functionality in InstitoPay.
 * It handles the login process, user menu display, and transaction initiation.
 */
public class Login {
    String userName;
    String password;
    User user;
    /**
     * Constructs a Login instance with the provided username and password.
     *
     * @param userName The username for login.
     * @param password The password for login.
     */    
    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    /**
     * Sets the username for login.
     *
     * @param userName The username for login.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Sets the password for login.
     *
     * @param password The password for login.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Gets the username for login.
     *
     * @return The username for login.
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Gets the password for login.
     *
     * @return The password for login.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Sets the logged-in user.
     *
     * @param user The logged-in user.
     */
    public void setUser(User user) {
        this.user = user;
    }
    /**
     * Initiates the login process. Checks the existence of the user and logs in if
     * valid. Displays the user menu and handles user choices.
     */
    public void login(){
        int type = UserDB.getInstance().checkExistence(userName);
        if(type==1){
            System.out.println("Login successful");
            String [] userInfo = UserDB.getInstance().getUserInfo(userName);
            User user = new UserBank(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4]);
            setUser(user);
        }
        else if(type==2){
            System.out.println("Login successful");
            String [] userInfo = UserDB.getInstance().getUserInfo(userName);
            User user = new UserWallet(userInfo[0],userInfo[1],userInfo[2],userInfo[3]);
            setUser(user);
        }
        else{
            System.out.println("Invalid username or password");
        }
        while (true){
        displayUserMenu();}
    }
    /**
     * Displays the user menu based on the user type (bank or wallet) and handles
     * user choices for transactions and balance checking.
     */
    private void displayUserMenu(){
        int type = UserDB.getInstance().checkExistence(userName);
        while(true){
            System.out.println("Welcome ");
            System.out.println("1-Transfer");
            System.out.println("2-Pay bills");
            System.out.println("3-Check balance");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Choose Transaction");
                    System.out.println("1. Transfer to Wallet");
                    System.out.println("2. Transfer to Instito Account");
                    if(type==1){
                        System.out.println("3. Transfer to Bank Account");
                    }
                    System.out.println("0. Go Back");
                    int transType=sc.nextInt();

                    if(transType==1){
                        Transaction transaction = new WalletTransaction();
                        user.setTransaction(transaction);;
                    }else if (transType==2) {
                        Transaction transaction = new InstitoTransaction();
                        user.setTransaction(transaction);
                    
                    }else if (transType==3 && type==1) {//bank only
                        Transaction transaction = new BankTransaction();
                        user.setTransaction(transaction);
                    }else if(transType == 0){
                        break;
                    }
                    else{
                        System.out.println("Invalid choice");
                    }
                    user.performTransefer();
                    break;
                case 2:
                    user.payBills();
                    break;
                case 3:
                   double Useramount = user.getBalance();
                     System.out.println("Your balance is: "+Useramount);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        
    }
    }
}
