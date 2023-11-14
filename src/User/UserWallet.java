package User;

import java.util.Scanner;

import APIs.EtisalatCashProvider;
import APIs.VodafoneCashProvider;
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
    public double getBalance() {
        if (walletName.equals("VodafoneCash")) {
            return VodafoneCashProvider.getInstance().getAmount(mobileNumber);
        }
        else if (walletName.equals("EtisalatCash")) {
            return EtisalatCashProvider.getInstance().getAmount(mobileNumber);
        }
        return 0;
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
            double receipt = bill.Pay();
            if (walletName.equals("VodafoneCash")) {
                VodafoneCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
            else if (walletName.equals("EtisalatCash")) {
                EtisalatCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
            
        }
        else if (billType.equals("2")) {
            Bill bill = new Water();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (walletName.equals("VodafoneCash")) {
                VodafoneCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
            else if (walletName.equals("EtisalatCash")) {
                EtisalatCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
        }
        else if (billType.equals("3")) {
            Bill bill = new Gaz();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (walletName.equals("VodafoneCash")) {
                VodafoneCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
            else if (walletName.equals("EtisalatCash")) {
                EtisalatCashProvider.getInstance().decreaseAmount(mobileNumber, receipt);
            }
        }
        
        else {
            System.out.println("Invalid Input");
        }
    }

}
