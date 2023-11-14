package Bill;

import java.util.Scanner;

import User.User;
import User.UserDB;

public class InstitoTransaction implements Transaction{
    public void transfer(User user)
    {
        System.out.println("Please enter the name of the user you want to transfer to");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int type = UserDB.getInstance().checkExistence(name);
        if ( type == 0) {
            System.out.println("User does not exist");
        }
        else if (type == 1) {
            System.out.println("Please enter the amount you want to transfer");
            int amount = sc.nextInt();
        

            
        }
        else if (type == 2) {
            System.out.println("Please enter the amount you want to transfer");
            int amount = sc.nextInt();
        
            }

            
        }

    

    }

