package Application;
import java.util.Scanner;
import java.util.*;

public class WalletRegistration extends Registration{

    public WalletRegistration() {
        super();
    }

    @Override
    public void register() {
        System.out.println("-----------------Wallet registration-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();

        System.out.println("Enter mobile number");
        String mobileNumber = sc.nextLine();

        while(!validator.checkValidNumber(mobileNumber)){
            System.out.println("It is not a valid mobile number, please enter a valid mobile number:");
            mobileNumber = sc.nextLine();
        }
        
        System.out.println("Enter a strong password:");
        System.out.println(" Here is a format of strong password: ");
        System.out.println("1-Is at least 8 characters long and 12 max.\n2-Must include at least one uppercase and at least one lowercase letters\n3-Must include numbers and special symbols:");
        String password = sc.nextLine();
        while(!validator.checkStrongPassword(password)){
            System.out.println("It is not a strong password, please enter a strong password:");
            password = sc.nextLine();
        }
        //check validation of credit card
        //then if true we send otp to check mobile number

    }
}
