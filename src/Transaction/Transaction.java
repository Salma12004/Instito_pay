package Transaction;
import User.User;

/**
 * The Transaction interface provides a contract for implementing different types of transactions.
 */
public interface Transaction {

    /**
     * Performs a transfer as part of the specific transaction type.
     *
     * @param user The user involved in the transaction.
     */
    public void transfer(User user);
}
