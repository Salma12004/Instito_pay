package User;

import java.util.ArrayList;
import java.util.List;


public class UserDB {
    List<String> usersBankDB =  new ArrayList<String>();
    List<String> usersWalletDB =  new ArrayList<String>();

    //singleton
    private static UserDB instance;

    public static UserDB getInstance() {
        if (instance == null) {
            instance = new UserDB();
        }
        return instance;
    }

    //name,  mobileNumber,  password,  creditCard,  "Bank Misr"
    public void addUserBank(String name, String mobileNumber, String password, String creditCard, String bankName ){
        usersBankDB.add(name + " " + mobileNumber + " " + password + " " + creditCard + " " + bankName + " " );
    }
    //name,  mobileNumber,  password,  creditCard,  "Vodafone Cash"
    public void addUserWallet(String name, String mobileNumber, String password, String walletName ){
        usersWalletDB.add(name + " " + mobileNumber + " " + password + " " + walletName + " " );
    }

    public int checkExistence(String userName){
        for (String user : usersBankDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return 1;
            }
        }
        for (String user : usersWalletDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName)){
                return 2;
            }
        }
        return 0;
    }

    public String[] getUserInfo(String userName, String password){
        for (String user : usersBankDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName) && userArr[2].equals(password)){
                return userArr;
            }
        }
        for (String user : usersWalletDB) {
            String[] userArr = user.split(" ");
            if(userArr[0].equals(userName) && userArr[2].equals(password)){
                return userArr;
            }
        }
        return null;
        
    }

    public void printBankUsers(){
        for (String user : usersBankDB) {
            System.out.println(user);
        }
    }

    public void printWalletUsers(){
        for (String user : usersWalletDB) {
            System.out.println(user);
        }
    }
}
