package APIs;
/**
 * The WalletProvider interface defines methods for managing wallet accounts,
 * including checking existence, decreasing and increasing amounts, retrieving
 * the current amount, and printing account details.
 */
public interface WalletProvider {

    /**
     * Checks the existence of a wallet account based on the provided mobile number.
     *
     * @param mobileNumber The mobile number associated with the wallet account.
     * @return true if the account exists, false otherwise.
     */
    public Boolean checkExistence(String mobileNumber);

    /**
     * Decreases the amount in the specified wallet account associated with
     * the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be deducted from the account.
     */
    public void decreaseAmount(String number, double amount);

    /**
     * Increases the amount in the specified wallet account associated with
     * the provided mobile number by the given amount.
     *
     * @param number The mobile number associated with the wallet account.
     * @param amount The amount to be added to the account.
     */
    public void increaseAmount(String number, double amount);

    /**
     * Retrieves the current amount in the specified wallet account associated with
     * the provided mobile number.
     *
     * @param mobile The mobile number associated with the wallet account.
     * @return The current amount in the account.
     */
    public double getAmount(String mobile);

//     /**
//      * Prints details of the wallet account. The format and content of the printout
//      * may vary based on the implementation.
//      */
    public void print();
}