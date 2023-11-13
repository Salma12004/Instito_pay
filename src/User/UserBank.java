package User;

public class UserBank extends User {

    private String creditCard;
    private String bankName;

    public UserBank( String name, String mobileNumber, String password, String creditCard, String bankName) {
        super(name,mobileNumber,password,creditCard);
        this.bankName = bankName;
    }


    public String getBankName(){
        return bankName;
    }

    public void payBills(){

    }
    
}
