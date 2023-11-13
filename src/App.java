// Program Description: Applying online payment bills and transfer money (InstitoPay System)
// Last Modification Date: 9/11/2023
// First author - ID : Salma Mohammed Mahmoud / 20210161
// Second author - ID : Habiba Alaa Mohammed / 20210121
// Third author - ID : Shahd Salah El-Dein / 20210183
// Fourth author - ID : Shrouk Tarek Ibrahim / 20210175
// Under The Supervision of: Dr. Soha Makady

import APIs.Bank;
import APIs.BankMisr;
import Application.InstitoSystem;

public class App {
    public static void main(String[] args) throws Exception {
        InstitoSystem system = new InstitoSystem();
        system.bankCIB.print();
        System.out.println("--------------------------------------------------");
        system.bankCIB.increaseAmount("01000401038", "1134567891234567", 200);
        system.bankCIB.print();
        System.out.println("--------------------------------------------------");
        system.bankCIB.decreaseAmount("01000401038", "1134567891234567", 100);
        system.bankCIB.print();
        // system.displayMenu();
  
        // Use the Singleton

        
    }
    
}
