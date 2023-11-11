package Application;
import java.util.*;
import java.util.Scanner;


public class InstitoSystem {

    private void LoginForm(){

    }

    private void RegisterForm(){
        System.out.println("Do you want to register using 1.bank account 2.wallet provider ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice==1){
            Bankregistration bank = new Bankregistration();
            bank.register();
        }
        else if(choice==2){
            WalletRegistration wallet = new WalletRegistration();
            wallet.register();
        }
        else{
            System.out.println("Invalid choice");
        }
    }

    public void displayMenu() {

    }

    

}
