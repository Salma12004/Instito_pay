package Transaction;
import java.util.Scanner;

import APIs.BankCIB;
import APIs.BankMisr;

import User.User;
import User.UserDB;

/**
 * The BankTransaction class represents a transaction involving a transfer of funds between users and banks.
 * It allows users to transfer money to other users' bank accounts in Bank Misr or Bank CIB.
 */
public class BankTransaction implements Transaction{
    /**
     * Performs a transfer from the user to a bank account in Bank Misr or Bank CIB.
     *
     * @param user The user initiating the transfer.
     */
    public void transfer(User user ){
        System.out.println("Please choose the bank you want to transfer to");
        System.out.println("1- Bank Misr");
        System.out.println("2- Bank CIB");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                transferToBankMisr(user);
                break;
            case 2:
                transferToBankCIB(user);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
    /**
     * Transfers funds from the user to a Bank Misr account.
     *
     * @param user The user initiating the transfer.
     */
    public void transferToBankMisr(User user){
        String creditCard = UserDB.getInstance().getUserInfo(user.getName())[3];
        String bankName = UserDB.getInstance().getUserInfo(user.getName())[4];

        System.out.println("Please enter the mobile number of the user you want to transfer to");
        Scanner sc = new Scanner(System.in);
        String mobileNumber = sc.nextLine();

        System.out.println("Please enter the bank number of the user you want to transfer to");
        Scanner sc1 = new Scanner(System.in);
        String bankNumber = sc1.nextLine();

        if(!BankMisr.getInstance().checkExistence(mobileNumber,bankNumber)){
            System.out.println("This user does not exist in this bank");
        }
        else {
            System.out.println("Please enter the amount you want to transfer");
            double amount = sc.nextDouble();
            BankMisr.getInstance().increaseAmount(bankNumber,amount);
        if (bankName.equals("BankCIB")) {
            BankCIB.getInstance().decreaseAmount(creditCard,amount);
        }
        else{
            BankMisr.getInstance().decreaseAmount(creditCard, amount);
        }
            System.out.println("Transaction successful");
            }
        }
    /**
     * Transfers funds from the user to a Bank CIB account.
     *
     * @param user The user initiating the transfer.
     */
    public void transferToBankCIB(User user){
        String creditCard = UserDB.getInstance().getUserInfo(user.getName())[3];
        String bankName = UserDB.getInstance().getUserInfo(user.getName())[4];
        System.out.println("Please enter the mobile number of the user you want to transfer to");
        Scanner sc = new Scanner(System.in);
        String mobileNumber = sc.nextLine();
        System.out.println("Please enter the bank number of the user you want to transfer to");
        Scanner sc1 = new Scanner(System.in);
        String bankNumber = sc1.nextLine();

        if(!BankCIB.getInstance().checkExistence(mobileNumber,bankNumber)){
            System.out.println("This user does not exist in this bank");
        }
        else {
            System.out.println("Please enter the amount you want to transfer");
            double amount = sc.nextDouble();
            BankCIB.getInstance().increaseAmount(bankNumber,amount);
        if (bankName.equals("BankCIB")) {
            BankCIB.getInstance().decreaseAmount(creditCard,amount);
        }
        else{
            BankMisr.getInstance().decreaseAmount(creditCard, amount);
        }
            System.out.println("Transaction successful");
        }
    }
}