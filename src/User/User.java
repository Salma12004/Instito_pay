package User;

import java.util.Scanner;
import Bill.Transaction;

public abstract class User {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected String creditCard;
    protected Transaction transaction;

    public User(String name, String mobileNumber, String password, String creditCard) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.creditCard = creditCard;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void performTransefer(){
        transaction.transfer(this);
    };

    public String getCreditCard(){
        return creditCard;
    }

    public String getmobileNumber() {
        return mobileNumber;
    }

    // abstract void payPill(){

    // }

    
}
