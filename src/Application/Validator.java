package Application;
import java.util.regex.Pattern;
import java.util.Random;
import java.util.Scanner;

public class Validator {
    // public Boolean uniqueName(String name){

    // }

    public Boolean checkStrongPassword(String password){
        Pattern validPasswordPattern = Pattern.compile("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~])[a-zA-Z0-9#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~]{8,12}");
        return validPasswordPattern.matcher(password).matches();   
    }

    public int sentOTP(){
        Random random = new Random();
        return random.nextInt(999999);
    }
    
    public Boolean enterOTP(int OTP){
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the OTP sent to your mobile number");
            int enteredOTP = sc.nextInt();
            return OTP == enteredOTP;
        }
    }
    
    public Boolean checkValidNumber(String mobileNumber){
        Pattern validMobileNumberPattern = Pattern.compile("[0-9]{11}");
        return validMobileNumberPattern.matcher(mobileNumber).matches();
    }
    
    public Boolean checkValidCreditCard(String creditCard){
        Pattern validCreditCardPattern = Pattern.compile("[0-9]{16}");
        return validCreditCardPattern.matcher(creditCard).matches();
    }

}
