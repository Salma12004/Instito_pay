package PayBills;
import APIs.*;
public abstract class Bill{
    protected String EPaymentCode;
    protected String company;
    public abstract String chooseCompany();
    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return company;
    }
    public void setEPaymentCode(String EPaymentCode){
        this.EPaymentCode = EPaymentCode;
    }
    public String getEPaymentCode(){
        return EPaymentCode;
    }
    public void enterCode(){
        System.out.println("Enter your EPayment Code: ");
        setEPaymentCode(System.console().readLine());
    }
    public double Pay() {
        return 0;
    }



}