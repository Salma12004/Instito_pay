package APIs;

public interface WalletProvider {
    public Boolean checkExistence(String mobileNumber);

    public void decreaseAmount(String number,double amount);

    public void increaseAmount(String number,double amount);

    public void print();
    
}
