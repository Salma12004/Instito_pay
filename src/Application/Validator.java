package Application;
import java.util.regex.Pattern;

import User.UserDB;

import java.util.Random;
import java.util.Scanner;
/**
 * The Validator class provides methods for validating user inputs and generating OTP.
 */
public class Validator {
    /**
     * Checks if the provided name is unique.
     *
     * @param name The name to be checked for uniqueness.
     * @return True if the name is unique, false otherwise.
     */
    public Boolean checkuniqueName(String name){
        return UserDB.getInstance().uniqueName(name);
    }
    /**
     * Checks if the provided password meets the criteria for a strong password.
     *
     * @param password The password to be checked.
     * @return True if the password is strong, false otherwise.
     */
    public Boolean checkStrongPassword(String password){
        Pattern validPasswordPattern = Pattern.compile("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~])[a-zA-Z0-9#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~]{8,12}");
        return validPasswordPattern.matcher(password).matches();   
    }
    /**
     * Generates and returns a random OTP (One-Time Password).
     *
     * @return The randomly generated OTP.
     */
    public int sentOTP(){
        Random random = new Random();
        return random.nextInt(999999);
    }
    /**
     * Validates the entered OTP against the provided OTP.
     *
     * @param OTP The OTP sent to the user.
     * @return True if the entered OTP is correct, false otherwise.
     */
    public Boolean enterOTP(int OTP){
       // try (Scanner sc = new Scanner(System.in)) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the OTP sent to your mobile number");
            int enteredOTP = sc.nextInt();
            sc.nextLine();
            return OTP == enteredOTP;
       // }
    }
    /**
     * Checks if the provided mobile number is valid.
     *
     * @param mobileNumber The mobile number to be checked.
     * @return True if the mobile number is valid, false otherwise.
     */
    public Boolean checkValidNumber(String mobileNumber){
        Pattern validMobileNumberPattern = Pattern.compile("[0-9]{11}");
        return validMobileNumberPattern.matcher(mobileNumber).matches();
    }
    /**
     * Checks if the provided credit card number is valid.
     *
     * @param creditCard The credit card number to be checked.
     * @return True if the credit card number is valid, false otherwise.
     */
    public Boolean checkValidCreditCard(String creditCard){
        Pattern validCreditCardPattern = Pattern.compile("[0-9]{16}");
        return validCreditCardPattern.matcher(creditCard).matches();
    }
}
