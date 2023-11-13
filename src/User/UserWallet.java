package User;

public class UserWallet extends User {

    private String walletName;

    public UserWallet( String name, String mobileNumber, String password, String walletName) {
        super(name,mobileNumber,password);
        this.walletName = walletName;
    }
    
    
    void chooseTransaction(){}
    void transferToWallet(){}
    void transferToInstitoAcc(){}

}
