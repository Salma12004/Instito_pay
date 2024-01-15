package APIs;

import java.util.ArrayList;
import java.util.List;
/**
 * The VodafoneCashProvider class implements the WalletProvider interface,
 * representing a specific implementation for managing Vodafone Cash wallet accounts.
 */
public class VodafoneCashProvider implements WalletProvider{
    //singletone
    private static  VodafoneCashProvider instance;
    /**
     * Gets the singleton instance of the VodafoneCashProvider class.
     *
     * @return The VodafoneCashProvider instance.
     */
    public static VodafoneCashProvider getInstance() {
        if (instance == null) {
            instance = new VodafoneCashProvider();
        }
        return instance;
    }

    List<String> VodafoneCashUsers =  new ArrayList<String>();
    
    /**
     * Constructs a new VodafoneCashProvider instance and initializes it with some
     * sample Vodafone Cash user accounts.
     */
    public VodafoneCashProvider() {
        VodafoneCashUsers.add("01005182020 50000");
        VodafoneCashUsers.add("01002502010 10000");
        VodafoneCashUsers.add("01002501223 20000");
        VodafoneCashUsers.add("01002509990 30000");
        VodafoneCashUsers.add("01002204090 40000");
    }

    /**
     * Retrieves the current amount in the specified Vodafone Cash wallet account
     * associated with the provided mobile number.
     *
     * @param mobileNumber The mobile number associated with the wallet account.
     * @return The current amount in the account, or -1 if the user is not found.
     */
    public double getAmount(String mobileNumber){
        String searchString = mobileNumber.trim();
        int index = -1;
        for (int i = 0; i < VodafoneCashUsers.size(); i++) {
            if (VodafoneCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = VodafoneCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            return currentAmount;
        } 
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
            return -1;
        }
    }
    /**
     * Checks the existence of a Vodafone Cash wallet account based on the provided
     * mobile number.
     *
     * @param mobileNumber The mobile number associated with the wallet account.
     * @return true if the account exists, false otherwise.
     */
    public Boolean checkExistence(String mobileNumber) {
        String key = mobileNumber.trim();
        for (String user : VodafoneCashUsers) {
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Decreases the amount in the specified Vodafone Cash wallet account associated
     * with the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be deducted from the account.
     */
    public void decreaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < VodafoneCashUsers.size(); i++) {
            if (VodafoneCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = VodafoneCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                VodafoneCashUsers.set(index, arr[0] + " " + currentAmount);
            } else {
                System.out.println("Insufficient funds.");
            }
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    /**
     * Increases the amount in the specified Vodafone Cash wallet account associated
     * with the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be added to the account.
     */
    public void increaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < VodafoneCashUsers.size(); i++) {
            if (VodafoneCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = VodafoneCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            currentAmount += amount;
            VodafoneCashUsers.set(index, arr[0] + " " + currentAmount);
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    } 
    public void print() {
        for (String user : VodafoneCashUsers) {
            System.out.println(user);
        }
    }  
    
}
