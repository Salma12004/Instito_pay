package APIs;

import java.util.ArrayList;
import java.util.List;

import Application.Bankregistration;

//api of this bank: Mobile , credit card , amount of money, username
public class BankMisr implements Bank {
    List<String> BankMisrUsers =  new ArrayList<String>();
    public BankMisr() {
        BankMisrUsers.add("01005181038 1234567891234567 50000");
        BankMisrUsers.add("01112509992 2345678912345670 10000");
        BankMisrUsers.add("01112501234 3456791234567120 20000");
        BankMisrUsers.add("01002509992 4567912345671230 30000");
        BankMisrUsers.add("01002501234 5679123456712340 40000");
    
    }
   
    public Boolean checkExistence( String mobileNumber , String creditCard) {
        String Key = mobileNumber + " " + creditCard;
        return BankMisrUsers.contains(Key);
    }

    public void decreaseAmount(double amount) {
        // int index = list.indexOf(Key);
        // String[] arr = list.get(index).split(" ");
        // double currentAmount = Double.parseDouble(arr[2]);
        // if (currentAmount >= amount) {
        //     currentAmount -= amount;
        //     list.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
        //     System.out.println("Transaction successful. Remaining balance: " + currentAmount);
        // } else {
        //     System.out.println("Insufficient funds.");
        // }
        
    }

    public void increaseAmount(double amount) {
        // int index = list.indexOf(Key);
        // String[] arr = list.get(index).split(" ");
        // double currentAmount = Double.parseDouble(arr[2]);
        // currentAmount += amount;
        // list.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
        // System.out.println("Transaction successful. New balance: " + currentAmount);
    }
      
}
