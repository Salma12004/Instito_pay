package User;

import java.util.Scanner;
import PayBills.*;

public class UserWallet extends User {

    private String walletName;

    public UserWallet(String name, String mobileNumber, String password, String walletName ) {
        super(name,mobileNumber,password);
        this.walletName = walletName;
    }
    public String getWalletName(){
        return walletName;
    }
    public void payBills()
    {
        System.out.println("Choose the bill type");
        System.out.println("1. Electricity Bill");
        System.out.println("2. Water Bill");
        System.out.println("3. Gas Bill");
        Scanner sc = new Scanner(System.in);  
        String billType = sc.next();
        if (billType.equals("1")) {
            Bill bill = new Electricity();
            bill.enterCode();
            double ftora = bill.Pay();
            
        }
        else if (billType.equals("2")) {
            Bill bill = new Water();
            bill.enterCode();
            bill.chooseCompany();
        }
        else if (billType.equals("3")) {
            Bill bill = new Gaz();
            bill.enterCode();
            bill.chooseCompany();
        }
        
        else {
            System.out.println("Invalid Input");
        }
        
    }
}
