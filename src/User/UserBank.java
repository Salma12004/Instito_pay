package User;

import java.util.Scanner;

import APIs.VodafoneCashProvider;
import Application.Validator;

public class UserBank extends User {
    void chooseTransaction(){ 
        System.out.println("Choose Transaction");
        System.out.println("1. Transfer to Wallet");
        System.out.println("2. Transfer to Instito Account");
        System.out.println("3. Transfer to Bank Account");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        if (choice == 1) {
            transferToWallet();
        }
        else if (choice == 2) {
            transferToInstitoAcc();
        }
        else if (choice == 3) {
            transferToBankAcc();
        }
    }
    void transferToWallet(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Wallet Provider");
        System.out.println("1. Vodafone Cash");
        int choice = sc.nextInt();
        System.out.println("Enter the amount you want to transfer");
        double amount = sc.nextDouble();
        System.out.println("Enter the wallet number you want to transfer to");
        String walletNumber = sc.nextLine();
        Validator validator = new Validator();
        while(!validator.checkValidNumber(walletNumber)){
            System.out.println("It is not a valid wallet number, please enter a valid wallet number:");
            walletNumber = sc.nextLine();
        }
        if(choice == 1){
            VodafoneCashProvider vodafoneCashProvider = new VodafoneCashProvider();
            if (vodafoneCashProvider.checkExistence(walletNumber)) {
                vodafoneCashProvider.increaseAmount(amount);
                //decrease amount from bank account
            }
            else{
                System.out.println("This wallet number does not exist");
            }
        }
    }
    void transferToInstitoAcc(){

    }
    void transferToBankAcc(){}
    
}
