package APIs;

import java.util.ArrayList;
import java.util.List;

import Application.WalletRegistration;

public class VodafoneCashProvider implements WalletProvider{
    List<String> VodafoneCashUsers =  new ArrayList<String>();
    public VodafoneCashProvider() {
        VodafoneCashUsers.add("01005182020 50000");
        VodafoneCashUsers.add("01002502010 10000");
        VodafoneCashUsers.add("01002501223 20000");
        VodafoneCashUsers.add("01002509990 30000");
        VodafoneCashUsers.add("01002204090 40000");
    }

    public Boolean checkExistence(String mobileNumber) {
        String Key = mobileNumber;
        return VodafoneCashUsers.contains(Key);
    }

    public void decreaseAmount(double amount) {
    }

    public void increaseAmount(double amount) {
    }
    
}
