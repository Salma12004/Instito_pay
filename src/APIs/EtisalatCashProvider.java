package APIs;
import java.util.ArrayList;
import java.util.List;

/**
 * The EtisalatCashProvider class implements the WalletProvider interface,
 * representing a specific implementation for managing Etisalat Cash wallet accounts.
 */
public class EtisalatCashProvider implements WalletProvider{

    private static  EtisalatCashProvider instance;
   /**
     * Gets the singleton instance of the EtisalatCashProvider class.
     *
     * @return The EtisalatCashProvider instance.
     */
    public static EtisalatCashProvider getInstance() {
        if (instance == null) {
            instance = new EtisalatCashProvider();
        }
        return instance;
    }
    
    List<String> EtisalatCashUsers =  new ArrayList<String>();
     /**
     * Constructs a new EtisalatCashProvider instance and initializes it with some
     * sample Etisalat Cash user accounts.
     */
    public EtisalatCashProvider() {
        EtisalatCashUsers.add("01105182020 50000");
        EtisalatCashUsers.add("01112502010 10000");
        EtisalatCashUsers.add("01102501223 20000");
        EtisalatCashUsers.add("01112509990 30000");
        EtisalatCashUsers.add("01122204090 40000");
    }
    /**
     * Checks the existence of an Etisalat Cash wallet account based on the provided
     * mobile number.
     *
     * @param mobileNumber The mobile number associated with the wallet account.
     * @return true if the account exists, false otherwise.
     */
    public Boolean checkExistence(String mobileNumber) {
        String key = mobileNumber.trim();
        for (String user : EtisalatCashUsers) {
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Decreases the amount in the specified Etisalat Cash wallet account associated
     * with the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be deducted from the account.
     */
    public void decreaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < EtisalatCashUsers.size(); i++) {
            if (EtisalatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtisalatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                EtisalatCashUsers.set(index, arr[0] + " " + currentAmount);
            } else {
                System.out.println("Insufficient funds.");
            }
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    /**
     * Increases the amount in the specified Etisalat Cash wallet account associated
     * with the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be added to the account.
     */

    public void increaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < EtisalatCashUsers.size(); i++) {
            if (EtisalatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtisalatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            currentAmount += amount;
            EtisalatCashUsers.set(index, arr[0] + " " + currentAmount);
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    } 
    /**
     * Retrieves the current amount in the specified Etisalat Cash wallet account
     * associated with the provided mobile number.
     *
     * @param mobile The mobile number associated with the wallet account.
     * @return The current amount in the account, or 0 if the user is not found.
     */
    public double getAmount(String mobile){
        String searchString = mobile.trim();
        int index = -1;
        for (int i = 0; i < EtisalatCashUsers.size(); i++) {
            if (EtisalatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtisalatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            return currentAmount;
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
            return 0;
        }
    }
    public void print() {
        for (String user : EtisalatCashUsers) {
            System.out.println(user);
        }
    }
}
