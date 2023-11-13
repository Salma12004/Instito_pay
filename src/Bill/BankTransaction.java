package Bill;
import java.util.Scanner;

import APIs.BankCIB;
import APIs.BankMisr;

import User.User;


public class BankTransaction implements Transaction{
    public void transfer(User user){
        System.out.println("Please choose the bank you want to transfer to");
        System.out.println("1- Bank Misr");
        System.out.println("2- Bank CIB");
        try (Scanner sc = new Scanner(System.in)) {
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
    }
    private void transferToBankMisr(User user){

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
            BankMisr.getInstance().decreaseAmount(user.getCreditCard(), amount);
            System.out.println("Transaction successful");
            }
        }
    
    private void transferToBankCIB(User user){
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
            BankCIB.getInstance().increaseAmount(bankNumber,amount);
            BankCIB.getInstance().decreaseAmount(user.getCreditCard(), amount);
            System.out.println("Transaction successful");
            }
    }


}