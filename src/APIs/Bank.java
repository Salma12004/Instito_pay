package APIs;

public interface Bank {

    public Boolean checkExistence(String mobileNumber , String creditCard);

    public void decreaseAmount(String creditCard, double amount);

    public void increaseAmount(String creditCard, double amount);
    
    public double getAmount(String creditCard);
    
    public void print();
    
}
