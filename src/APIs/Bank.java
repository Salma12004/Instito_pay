package APIs;

public interface Bank {

    public Boolean checkExistence(String mobileNumber , String creditCard);

    public void decreaseAmount(String mobileNumber , String creditCard, double amount);

    public void increaseAmount(String mobileNumber , String creditCard, double amount);

    public void print();
    
}
