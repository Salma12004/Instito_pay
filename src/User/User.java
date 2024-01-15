package User;
import Transaction.Transaction;
/**
 * The User class represents a user in the system.
 */
public abstract class User {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected Transaction transaction;

    /**
     * Constructs a new User with the specified name, mobile number, and password.
     *
     * @param name         The name of the user.
     * @param mobileNumber The mobile number of the user.
     * @param password     The password of the user.
     */
    public User(String name, String mobileNumber, String password ) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
    /**
     * Sets the transaction for the user.
     *
     * @param transaction The transaction to be set.
     */
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    /**
     * Performs a transfer using the assigned transaction.
     */
    public void performTransefer() {
        transaction.transfer(this);
    }
    /**
     * Gets the mobile number of the user.
     *
     * @return The mobile number of the user.
     */
    public String getmobileNumber() {
        return mobileNumber;
    }
    /**
     * Gets the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }
    /**
     * Abstract method to get the balance of the user.
     *
     * @return The balance of the user.
     */
    public abstract double getBalance();
    /**
     * Abstract method to pay bills.
     */
    public abstract void payBills();
    
}
