package APIs;
import java.util.ArrayList;
import java.util.List;

public class EtisalatCashProvider implements WalletProvider{

    private static  EtisalatCashProvider instance;

    public static EtisalatCashProvider getInstance() {
        if (instance == null) {
            instance = new EtisalatCashProvider();
        }
        return instance;
    }
    
    List<String> EtisalatCashUsers =  new ArrayList<String>();
    
    public EtisalatCashProvider() {
        EtisalatCashUsers.add("01105182020 50000");
        EtisalatCashUsers.add("01112502010 10000");
        EtisalatCashUsers.add("01102501223 20000");
        EtisalatCashUsers.add("01112509990 30000");
        EtisalatCashUsers.add("01122204090 40000");
    }

    public Boolean checkExistence(String mobileNumber) {
        String key = mobileNumber.trim();
        for (String user : EtisalatCashUsers) {
            if (user.startsWith(key)) {
                return true;
            }
        }
        return false;
    }

    public void decreaseAmount(String number,double amount) {
        String searchString = number.trim();
        int index = -1;
        for (int i = 0; i < EtisalatCashUsers.size(); i++) {
            if (EtisalatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtisalatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            if (currentAmount >= amount) {
                currentAmount -= amount;
                EtisalatCashUsers.set(index, arr[0] + " " + currentAmount);
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
        for (int i = 0; i < EtisalatCashUsers.size(); i++) {
            if (EtisalatCashUsers.get(i).startsWith(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = EtisalatCashUsers.get(index).split(" ");
            double currentAmount = Double.parseDouble(arr[1]);
            currentAmount += amount;
            EtisalatCashUsers.set(index, arr[0] + " " + currentAmount);
            System.out.println("Transaction successful. New balance: " + currentAmount);
         }
        else {
            System.out.println("User not found with the provided mobile number and credit card combination.");
        }
    } 
    public void print() {
        for (String user : EtisalatCashUsers) {
            System.out.println(user);
        }
    }
}
