package APIs;

import java.util.ArrayList;
import java.util.List;

/**
 * The BillAPI class provides functionality to check the existence of bills,
 * display bill amounts, and remove bills for a given code and company.
 */

public class BillAPI {
    /**
     * Checks the existence of a bill based on the provided code and company in the
     * given list of companies.
     *
     * @param code      The code associated with the bill.
     * @param company   The company associated with the bill.
     * @param companies The list of companies containing bill information.
     * @return true if the bill exists, false otherwise.
     */
    public Boolean checkExist(String code, String company , List<String> companies){
        String key = code.trim() + " " + company.trim();
        for (String c : companies) {
            if (c.startsWith(key)) {
                return true;
            }
        }
        return false;
    }
    /**
     * Displays the bill amount for the specified code in the given list of companies.
     *
     * @param code      The code associated with the bill.
     * @param companies The list of companies containing bill information.
     * @return The bill amount, or 0 if the bill is not found.
     */
    public double displayBill(String code, List<String> companies){
        String searchString =code.trim();
        int index = -1;
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).contains(searchString)) {
                index = i;
                break;
            }
        }
        if (index >= 0) {
            String[] arr = companies.get(index).split(" ");
            double Bill = Double.parseDouble(arr[2]);
            return Bill;
        }
        else {
            return 0;
        }
    }
    /**
     * Removes the bill for the specified code in the given list of companies and
     * sets the bill amount to 0.
     *
     * @param code      The code associated with the bill to be removed.
     * @param companies The list of companies containing bill information.
     * @return The removed bill amount, or 0 if the bill is not found.
     */
    public double removeBill(String code , List<String> companies){
        String searchString =code.trim();
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).contains(searchString)) {
                String[] arr = companies.get(i).split(" ");
                arr[2] = "0";
                companies.set(i, arr[0] + " " + arr[1] + " " + arr[2]);
                double Bill = Double.parseDouble(arr[2]);
                return Bill;
            }
        }
        return 0;
    }
}
