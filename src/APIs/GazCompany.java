package APIs;

import java.util.ArrayList;
import java.util.List;

public class GazCompany extends BillAPI{
    List <String> companies = new ArrayList<String>();
    public GazCompany(){
        companies.add("ShroukGaz 1234 900");
        companies.add("ShahdGaz 5678 800");
        companies.add("SalmaGaz 9374 500");
        companies.add("HabibaGaz 1352 600");
        companies.add("North 1294 1000");
        companies.add("East 5278 2000");
    }
    public Boolean checkExistInGazCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    public double displayBillInGazCompany(String code){
        return super.displayBill(code, companies);
    }
    public double removeBillInGazCompany(String code){
        return super.removeBill(code, companies);
    }
}