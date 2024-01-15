package APIs;

import java.util.ArrayList;
import java.util.List;
/**
 * The WaterCompany class extends the BillAPI class and represents a specific
 * implementation for managing water companies' bills.
 */
public class WaterCompany extends BillAPI {
    List <String> companies = new ArrayList<String>();
    /**
     * Constructs a new WaterCompany instance and initializes it with some sample
     * water company bills.
     */
    public WaterCompany(){
        companies.add("ShroukWater 5678 9000");
        companies.add("ShahdWater 1983 8000");
        companies.add("SalmaWater 9372 5000");
        companies.add("HabibaWater 4352 6000");
        companies.add("COSMA 1234 100");
        companies.add("CAESA 3278 200");
    }
    /**
     * Checks the existence of a bill in the water company based on the provided
     * code and company.
     *
     * @param code    The code associated with the bill.
     * @param company The name of the water company.
     * @return true if the bill exists, false otherwise.
     */
    public Boolean checkExistInWaterCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    /**
     * Displays the bill amount for the specified code in the water company.
     *
     * @param code The code associated with the bill.
     * @return The bill amount, or 0 if the bill is not found.
     */
    public double displayBillInWaterCompany(String code){
        return super.displayBill(code, companies);
    }
    /**
     * Removes the bill for the specified code in the water company and sets
     * the bill amount to 0.
     *
     * @param code The code associated with the bill to be removed.
     * @return The removed bill amount, or 0 if the bill is not found.
     */
    public double removeBillInWaterCompany(String code){
        return super.removeBill(code, companies);
    }    
}