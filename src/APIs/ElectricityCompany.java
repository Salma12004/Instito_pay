package APIs;

import java.util.ArrayList;
import java.util.List;

public class ElectricityCompany extends BillAPI{
    List <String> companies = new ArrayList<String>();
    public ElectricityCompany(){
        companies.add("ShroukElectricity 5678 9000");
        companies.add("ShahdElectricity 1983 8000");
        companies.add("SalmaElectricity 9372 5000");
        companies.add("HabibaElectricity 4352 6000");
        companies.add("South 1234 100");
        companies.add("West 3278 200");
    }

    public Boolean checkExistInElectCompany(String code, String company){
        return super.checkExist(code, company, companies);
    }
    public double displayBillInElectCompany(String code){
        return super.displayBill(code, companies);
    }
    public double removeBillInElectCompany(String code){
        return super.removeBill(code, companies);
    }
    

}