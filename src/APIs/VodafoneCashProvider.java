package APIs;

import java.util.ArrayList;
import java.util.List;

public class VodafoneCashProvider implements WalletProvider{
    //singletone
    private static  VodafoneCashProvider instance;

    public static VodafoneCashProvider getInstance() {
        if (instance == null) {
            instance = new VodafoneCashProvider();
        }
        return instance;
    }

    List<String> VodafoneCashUsers =  new ArrayList<String>();
    public VodafoneCashProvider() {
        VodafoneCashUsers.add("01005182020 50000");
        VodafoneCashUsers.add("01002502010 10000");
        VodafoneCashUsers.add("01002501223 20000");
        VodafoneCashUsers.add("01002509990 30000");
        VodafoneCashUsers.add("01002204090 40000");
    }

    public Boolean checkExistence(String mobileNumber) {
        String key = mobileNumber.trim();
        for (String user : VodafoneCashUsers) {
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }

    public void decreaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < VodafoneCashUsers.size(); i++) {
            if (VodafoneCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = VodafoneCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                VodafoneCashUsers.set(index, arr[0] + " " + currentAmount);
                System.out.println("Transaction successful. Remaining balance: " + currentAmount);
            } else {
                System.out.println("Insufficient funds.");
            }
        }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    }

    public void increaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < VodafoneCashUsers.size(); i++) {
            if (VodafoneCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = VodafoneCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            currentAmount += amount;
            VodafoneCashUsers.set(index, arr[0] + " " + currentAmount);
            System.out.println("Transaction successful. New balance: " + currentAmount);
         }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    } 
    public void print() {
        for (String user : VodafoneCashUsers) {
            System.out.println(user);
        }
    }  
    
}
