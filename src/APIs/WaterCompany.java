package APIs;

import java.util.ArrayList;
import java.util.List;

public class WaterCompany extends BillAPI {
    List <String> companies = new ArrayList<String>();
    public WaterCompany(){
        companies.add("ShroukWater 5678 9000");
        companies.add("ShahdWater 1983 8000");
        companies.add("SalmaWater 9372 5000");
        companies.add("HabibaWater 4352 6000");
        companies.add("COSMA 1234 100");
        companies.add("CAESA 3278 200");
    }
    public Boolean checkExistInWaterCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    public double displayBillInWaterCompany(String code){
        return super.displayBill(code, companies);
    }
    public double removeBillInWaterCompany(String code){
        return super.removeBill(code, companies);
    }    
}