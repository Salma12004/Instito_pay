/**
 * The Bank interface represents a basic banking system with methods for checking
 * account existence, decreasing and increasing amounts, retrieving the current
 * amount, and printing account details.
 */
package APIs;

public interface Bank {

    /**
     * Checks the existence of a bank account based on the provided mobile number
     * and credit card information.
     *
     * @param mobileNumber The mobile number associated with the bank account.
     * @param creditCard   The credit card number associated with the bank account.
     * @return true if the account exists, false otherwise.
     */
    public Boolean checkExistence(String mobileNumber, String creditCard);

    /**
     * Decreases the amount in the specified bank account associated with the
     * provided credit card by the given amount.
     *
     * @param creditCard The credit card number associated with the bank account.
     * @param amount     The amount to be deducted from the account.
     */
    public void decreaseAmount(String creditCard, double amount);

    /**
     * Increases the amount in the specified bank account associated with the
     * provided credit card by the given amount.
     *
     * @param creditCard The credit card number associated with the bank account.
     * @param amount     The amount to be added to the account.
     */
    public void increaseAmount(String creditCard, double amount);

    /**
     * Retrieves the current amount in the specified bank account associated with
     * the provided credit card.
     *
     * @param creditCard The credit card number associated with the bank account.
     * @return The current amount in the account.
     */
    public double getAmount(String creditCard);

    /**
     * Prints details of the bank account. The format and content of the printout
     * may vary based on the implementation.
    */
    public void print();
}
