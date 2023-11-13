package APIs;
import java.util.ArrayList;
import java.util.List;

public class EtislatCashProvider implements WalletProvider{

    private static  EtislatCashProvider instance;

    public static EtislatCashProvider getInstance() {
        if (instance == null) {
            instance = new EtislatCashProvider();
        }
        return instance;
    }
    
    List<String> EtislatCashUsers =  new ArrayList<String>();
    
    public EtislatCashProvider() {
        EtislatCashUsers.add("01105182020 50000");
        EtislatCashUsers.add("01112502010 10000");
        EtislatCashUsers.add("01102501223 20000");
        EtislatCashUsers.add("01112509990 30000");
        EtislatCashUsers.add("01122204090 40000");
    }

    public Boolean checkExistence(String mobileNumber) {
        String key = mobileNumber.trim();
        for (String user : EtislatCashUsers) {
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }

    public void decreaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < EtislatCashUsers.size(); i++) {
            if (EtislatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtislatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                EtislatCashUsers.set(index, arr[0] + " " + currentAmount);
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
        for (int i = 0; i < EtislatCashUsers.size(); i++) {
            if (EtislatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtislatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            currentAmount += amount;
            EtislatCashUsers.set(index, arr[0] + " " + currentAmount);
            System.out.println("Transaction successful. New balance: " + currentAmount);
         }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    } 
    public void print() {
        for (String user : EtislatCashUsers) {
            System.out.println(user);
        }
    }
}
