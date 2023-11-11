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
        if (validator.checkValidNumber(mobileNumber)) {
            this.mobileNumber = mobileNumber;
        }
    }

    public void setPassword(String password) {
        if (validator.checkStrongPassword(password)) {
            this.password = password;
        }
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

