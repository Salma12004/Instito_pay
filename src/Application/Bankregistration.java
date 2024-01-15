package Application;
import java.util.Scanner;
import APIs.BankCIB;
import APIs.BankMisr;
import User.User;
import User.UserBank;
import User.UserDB;
/**
 * The Bankregistration class extends the Registration abstract class and provides
 * specific registration logic for users in the context of banking.
 */

public class Bankregistration extends Registration{
    private String creditCard;
    /**
     * Default constructor for the Bankregistration class.
     */
    public Bankregistration() {
        super();
    }
    /**
     * Sets the credit card for the registration, ensuring it is valid.
     *
     * @param creditCard The credit card number to be set.
     */
    public void setCreditCard(String creditCard) {
        while(!validator.checkValidCreditCard(creditCard)){
            System.out.println("It is not a valid credit card number, please enter a valid credit card number:");
            Scanner sc = new Scanner(System.in);
            creditCard = sc.nextLine();
        }
        this.creditCard = creditCard;
    }

    /**
     * Gets the credit card associated with the registration.
     *
     * @return The credit card associated with the registration.
     */
    public String getCreditCard() {
        return creditCard;
    }
    /**
     * Overrides the abstract register method to provide specific registration
     * logic for banking users.
     */
    @Override
    public void register() {
        System.out.println("-----------------Bank registration-----------------");
        Scanner sc = new Scanner(System.in);
            int bankType;
            System.out.println("Choose your bank:");
            System.out.println("1-Bank Misr");
            System.out.println("2-Bank CIB");
            bankType = sc.nextInt();
            while(bankType != 1 && bankType != 2){
                System.out.println("Please enter a valid choice:");
                bankType = sc.nextInt();
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

            System.out.println("Enter credit card number");
            String creditCard = sc.nextLine();
            setCreditCard(creditCard);

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
            if(bankType == 1){
                if(!BankMisr.getInstance().checkExistence(mobileNumber , creditCard)){
                    System.out.println("This user does not exist in this bank");
                }
                else{
                    User BankMisr_User= new UserBank(name,  mobileNumber,  password,  creditCard,  "BankMisr");
                    UserDB.getInstance().addUserBank(name, mobileNumber, password, creditCard, "BankMisr");
                }
            }
            else{
                if(!BankCIB.getInstance().checkExistence(mobileNumber , creditCard)){
                    System.out.println("This user does not exist in this bank");
                }
                else{
                    User BankCIB_User= new UserBank(name,  mobileNumber,  password,  creditCard,  "BankCIB");
                    UserDB.getInstance().addUserBank(name, mobileNumber, password, creditCard, "BankCIB");
                }
            }
            //sc.nextLine();
    }
}
