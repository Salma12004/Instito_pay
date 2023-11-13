package Application;
import java.util.Scanner;
import Bill.BankTransaction;
import Bill.InstitoTransaction;
import Bill.Transaction;
import Bill.WalletTransaction;
import User.User;
import User.UserBank;
import User.UserDB;
import User.UserWallet;

public class Login {
    String userName;
    String password;
    User user;

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    public void setUser(User user) {
        this.user = user;
    }

    public void login(){
        int type = UserDB.getInstance().checkExistence(userName, password);
        if(type==1){
            System.out.println("Login successful");
            String [] userInfo = UserDB.getInstance().getUserInfo(userName, password);
            User user = new UserBank(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4]);
            setUser(user);
        }
        else if(type==2){
            System.out.println("Login successful");
            String [] userInfo = UserDB.getInstance().getUserInfo(userName, password);
            User user = new UserWallet(userInfo[0],userInfo[1],userInfo[2],userInfo[3],userInfo[4]);
            setUser(user);
           
        }
        else{
            System.out.println("Invalid username or password");
        }
        while (true){
        displayUserMenu();}
    }

    private void displayUserMenu(){
        int type = UserDB.getInstance().checkExistence(userName, password);
        System.out.println("Welcome ");
        System.out.println("1-Transfer");
        System.out.println("2-Pay bills");
        System.out.println("3-Check balance");
        try (Scanner sc = new Scanner(System.in)) {
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Choose Transaction");
                    System.out.println("1. Transfer to Wallet");
                    System.out.println("2. Transfer to Instito Account");
                    if(type==1){
                        System.out.println("3. Transfer to Bank Account");
                    }
                    int transType=sc.nextInt();

                    if(transType==1){
                        Transaction transaction = new WalletTransaction();
                        user.setTransaction(transaction);;
                    }else if (transType==2) {
                        Transaction transaction = new InstitoTransaction();
                        user.setTransaction(transaction);
                    
                    }else if (transType==3 && type==1) {//bank only
                        Transaction transaction = new BankTransaction();
                        user.setTransaction(transaction);;
                    }else{

                        System.out.println("Invalid choice");
                    }

                    user.performTransefer();
                    break;
                case 2:
                    // user.payBills();
                    break;
                case 3:
                    // user.checkBalance();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

    }



}
