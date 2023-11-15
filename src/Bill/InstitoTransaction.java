package Bill;

import java.util.Scanner;

import User.User;
import User.UserDB;
/**
 * The InstitoTransaction class represents a transaction involving the transfer of funds between users within the InstitoPay system.
 * It allows users to transfer money to other users' bank accounts in Bank Misr or Bank CIB,
 * as well as to wallet providers Vodafone Cash and Etisalat Cash.
 */
public class InstitoTransaction implements Transaction{
    /**
     * Performs a transfer from the instito acc to another instito acc .
     *
     * @param user The user initiating the transfer.
     */
    public void transfer(User user)
    {
        System.out.println("Please enter the name of the user you want to transfer to");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int typeReciever = UserDB.getInstance().checkExistence(name);
        int typeUser = UserDB.getInstance().checkExistence(user.getName());
        if (typeReciever == 0) {
            System.out.println("User does not exist");
        }
        if (typeUser == 1){
            // User initiating the transfer is a bank user
            if (typeReciever == 1) {
                // Transfer to another bank user
                BankTransaction bankTransaction = new BankTransaction();
                String recieverBankName = UserDB.getInstance().getUserInfo(name)[4];
                if (recieverBankName.equals("BankMisr")) {
                    bankTransaction.transferToBankMisr(user);
                }
                else if (recieverBankName.equals("BankCIB")) {
                    bankTransaction.transferToBankCIB(user);
                }
            }
            else if (typeReciever == 2) {
                // Transfer to a wallet user
                WalletTransaction walletTransaction = new WalletTransaction();
                String recieverWalletName = UserDB.getInstance().getUserInfo(name)[3];
                if (recieverWalletName.equals("VodafoneCash")) {
                    walletTransaction.transferToVodafone(user);
                }
                else if (recieverWalletName.equals("EtisalatCash")) {
                    walletTransaction.transferToEtisalat(user);
                }
            }
        }
        else if (typeUser == 2) {
            // User initiating the transfer is a wallet user
            if(typeReciever == 1){
                // Wallet users cannot transfer to bank users
                System.out.println("You can not transfer to this user");
            }
            else if (typeReciever == 2) {
                // Transfer between wallet users
                WalletTransaction walletTransaction = new WalletTransaction();
                String recieverWalletName = UserDB.getInstance().getUserInfo(name)[3];
                if (recieverWalletName.equals("VodafoneCash")) {
                    walletTransaction.transferToVodafone(user);
                }
                else if (recieverWalletName.equals("EtisalatCash")) {
                    walletTransaction.transferToEtisalat(user);
                }
            }   
        }
    }
}

