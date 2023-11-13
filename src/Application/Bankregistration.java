package Application;
import java.util.Scanner;
import APIs.BankCIB;
import APIs.BankMisr;
import User.User;
import User.UserBank;
import User.UserDB;

import java.util.Scanner;


public class Bankregistration extends Registration{
    private String creditCard;

    public Bankregistration() {
        super();
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public String getCreditCard() {
        return creditCard;
    }

    @Override
    public void register() {
        System.out.println("-----------------Bank registration-----------------");
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

        int choice;
        System.out.println("Choose your bank:");
        System.out.println("1-Bank Misr");
        System.out.println("2-Bank CIB");
        choice = sc.nextInt();
        while(choice != 1 && choice != 2){
            System.out.println("Please enter a valid choice:");
            choice = sc.nextInt();
        }
        sc.nextLine();

        System.out.println("Enter credit card number");
        String creditCard = sc.nextLine();
        while(!validator.checkValidCreditCard(creditCard)){
            System.out.println("It is not a valid credit card number, please enter a valid credit card number:");
            creditCard = sc.nextLine();
        }

        // Validator validator = new Validator();
        int OTP = validator.sentOTP();
        if(!validator.enterOTP(OTP)){
            System.out.println("Invalid OTP");
        }
        else{
            if(choice == 1){
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
}
