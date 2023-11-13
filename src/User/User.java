package User;

public abstract class User {
    private String name;
    private String mobileNumber;
    private String password;

    public User(String name, String mobileNumber, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    void verify(){}
    abstract void chooseTransaction();
    abstract void transferToWallet();
    abstract void transferToInstitoAcc();
    void payPill(){

    }

    
}
