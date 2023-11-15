package User;
import java.util.Scanner;
import APIs.BankCIB;
import APIs.BankMisr;
import PayBills.*;

/**
 * The UserBank class represents a user with a bank account.
 */
public class UserBank extends User {

    private String creditCard;
    private String bankName;

    /**
     * Constructs a new UserBank with the specified name, mobile number, password, credit card, and bank name.
     *
     * @param name        The name of the user.
     * @param mobileNumber The mobile number of the user.
     * @param password    The password of the user.
     * @param creditCard  The credit card associated with the user.
     * @param bankName    The name of the bank associated with the user.
     */
    public UserBank( String name, String mobileNumber, String password, String creditCard, String bankName ) {
        super(name,mobileNumber,password);
        this.bankName = bankName;
        this.creditCard = creditCard;
    }
    /**
     * Gets the bank name associated with the user.
     *
     * @return The bank name.
     */
    public String getBankName(){
        return bankName;
    }
    /**
     * Gets the credit card associated with the user.
     *
     * @return The credit card.
     */
    public String getCreditCard(){
        return creditCard;
    }
    /**
     * Pays bills for the user, allowing them to choose the type of bill.
     */
    public void payBills()
    {
        System.out.println("Choose the bill type");
        System.out.println("1. Electricity Bill");
        System.out.println("2. Water Bill");
        System.out.println("3. Gas Bill");
        Scanner sc = new Scanner(System.in);  
        String billType = sc.next();
        if (billType.equals("1")) {
            Bill bill = new Electricity();
            bill.enterCode();
            double receipt = bill.Pay();
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        else if (billType.equals("2")) {
            Bill bill = new Water();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        else if (billType.equals("3")) {
            Bill bill = new Gaz();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        else {
            System.out.println("Invalid Input");
        }
    }
    /**
     * Gets the balance associated with the user's bank account.
     *
     * @return The balance.
     */
    public double getBalance(){
        if (bankName.equals("BankMisr")) {
            return BankMisr.getInstance().getAmount(creditCard);
        }
        else if (bankName.equals("BankCIB")) {
            return BankCIB.getInstance().getAmount(creditCard);
        }
        return 0;
    }

}
