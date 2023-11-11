package Application;
import java.util.regex.Pattern;
import java.util.Random;

public class Validator {

    public Boolean checkStrongPassword(String password){
        Pattern validPasswordPattern = Pattern.compile("(?=.*[a-z])(?=.*[0-9])(?=.*[A-Z])(?=.*[#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~])[a-zA-Z0-9#!%$‘&\\\\+\\\\*\\\\–\\\\/=?^_`{|}\\\\.~]{8,12}");
        return validPasswordPattern.matcher(password).matches();   
    }

    public int sentOTP(){
        Random random = new Random();
        return random.nextInt(999999);
    }
    
    public Boolean checkValidNumber(String mobileNumber){
        Pattern validMobileNumberPattern = Pattern.compile("[0-9]{10}");
        return validMobileNumberPattern.matcher(mobileNumber).matches();
    }

}
