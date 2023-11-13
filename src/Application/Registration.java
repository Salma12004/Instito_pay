package Application;
import java.lang.System;

public abstract class Registration {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected Validator validator;

    public Registration() {
        this.validator = new Validator();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumber(String mobileNumber) {
        while(!validator.checkValidNumber(mobileNumber)) {
            System.out.println("Please enter a valid mobile number:");
            mobileNumber = System.console().readLine();
        }
        this.mobileNumber = mobileNumber;
    }

    public void setPassword(String password) {
        while (!validator.checkStrongPassword(password)) {
            System.out.println("It is not a strong password, please enter a strong password:");
            password = System.console().readLine();
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    abstract public  void register();

}

