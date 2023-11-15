package APIs;

import java.util.ArrayList;
import java.util.List;

/**
 * The ElectricityCompany class extends the BillAPI class and represents a specific
 * implementation for managing electricity companies' bills.
 */
public class ElectricityCompany extends BillAPI{
    List <String> companies = new ArrayList<String>();
    /**
     * Constructs a new ElectricityCompany instance and initializes it with some
     * sample electricity company bills.
     */
    public ElectricityCompany(){
        companies.add("ShroukElectricity 5678 9000");
        companies.add("ShahdElectricity 1983 8000");
        companies.add("SalmaElectricity 9372 5000");
        companies.add("HabibaElectricity 4352 6000");
        companies.add("South 1234 100");
        companies.add("West 3278 200");
    }
    /**
     * Checks the existence of a bill in the electricity company based on the provided
     * code and company.
     *
     * @param code    The code associated with the bill.
     * @param company The name of the electricity company.
     * @return true if the bill exists, false otherwise.
     */
    public Boolean checkExistInElectCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    /**
     * Displays the bill amount for the specified code in the electricity company.
     *
     * @param code The code associated with the bill.
     * @return The bill amount, or 0 if the bill is not found.
     */
    public double displayBillInElectCompany(String code){
        return super.displayBill(code, companies);
    }
    
    /**
     * Removes the bill for the specified code in the electricity company and sets
     * the bill amount to 0.
     *
     * @param code The code associated with the bill to be removed.
     * @return The removed bill amount, or 0 if the bill is not found.
     */
    public double removeBillInElectCompany(String code){
        return super.removeBill(code, companies);
    }
    

}