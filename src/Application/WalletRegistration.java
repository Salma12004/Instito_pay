package Application;
import java.util.Scanner;
import APIs.EtisalatCashProvider;
import APIs.VodafoneCashProvider;
import User.UserDB;


public class WalletRegistration extends Registration{

    public WalletRegistration() {
        super();
    }

    @Override
    public void register() {
        System.out.println("-----------------Wallet registration-----------------");
        Scanner sc = new Scanner(System.in);
            int walletType;
            System.out.println("Choose your Wallet:");
            System.out.println("1-Vodafone Cash");
            System.out.println("2-Etisalat Cash");
            walletType = sc.nextInt();
            while(walletType != 1 && walletType != 2){
                System.out.println("Please enter a valid choice:");
                walletType = sc.nextInt();
            }
            sc.nextLine();
            System.out.println("Enter name");
            String name = sc.nextLine();
            setName(name);
            System.out.println("Enter mobile number");
            String mobileNumber = sc.nextLine();
            setMobileNumber(mobileNumber);

            System.out.println("Enter a strong password:");
            System.out.println(" Here is a format of strong password: ");
            System.out.println("1-Is at least 8 characters long and 12 max.\n2-Must include at least one uppercase and at least one lowercase letters\n3-Must include numbers and special symbols:");
            String password = sc.nextLine();
            setPassword(password);

            int OTP = validator.sentOTP();
            System.out.println("OTP: " + OTP);
            int cnt=0;
            while(cnt<3 && !validator.enterOTP(OTP)){
                System.out.println("Invalid OTP");
                OTP = validator.sentOTP();
                System.out.println("OTP: " + OTP);
                cnt++;
            }

            if(cnt==3 && !validator.enterOTP(OTP)){
                System.out.println("You have entered the wrong OTP 3 times, please try again later");
                return;
            }
            if(walletType == 1){
                if(!VodafoneCashProvider.getInstance().checkExistence(mobileNumber)){
                    System.out.println("This user does not exist in this Wallet");
                }
                else{
                    UserDB.getInstance().addUserWallet(name, mobileNumber, password, "VodafoneCash");
                }
            }
            else{
                if(!EtisalatCashProvider.getInstance().checkExistence(mobileNumber)){
                    System.out.println("This user does not exist in this Wallet");
                }
                else{
                    UserDB.getInstance().addUserWallet(name, mobileNumber, password, "EtisalatCash");
                }
            }

    }
}
