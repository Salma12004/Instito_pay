package APIs;

import java.util.ArrayList;
import java.util.List;


public class BankMisr implements Bank {
    private static  BankMisr instance;
    static List<String> BankMisrUsers =  new ArrayList<String>();
    
    public static BankMisr getInstance() {
        BankMisrUsers.add("01005181038 1234567891234567 50000");
        BankMisrUsers.add("01112509992 2345678912345670 10000");
        BankMisrUsers.add("01112501234 3456791234567120 20000");
        BankMisrUsers.add("01002509992 4567912345671230 30000");
        BankMisrUsers.add("01002501234 5679123456712340 40000");
        if (instance == null) {
            instance = new BankMisr();
        }
        return instance;
    }
    
    public Boolean checkExistence(String mobileNumber, String creditCard) {
        String key = mobileNumber.trim() + " " + creditCard.trim();
        for (String user : BankMisrUsers) {
            // Check if the user contains the provided mobileNumber and creditCard
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }

    public void decreaseAmount(String mobileNumber , String creditCard, double amount) {
        String searchString = mobileNumber.trim() + " " + creditCard.trim();
        int index = -1;
        for (int i = 0; i < BankMisrUsers.size(); i++) {
            if (BankMisrUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            String[] arr = BankMisrUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                BankMisrUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
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
        for (int i = 0; i < BankMisrUsers.size(); i++) {
            if (BankMisrUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = BankMisrUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[2]);
            currentAmount += amount;
            BankMisrUsers.set(index, arr[0] + " " + arr[1] + " " + currentAmount);
            System.out.println("Transaction successful. New balance: " + currentAmount);
        } else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }
    
    

    public void print(){
        for (String string : BankMisrUsers) {
            System.out.println(string);
        }
    }
      
}
