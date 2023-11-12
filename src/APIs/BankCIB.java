package APIs;

import java.util.ArrayList;
import java.util.List;

import Application.Bankregistration;

public class BankCIB {
    List<String> BankCIBUsers =  new ArrayList<String>();
    public BankCIB() {
        BankCIBUsers.add("01000401038 1134567891234567 90000");
        BankCIBUsers.add("01012345678 1045678912345670 80000");
        BankCIBUsers.add("01143332642 9456791234567120 10000");
        BankCIBUsers.add("01149677992 8567912345671230 70000");
        BankCIBUsers.add("01141114798 7679123456712340 30000");
    
    }
   
    public Boolean checkExistence( String mobileNumber , String creditCard) {
        String Key = mobileNumber + " " + creditCard;
        return BankCIBUsers.contains(Key);
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
