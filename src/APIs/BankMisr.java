package APIs;

import java.util.ArrayList;
import java.util.List;

/**
 * The BankMisr class represents a concrete implementation of the Bank interface
 * specific to the Bank of Egypt (Bank Misr), providing methods to manage bank
 * accounts and perform transactions.
 */
public class BankMisr implements Bank {
    private static  BankMisr instance;
    static List<String> BankMisrUsers =  new ArrayList<String>();
     /**
     * Constructs a new BankMisr instance and initializes it with some sample user accounts.
     * This method is also responsible for ensuring that only one instance of BankMisr is created.
     *
     * @return The BankMisr instance.
     */
    public static BankMisr getInstance() {
        BankMisrUsers.add("01005181038 1234567891234567 50000");
        BankMisrUsers.add("01112509992 2345678912345670 10000");
        BankMisrUsers.add("01112501234 3456791234567120 20000");
        BankMisrUsers.add("01002509992 4567912345671230 30000");
        BankMisrUsers.add("01002501234 5679123456712340 40000");
        if (instance == null) {
            instance = new BankMisr();
        }
        return instance;
    }
    /**
     * Retrieves the current amount in the specified bank account associated with
     * the provided credit card.
     *
     * @param creditcard The credit card number associated with the bank account.
     * @return The current amount in the account, or -1 if the user is not found.
     */
    public double getAmount(String creditcard){
        String searchString = creditcard.trim();
        int index = -1;
        for (int i = 0; i < BankMisrUsers.size(); i++) {
            if (BankMisrUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankMisrUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            return currentAmount;
        } 
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
            return -1;
        }
    }
    /**
     * Checks the existence of a bank account based on the provided mobile number
     * and credit card information.
     *
     * @param mobileNumber The mobile number associated with the bank account.
     * @param creditCard   The credit card number associated with the bank account.
     * @return true if the account exists, false otherwise.
     */
    public Boolean checkExistence(String mobileNumber, String creditCard) {
        String key = mobileNumber.trim() + " " + creditCard.trim();
        for (String user : BankMisrUsers) {
            // Check if the user contains the provided mobileNumber and creditCard
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }

     /**
     * Decreases the amount in the specified bank account associated with the
     * provided credit card by the given amount.
     *
     * @param creditCard The credit card number associated with the bank account.
     * @param amount     The amount to be deducted from the account.
     */
    public void decreaseAmount(String creditCard, double amount) {
        String searchString = creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankMisrUsers.size(); i++) {
            if (BankMisrUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankMisrUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                BankMisrUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
            } 
            else {
                System.out.println("Insufficient funds.");
            }
        } 
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    /**
     * Increases the amount in the specified bank account associated with the
     * provided credit card by the given amount.
     *
     * @param creditCard The credit card number associated with the bank account.
     * @param amount     The amount to be added to the account.
     */
    public void increaseAmount(String creditCard, double amount) {
        String searchString = creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankMisrUsers.size(); i++) {
            if (BankMisrUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankMisrUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            currentAmount += amount;
            BankMisrUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
        } 
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    
    public void print(){
        for (String string : BankMisrUsers) {
            System.out.println(string);
        }
    }
}
