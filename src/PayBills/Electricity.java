package PayBills;

import java.util.Scanner;

import APIs.ElectricityCompany;
/**
 * The Electricity class represents a bill for electricity payments.
 */
public class Electricity extends Bill{
    /**
     * Allows the user to choose the electricity company for the bill.
     *
     * @return The name of the chosen electricity company.
     */
    @Override
    public String chooseCompany(){
        System.out.println("Enter company name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
    }
    /**
     * Performs the payment for the electricity bill.
     *
     * @return The payment amount.
     */
    @Override
    public double Pay(){
        String name = chooseCompany();
        String code = getEPaymentCode();
        ElectricityCompany electricityCompany = new ElectricityCompany();
        if (electricityCompany.checkExistInElectCompany(name , code)){
            double amount = electricityCompany.displayBillInElectCompany(code);
            System.out.println("Your Bill amount is: " + amount);
            double e = electricityCompany.removeBillInElectCompany(code);
            System.out.println("Your Bill amount now is: " + e);
            return amount;
            //from where i should minus the bill amount
        }
        else{
            System.out.println("You are not registered in this company");
            return 0;
        }
    }
}