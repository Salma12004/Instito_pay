package User;

import java.util.Scanner;
import Bill.Transaction;

public abstract class User {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected Transaction transaction;

    public User(String name, String mobileNumber, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void performTransefer() {
        transaction.transfer(this);
    }

    

    public String getmobileNumber() {
        return mobileNumber;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }

    // abstract void payPill(){

    // }

    
}
