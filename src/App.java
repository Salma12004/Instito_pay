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
    }
    
}
