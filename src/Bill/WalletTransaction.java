package Bill;
import java.util.Scanner;
import APIs.VodafoneCashProvider;
import APIs.EtisalatCashProvider;
import User.User;


public class WalletTransaction implements Transaction {
    public void transfer(User user){
        System.out.println("Please choose the wallet you want to transfer to");
        System.out.println("1- Vodafone Cash");
        System.out.println("2- Etisalat Cash");
        try (Scanner sc = new Scanner(System.in)) {
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
    }
    private void transferToVodafone(User user){
        System.out.println("Please enter the mobile number you want to transfer to");
        try (Scanner sc = new Scanner(System.in)) {
            String mobileNumber = sc.nextLine();
            if(!VodafoneCashProvider.getInstance().checkExistence(mobileNumber)){
                    System.out.println("This user does not exist in this Wallet");
            }
            else {
                System.out.println("Please enter the amount you want to transfer");
                double amount = sc.nextDouble();
                VodafoneCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                VodafoneCashProvider.getInstance().decreaseAmount(user.getmobileNumber(), amount);
                System.out.println("Transaction successful");
            }
        }
    }
    private void transferToEtisalat(User user){
        System.out.println("Please enter the mobile number you want to transfer to");
        try (Scanner sc = new Scanner(System.in)) {
            String mobileNumber = sc.nextLine();
            if(!EtisalatCashProvider.getInstance().checkExistence(mobileNumber)){
                    System.out.println("This user does not exist in this Wallet");
            }
            else {
                System.out.println("Please enter the amount you want to transfer");
                double amount = sc.nextDouble();
                EtisalatCashProvider.getInstance().increaseAmount(mobileNumber, amount);
                EtisalatCashProvider.getInstance().decreaseAmount(user.getmobileNumber(), amount);
                System.out.println("Transaction successful");
            }
        }
    }
}
