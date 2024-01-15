package PayBills;
import java.util.Scanner;
import APIs.WaterCompany;

/**
 * The Water class represents a bill for water payments.
 */
public class Water extends Bill{
    /**
     * Allows the user to choose the water company for the bill.
     *
     * @return The name of the chosen water company.
     */
    @Override
    public String chooseCompany(){
        System.out.println("Enter company name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        return name;
        // System.out.println("Enter EPaymentCode: ");
        // String code = input.nextLine();
        // WaterCompany waterCompany = new WaterCompany();
        // if (waterCompany.checkExistInWaterCompany(name , code)){
        //     double amount = waterCompany.displayBillInWaterCompany(code);
        //     System.out.println("Your Bill amount is: " + amount);
        //     waterCompany.removeBillInWaterCompany(code);
        //     //from where i should minus the bill amount
        // }
        // else{
        //     System.out.println("You are not registered in this company");
        // }
    }
    /**
     * Performs the payment for the water bill.
     *
     * @return The payment amount.
     */
    @Override
    public double Pay(){
        String name = chooseCompany();
        String code = getEPaymentCode();
        WaterCompany waterCompany = new WaterCompany();
        if (waterCompany.checkExistInWaterCompany(name , code)){
            double amount = waterCompany.displayBillInWaterCompany(code);
            System.out.println("Your Bill amount is: " + amount);
            double e = waterCompany.removeBillInWaterCompany(code);
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