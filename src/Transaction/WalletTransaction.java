package Transaction;import java.util.Scanner;

import APIs.BankCIB;
import APIs.BankMisr;
import APIs.VodafoneCashProvider;
import APIs.EtisalatCashProvider;
import User.User;
import User.UserDB;

/**
 * The WalletTransaction class represents a transaction involving the transfer of funds between users' wallet providers 
 * (Vodafone Cash and Etisalat Cash).
 */
public class WalletTransaction implements Transaction {
    /**
     * Initiates the transfer process by prompting the user to choose the wallet provider (Vodafone Cash or Etisalat Cash).
     *
     * @param user The user initiating the transfer.
     */
    public void transfer(User user){
        System.out.println("Please choose the wallet you want to transfer to");
        System.out.println("1- Vodafone Cash");
        System.out.println("2- Etisalat Cash");
        Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    transferToVodafone(user);
                    break;
                case 2:
                    transferToEtisalat(user);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
    }
    /**
     * Transfers funds from the user's wallet to a Vodafone Cash account.
     *
     * @param user The user initiating the transfer.
     */
    public void transferToVodafone(User user) {
        int type = UserDB.getInstance().checkExistence(user.getName());
        if (type == 1) {
            System.out.println("Please enter the mobile number you want to transfer to");
            Scanner sc = new Scanner(System.in);
            String mobileNumber = sc.nextLine();
            if (!VodafoneCashProvider.getInstance().checkExistence(mobileNumber)) {
                System.out.println("This user does not exist in this Wallet");
            } else {
                System.out.println("Please enter the amount you want to transfer");
                double amount = sc.nextDouble();
                VodafoneCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                String bankName = UserDB.getInstance().getUserInfo(user.getName())[4];
                String credit = UserDB.getInstance().getUserInfo(user.getName())[3];
                if (bankName.equals("BankMisr")) {
                    BankMisr.getInstance().decreaseAmount(credit, amount);
                } else {
                    BankCIB.getInstance().decreaseAmount(credit, amount);
                }
                System.out.println("Transaction successful");
            }
        }
        if (type == 2) {
            String WalletName = UserDB.getInstance().getUserInfo(user.getName())[3];
            if (WalletName.equals("VodafoneCash")) {
                System.out.println("Please enter the mobile number you want to transfer to");
                Scanner sc = new Scanner(System.in);
                String mobileNumber = sc.nextLine();
                if (!VodafoneCashProvider.getInstance().checkExistence(mobileNumber)) {
                    System.out.println("This user does not exist in this Wallet");
                } else {
                    System.out.println("Please enter the amount you want to transfer");
                    double amount = sc.nextDouble();
                    VodafoneCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                    VodafoneCashProvider.getInstance().decreaseAmount(user.getmobileNumber(), amount);
                    System.out.println("Transaction successful");
                }
            } else {
                System.out.println("You can not transfer to this wallet");
            }
        }
    }
    /**
     * Transfers funds from the user's wallet to an Etisalat Cash account.
     *
     * @param user The user initiating the transfer.
     */
    public void transferToEtisalat(User user) {
        int type = UserDB.getInstance().checkExistence(user.getName());
        if (type == 1) {
            System.out.println("Please enter the mobile number you want to transfer to");
            Scanner sc = new Scanner(System.in);
            String mobileNumber = sc.nextLine();
            if (!EtisalatCashProvider.getInstance().checkExistence(mobileNumber)) {
                System.out.println("This user does not exist in this Wallet");
            } else {
                System.out.println("Please enter the amount you want to transfer");
                double amount = sc.nextDouble();
                EtisalatCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                String bankName = UserDB.getInstance().getUserInfo(user.getName())[4];
                String credit = UserDB.getInstance().getUserInfo(user.getName())[3];
                if (bankName.equals("BankMisr")) {
                    BankMisr.getInstance().decreaseAmount(credit, amount);
                } else {
                    BankCIB.getInstance().decreaseAmount(credit, amount);
                }
                System.out.println("Transaction successful");
            }

        }
        if (type == 2) {
            String WalletName = UserDB.getInstance().getUserInfo(user.getName())[3];
            if (WalletName.equals("EtisalatCash")) {
                System.out.println("Please enter the mobile number you want to transfer to");
                Scanner sc = new Scanner(System.in);
                String mobileNumber = sc.nextLine();
                if (!EtisalatCashProvider.getInstance().checkExistence(mobileNumber)) {
                    System.out.println("This user does not exist in this Wallet");
                } else {
                    System.out.println("Please enter the amount you want to transfer");
                    double amount = sc.nextDouble();
                    EtisalatCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                    EtisalatCashProvider.getInstance().decreaseAmount(user.getmobileNumber(), amount);
                    System.out.println("Transaction successful");
                }
            } else {
                System.out.println("You can not transfer to this wallet");
            }
        }
    }
}

