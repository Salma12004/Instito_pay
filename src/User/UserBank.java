package User;

import java.util.Scanner;

import APIs.BankCIB;
import APIs.BankMisr;
import PayBills.*;

public class UserBank extends User {

    private String creditCard;
    private String bankName;

    public UserBank( String name, String mobileNumber, String password, String creditCard, String bankName ) {
        super(name,mobileNumber,password);
        this.bankName = bankName;
        this.creditCard = creditCard;
    }
    public String getBankName(){
        return bankName;
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
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        else if (billType.equals("2")) {
            Bill bill = new Water();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        else if (billType.equals("3")) {
            Bill bill = new Gaz();
            bill.enterCode();
            bill.chooseCompany();
            double receipt = bill.Pay();
            if (bankName.equals("BankMisr")) {
                BankMisr.getInstance().decreaseAmount(creditCard, receipt);
            }
            else if (bankName.equals("BankCIB")) {
                BankCIB.getInstance().decreaseAmount(creditCard, receipt);
            }
        }
        
        else {
            System.out.println("Invalid Input");
        }
        
    }
    public String getCreditCard(){
        return creditCard;
    }
}
