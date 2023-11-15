package PayBills;
/**
 * The Bill class represents an abstract bill for electronic payments.
 */
public abstract class Bill{
    protected String EPaymentCode;
    protected String company;
    /**
     * Abstract method to choose the company associated with the bill.
     *
     * @return The name of the chosen company.
     */
    public abstract String chooseCompany();
    /**
     * Sets the company associated with the bill.
     *
     * @param company The name of the company.
     */
    public void setCompany(String company){
        this.company = company;
    }
    /**
     * Gets the name of the company associated with the bill.
     *
     * @return The name of the company.
     */
    public String getCompany(){
        return company;
    }
    /**
     * Sets the EPayment code for the bill.
     *
     * @param EPaymentCode The EPayment code.
     */
    public void setEPaymentCode(String EPaymentCode){
        this.EPaymentCode = EPaymentCode;
    }
    /**
     * Gets the EPayment code for the bill.
     *
     * @return The EPayment code.
     */
    public String getEPaymentCode(){
        return EPaymentCode;
    }
    /**
     * Allows the user to enter the EPayment code.
     */
    public void enterCode(){
        System.out.println("Enter your EPayment Code: ");
        setEPaymentCode(System.console().readLine());
    }
    /**
     * Abstract method to perform the payment for the bill.
     *
     * @return The payment amount.
     */
    public double Pay() {
        return 0;
    }

}