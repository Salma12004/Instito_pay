package Application;
import java.util.Scanner;
import APIs.BankCIB;
import APIs.BankMisr;
import User.User;
import User.UserBank;
import User.UserDB;

public class Bankregistration extends Registration{
    private String creditCard;

    public Bankregistration() {
        super();
    }

    public void setCreditCard(String creditCard) {
        while(!validator.checkValidCreditCard(creditCard)){
            System.out.println("It is not a valid credit card number, please enter a valid credit card number:");
            creditCard = System.console().readLine();
        }
        this.creditCard = creditCard;
    }


    public String getCreditCard() {
        return creditCard;
    }

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
    }
}
