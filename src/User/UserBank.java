package User;
import java.util.Scanner;
import APIs.VodafoneCashProvider;
import Application.Validator;

public class UserBank extends User {

    private String creditCard;
    private String bankName;

    public UserBank( String name, String mobileNumber, String password, String creditCard, String bankName) {
        super(name,mobileNumber,password);
        this.creditCard = creditCard;
        this.bankName = bankName;
    }

    public void payBills(){

    }
    
}
