package Application;
import java.util.Scanner;
import java.util.Scanner;

public class Bankregistration extends Registration{
    private String creditCard;

    public Bankregistration() {
        super();
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }


    public String getCreditCard() {
        return creditCard;
    }

    @Override
    public void register() {
        System.out.println("-----------------Bank registration-----------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();

        System.out.println("Enter mobile number");
        String mobileNumber = sc.nextLine();

        while(!validator.checkValidNumber(mobileNumber)){
            System.out.println("It is not a valid mobile number, please enter a valid mobile number:");
            mobileNumber = sc.nextLine();
        }
        System.out.println("Enter a strong password:");
        System.out.println(" Here is a format of strong password: ");
        System.out.println("1-Is at least 8 characters long and 12 max.\n2-Must include at least one uppercase and at least one lowercase letters\n3-Must include numbers and special symbols:");
        String password = sc.nextLine();
        while(!validator.checkStrongPassword(password)){
            System.out.println("It is not a strong password, please enter a strong password:");
            password = sc.nextLine();
        }
        System.out.println("Enter credit card number");
        String creditCard = sc.nextLine();
        // while(){

        // }
    }
}
