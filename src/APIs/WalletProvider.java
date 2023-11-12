package APIs;

public interface WalletProvider {
    public Boolean checkExistence(String mobileNumber);

    public void decreaseAmount(double amount);

    public void increaseAmount(double amount);
    
}
