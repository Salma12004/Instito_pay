package APIs;

import java.util.ArrayList;
import java.util.List;


public class BankCIB {
    private static  BankCIB instance;
    List<String> BankCIBUsers =  new ArrayList<String>();

    public BankCIB() {
        BankCIBUsers.add("01000401038 1134567891234567 90000");
        BankCIBUsers.add("01012345678 1045678912345670 80000");
        BankCIBUsers.add("01143332642 9456791234567120 10000");
        BankCIBUsers.add("01149677992 8567912345671230 70000");
        BankCIBUsers.add("01141114798 7679123456712340 30000");
    }

    public static BankCIB getInstance() {
        if (instance == null) {
            instance = new BankCIB();
        }
        return instance;
    }

    public Boolean checkExistence( String mobileNumber , String creditCard) {
        String Key = mobileNumber + " " + creditCard;
        return BankCIBUsers.contains(Key);
    }

    public void decreaseAmount(String mobileNumber , String creditCard, double amount) {
        String searchString = mobileNumber.trim() + " " + creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankCIBUsers.size(); i++) {
            if (BankCIBUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            String[] arr = BankCIBUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                BankCIBUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
                System.out.println("Transaction successful. Remaining balance: " + currentAmount);
            } 
            else {
                System.out.println("Insufficient funds.");
            }
        } 
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    public void increaseAmount(String mobileNumber, String creditCard, double amount) {
        String searchString = mobileNumber.trim() + " " + creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankCIBUsers.size(); i++) {
            if (BankCIBUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankCIBUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            currentAmount += amount;
            BankCIBUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
            System.out.println("Transaction successful. New balance: " + currentAmount);
        } else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    public void print(){
        for (String string : BankCIBUsers) {
            System.out.println(string);
        }
    }
    
}
