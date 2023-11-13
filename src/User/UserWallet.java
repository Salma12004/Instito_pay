package User;

import java.util.Scanner;

public class UserWallet extends User {

    private String walletName;

    public UserWallet(String name, String mobileNumber, String password, String walletName) {
        super(name,mobileNumber,password);
        this.walletName = walletName;
    }
    public String getWalletName(){
        return walletName;
    }
}
