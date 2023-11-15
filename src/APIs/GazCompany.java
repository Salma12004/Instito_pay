package APIs;

import java.util.ArrayList;
import java.util.List;
/**
 * The GazCompany class extends the BillAPI class and represents a specific
 * implementation for managing gas companies' bills.
 */
public class GazCompany extends BillAPI{
    List <String> companies = new ArrayList<String>();
      /**
     * Constructs a new GazCompany instance and initializes it with some sample
     * gas company bills.
     */
    public GazCompany(){
        companies.add("ShroukGaz 1234 900");
        companies.add("ShahdGaz 5678 800");
        companies.add("SalmaGaz 9374 500");
        companies.add("HabibaGaz 1352 600");
        companies.add("North 1294 1000");
        companies.add("East 5278 2000");
    }
    /**
     * Checks the existence of a bill in the gas company based on the provided
     * code and company.
     *
     * @param code    The code associated with the bill.
     * @param company The name of the gas company.
     * @return true if the bill exists, false otherwise.
     */
    public Boolean checkExistInGazCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    /**
     * Displays the bill amount for the specified code in the gas company.
     *
     * @param code The code associated with the bill.
     * @return The bill amount, or 0 if the bill is not found.
     */
    public double displayBillInGazCompany(String code){
        return super.displayBill(code, companies);
    }
    /**
     * Removes the bill for the specified code in the gas company and sets
     * the bill amount to 0.
     *
     * @param code The code associated with the bill to be removed.
     * @return The removed bill amount, or 0 if the bill is not found.
     */
    public double removeBillInGazCompany(String code){
        return super.removeBill(code, companies);
    }
}