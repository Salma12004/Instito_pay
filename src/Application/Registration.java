package Application;
import java.lang.System;
import java.util.Scanner;

/**
 * The Registration abstract class provides a common structure and functionality
 * for user registration in an application.
 */
public abstract class Registration {
    protected String name;
    protected String mobileNumber;
    protected String password;
    protected Validator validator;
    /**
     * Constructor for the Registration class, initializes the validator.
     */
    public Registration() {
        this.validator = new Validator();
    }
    /**
     * Sets the name for the registration, ensuring it is unique.
     *
     * @param name The name to be set.
     */
    public void setName(String name) {
        while(!validator.checkuniqueName(name)) {
            System.out.println("Please enter a unique name:");
            Scanner sc = new Scanner(System.in);
            name = sc.nextLine();
        }
        this.name = name;
    }
     /**
     * Sets the mobile number for the registration, ensuring it is valid.
     *
     * @param mobileNumber The mobile number to be set.
     */
    public void setMobileNumber(String mobileNumber) {
        while(!validator.checkValidNumber(mobileNumber)) {
            System.out.println("Please enter a valid mobile number:");
            Scanner sc = new Scanner(System.in);
            mobileNumber = sc.nextLine();
        }
        this.mobileNumber = mobileNumber;
    }
    /**
     * Sets the password for the registration, ensuring it is strong.
     *
     * @param password The password to be set.
     */
    public void setPassword(String password) {
        while (!validator.checkStrongPassword(password)) {
            System.out.println("It is not a strong password, please enter a strong password:");
            Scanner sc = new Scanner(System.in);
            password = sc.nextLine();
        }
        this.password = password;
    }
    /**
     * Gets the name associated with the registration.
     *
     * @return The name associated with the registration.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the mobile number associated with the registration.
     *
     * @return The mobile number associated with the registration.
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Gets the password associated with the registration.
     *
     * @return The password associated with the registration.
     */
    public String getPassword() {
        return password;
    }
    /**
     * Abstract method for user registration. Each concrete class must implement
     * this method based on its specific registration logic.
     */
    abstract public  void register();

}

