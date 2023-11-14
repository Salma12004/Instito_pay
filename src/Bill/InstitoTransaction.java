package Bill;

import java.util.Scanner;

import User.User;
import User.UserDB;

public class InstitoTransaction implements Transaction{
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
            if (typeReciever == 1) {
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
            if(typeReciever == 1){
                System.out.println("You can not transfer to this user");
            }
            else if (typeReciever == 2) {
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

