import java.util.Scanner;

public class AutomatedTellerMachine {

    static Scanner scanner;
    static Machine machine;
    static Account account;
    static User user;


    public static void main(String[] args) {
        account= new Account("123456789123",50000.0,"Hatton National Bank");
        user= new User("5555",account);
        machine= new Machine(100000.0);

        scanner = new Scanner(System.in);
        //ask user to enter line
        //validate the pin number
        System.out.println("Enter pin No:");
        if(user.validatePin(scanner.nextLine())){
            //if pin number is correct
            System.out.println("pin number is correct");
            if(languageOptions())
            {
                //Language selection completed
                System.out.println("Language Setted to "+machine.getLanguage());
                callService();
            }
            else
            {
                System.out.println("invalid language option");
            }

        }
        else
        {//if pin no is not valid
            System.out.println("Invalid pin number entered");
        }

    }

    public static boolean languageOptions()
    {
        System.out.println("Select your prefered Language");
        System.out.println("1:English");
        System.out.println("2:Tamil");
        System.out.println("3:Sinhala");
        switch(scanner.nextInt()){
            case 1:
                machine.setLanguage("English");
                break;
            case 2:
                machine.setLanguage("Tamil");
                break;
            case 3:
                machine.setLanguage("Sinhala");
                break;
            default:
                return false;
        }
        return true;

    }
 public static boolean callService()
 {
     //select service
     System.out.println("Select your prefered service");
     System.out.println("1:Withdrawal");
     System.out.println("2:Check Balance");
     System.out.println("3:Deposit");
     System.out.println("4:Transfer Fund");
     System.out.println("5:Service Payments");

     switch (scanner.nextInt()){
         case 1:
             machine.withdraw(user);
             break;
         case 2:
             if(machine.checkBalance(user))
                 callService();
             break;
         case 3:
             machine.deposit(user);
             break;
         case 4:
             machine.transfer(user);
             break;
         case 5:
           //  machine.servicePayment(user);
             break;
         default:
             return false;
     }
    return true;
 }




}
