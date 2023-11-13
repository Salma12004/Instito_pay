package User;

public class UserBank extends User {

    private String creditCard;
    private String bankName;

    public UserBank( String name, String mobileNumber, String password, String creditCard, String bankName) {
        super(name,mobileNumber,password);
        this.bankName = bankName;
        this.creditCard = creditCard;
    }
 
    public String getBankName(){
        return bankName;
    }

    public void payBills(){

    }
    public String getCreditCard(){
        return creditCard;
    }
    
    
}
