package APIs;

public interface Bank {
    public Boolean checkExistence( String mobileNumber , String creditCard);

    public void decreaseAmount(double amount);

    public void increaseAmount(double amount);
    
}
