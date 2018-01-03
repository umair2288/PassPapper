import java.util.Scanner;



public class Machine {
    Scanner scan;
    private Printer printer;
    private String language;
    private Double availableBalance;

    public void setLanguage(String language) {
        this.language = language;
    }

    public Machine(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public String getLanguage() {
        return language;
    }



    public boolean withdraw(User user)
    {
        boolean flag=false;
        scan= new Scanner(System.in);
        System.out.println("Enter Amount of withdrawal:");
        //get user input for withdrawal
        Double amount=scan.nextDouble();
        if(amount<this.availableBalance)
        {
            if((user.account.balance>500))
            {
                //move on to withdraw
               // Withdraw widthdraw=new Withdraw(user,60000.0);
                if(amount<=60000.0)
                {
                    user.account.balance-=amount;
                    System.out.println("withdraw is success, your current balance is "+user.account.balance);
                    printer=new Printer();
                    printer.printWithdrawReciept(user.account.bank,user.account.balance,"Cash Withdraw",amount.toString(),convert(user.account.number));
                    flag=true;
                }
                else
                {
                    System.out.println("Amount is more than maximum withdrawel");
                }
            }
            else{
                System.out.println("user account balance is low!");
            }
        }
        else
        {
            System.out.println("Insufficent fund");
        }

        return flag;
    }
    public boolean checkBalance(User user)
    {
        scan= new Scanner(System.in);
        System.out.println("Your Account Balance:"+user.account.balance);
        System.out.println("Need a reciept?");
        System.out.println("1:Yes");
        System.out.println("2:No");
        printer=new Printer();
        if(scan.nextInt()==1)
        {
            //System.out.println("run");
            printer.printBalanceReciept(user.account.bank,user.account.balance.toString(),"Check Balance","Not Available",convert(user.account.number));

        }


        return true;
    }
    public boolean deposit(User user)
    {
        boolean flag=false;
        scan=new Scanner(System.in);
        System.out.println("Enter amount to deposit");
        Double amount=scan.nextDouble();
        printer=new Printer();
        if(amount<=100000)
        {
            user.account.balance+=amount;
            System.out.println("Your current Balance:"+user.account.balance);
            System.out.println("Need Recipt?");
            printer.printBalanceReciept(user.account.bank,user.account.balance.toString(),"Cash DepositDeposit",amount.toString(),convert(user.account.number));
            flag=true;
        }
        else{
            System.out.println("Limit exeeded");
        }
        return flag;

    }
    public boolean transfer(User user)
    {
        boolean flag=false;
        scan = new Scanner(System.in);
        printer= new Printer();
        System.out.println("Enter account no");
        String accNo=scan.nextLine();
        System.out.println("Enter Branch no");
        String branch=scan.nextLine();
        if(accNo.equals("234523452345")&&branch.equalsIgnoreCase("Kelaniya"))
        {
            //TO DO
            if(user.account.balance>500)
            {
                System.out.println("Enter Tranfer Amount:");
                Double amount=scan.nextDouble();
                if(amount<100000)
                {
                    user.account.balance-=amount;
                    System.out.println("Transaction complete:Current Balance"+user.account.balance);
                    printer.printBalanceReciept(user.account.bank,user.account.balance.toString(),"Cash Transfer",amount.toString(),convert(user.account.number));
                }else
                    System.out.println("Limit exeeds");
            }
            else
            {
                System.out.println("Account balance is less than 500");
            }
        }

        return flag;

    }
    public boolean servicePayment(){
        boolean flag=false;
        //TO DO
        return flag;
    }

    public String convert(String str)
    {

        if(str.length()>3)
            return str.substring(0,str.length()-3)+"***";
        else
            return str;
    }
}
