package APIs;

import java.util.ArrayList;
import java.util.List;

public class BillAPI {
    public Boolean checkExist(String code, String company , List<String> companies){
        String key = code.trim() + " " + company.trim();
        for (String c : companies) {
            if (c.startsWith(key)) {
                return true;
            }
        }
        return false;
    }
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
