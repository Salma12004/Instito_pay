package User;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * The UserDB class manages user data for bank and wallet users.
 */
public class UserDB {
    List<String> usersBankDB =  new ArrayList<String>();
    List<String> usersWalletDB =  new ArrayList<String>();

    //singleton
    private static UserDB instance;
    /**
     * Gets the singleton instance of UserDB.
     *
     * @return The singleton instance.
     */
    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    /**
     * Adds a bank user to the database.
     *
     * @param name       The name of the user.
     * @param mobileNumber The mobile number of the user.
     * @param password   The password of the user.
     * @param creditCard The credit card associated with the user.
     * @param bankName   The name of the bank.
     */
    public void addUserBank(String name, String mobileNumber, String password, String creditCard, String bankName ){
        usersBankDB.add(name + " " + mobileNumber + " " + password + " " + creditCard + " " + bankName + " " );
    }
    /**
     * Adds a wallet user to the database.
     *
     * @param name       The name of the user.
     * @param mobileNumber The mobile number of the user.
     * @param password   The password of the user.
     * @param walletName The name of the wallet associated with the user.
     */
    public void addUserWallet(String name, String mobileNumber, String password, String walletName ){
        usersWalletDB.add(name + " " + mobileNumber + " " + password + " " + walletName + " " );
    }
    /**
     * Checks the existence of a user by their username.
     *
     * @param userName The username to check.
     * @return 1 if the user is a bank user, 2 if the user is a wallet user, 0 if not found.
     */
    public int checkExistence(String userName){
        for (String user : usersBankDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return 1;
            }
        }
        for (String user : usersWalletDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return 2;
            }
        }
        return 0;
    }
    /**
     * Gets user information based on their username.
     *
     * @param userName The username to retrieve information for.
     * @return An array containing user information.
     */
    public String[] getUserInfo(String userName){
        for (String user : usersBankDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return userArr;
            }
        }
        for (String user : usersWalletDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return userArr;
            }
        }
        return null;
        
    }

    /**
     * Checks if a username is unique.
     *
     * @param name The username to check.
     * @return True if the username is unique, false otherwise.
     */
    public Boolean uniqueName(String name){
        Pattern validNamePattern = Pattern.compile("[a-zA-Z]{3,}");
        if (validNamePattern.matcher(name).matches()) {
            for (String user : usersBankDB) {
                String[] userArr = user.split(" ");
                if(userArr[0].equals(name)){
                    return false;
                }
            }
            for (String user : usersWalletDB) {
                String[] userArr = user.split(" ");
                if(userArr[0].equals(name)){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Prints bank users in the database.
     */
    public void printBankUsers(){
        for (String user : usersBankDB) {
            System.out.println(user);
        }
    }
    /**
     * Prints wallet users in the database.
     */
    public void printWalletUsers(){
        for (String user : usersWalletDB) {
            System.out.println(user);
        }
    }
}
