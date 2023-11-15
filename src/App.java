/**
 * Program Description: InstitoPay System for online payment of bills and money transfer.
 * Last Modification Date: 9/11/2023
 *
 * Authors:
 * - Salma Mohammed Mahmoud / ID: 20210161
 * - Habiba Alaa Mohammed / ID: 20210121
 * - Shahd Salah El-Dein / ID: 20210183
 * - Shrouk Tarek Ibrahim / ID: 20210175
 *
 * Under The Supervision of: Dr. Soha Makady
 */

import APIs.Bank;
import APIs.BankMisr;
import Application.InstoSystem;
import User.UserDB;

public class App {
    public static void main(String[] args) throws Exception {
        InstoSystem system = new InstoSystem();
        system.displayMenu();
        
        // //check existence in vodafone
        // System.out.println(system.vodafoneCashProvider.checkExistence("01002509990"));
        // //check existence in etisalat

        // system.displayMenu();
        // system.bankCIB.print();
        // System.out.println("--------------------------------------------------");
        // system.bankCIB.increaseAmount("01000401038", "1134567891234567", 200);
        // system.bankCIB.print();
        // System.out.println("--------------------------------------------------");
        // system.bankCIB.decreaseAmount("01000401038", "1134567891234567", 100);
        // system.bankCIB.print();

        // //trace etisalatprovider
        // System.out.println("--------------------------------------------------");
        // system.etislatCashProvider.print();
        // System.out.println("--------------------------------------------------");
        // system.etislatCashProvider.increaseAmount("01105182020", 200);
        // system.etislatCashProvider.print();
        // System.out.println("--------------------------------------------------");
        // system.etislatCashProvider.decreaseAmount("01105182020", 100);
        // system.etislatCashProvider.print();

        // //trace vodafoneprovider
        // System.out.println("--------------------------------------------------");
        // system.vodafoneCashProvider.print();
        // System.out.println("--------------------------------------------------");
        // system.vodafoneCashProvider.increaseAmount("01005182020", 200);
        // system.vodafoneCashProvider.print();
        // System.out.println("--------------------------------------------------");
        // system.vodafoneCashProvider.decreaseAmount("01005182020", 100);
        // system.vodafoneCashProvider.print();

        // System.out.println("-----------------------bankusers---------------------------");

        // system.userDB.printBankUsers();
        // System.out.println("-----------------------walletusers---------------------------");
        // system.userDB.printWalletUsers();


        
    }
    
}
