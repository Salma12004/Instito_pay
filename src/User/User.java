package User;

import java.util.Scanner;
import Bill.Transaction;

public abstract class User {
    private String name;
    private String mobileNumber;
    private String password;
    private Transaction transaction;

    public User(String name, String mobileNumber, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public void performTransefer(){
        transaction.transfer(this);
    }

    // abstract void payPill(){

    // }

    
}
