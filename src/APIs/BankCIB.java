package APIs;

import java.util.ArrayList;
import java.util.List;

/**
 * The BankCIB class represents a concrete implementation of the Bank interface,
 * providing methods to manage bank accounts and perform transactions.
 */
public class BankCIB implements Bank{
    private static  BankCIB instance;
    List<String> BankCIBUsers =  new ArrayList<String>();
     /**
     * Constructs a new BankCIB instance and initializes it with some sample user accounts.
     */
    public BankCIB() {
        BankCIBUsers.add("01000401038 1134567891234567 90000");
        BankCIBUsers.add("01012345678 1045678912345670 80000");
        BankCIBUsers.add("01143332642 9456791234567120 10000");
        BankCIBUsers.add("01149677992 8567912345671230 70000");
        BankCIBUsers.add("01141114798 7679123456712340 30000");
    }
    /**
     * Gets the singleton instance of the BankCIB class.
     *
     * @return The BankCIB instance.
     */
    public static BankCIB getInstance() {
        if (instance == null) {
            instance = new BankCIB();
        }
        return instance;
    }
    /**
     * Retrieves the current amount in the specified bank account associated with
     * the provided credit card.
     *
     * @param credit The credit card number associated with the bank account.
     * @return The current amount in the account, or -1 if the user is not found.
     */
    public double getAmount(String credit){
        String searchString = credit.trim();
        int index = -1;
        for (int i = 0; i < BankCIBUsers.size(); i++) {
            if (BankCIBUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankCIBUsers.get(index).split(" ");
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
    public Boolean checkExistence( String mobileNumber , String creditCard) {
        String key = mobileNumber.trim() + " " + creditCard.trim();
        for (String user : BankCIBUsers) {
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
        String searchString =creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankCIBUsers.size(); i++) {
            if (BankCIBUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            String[] arr = BankCIBUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                BankCIBUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
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
        for (int i = 0; i < BankCIBUsers.size(); i++) {
            if (BankCIBUsers.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankCIBUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            currentAmount += amount;
            BankCIBUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
        } else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }

        
    }
    public void print(){
        for (String string : BankCIBUsers) {
            System.out.println(string);
        }
    }
    
}
