package PayBills;

import java.util.Scanner;


import APIs.GazCompany;

public class Gaz extends Bill{
    public String chooseCompany(){
        System.out.println("Enter company name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }
    public double Pay(){
        String name = chooseCompany();
        String code = getEPaymentCode();
        GazCompany GazCompany = new GazCompany();
        if (GazCompany.checkExistInGazCompany(name , code)){
            double amount = GazCompany.displayBillInGazCompany(code);
            System.out.println("Your Bill amount is: " + amount);
            double e = GazCompany.removeBillInGazCompany(code);
            System.out.println("Your Bill amount now is: " + e);
            return amount;
            //from where i should minus the bill amount
        }
        else{
            System.out.println("You are not registered in this company");
            return 0;
        }
    }
//         System.out.println("Enter EPaymentCode: ");
//         String code = input.nextLine();
//         GazCompany gazCompany = new GazCompany();
//         if (gazCompany.checkExistInGazCompany(name , code)){
//             double amount = gazCompany.displayBillInGazCompany(code);
//             System.out.println("Your Bill amount is: " + amount);
//             gazCompany.removeBillInGazCompany(code);
//             System.out.println("Your Bill amount is: " + amount);
//             //from where i should minus the bill amount
//         }
//         else{
//             System.out.println("You are not registered in this company");
//         }
}

