import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Printer {

    public void printWithdrawReciept(String bankName,Double balance,String transferType,String transferAmount,String accountNumber) {
       // File bill=new File("withdrawBill.txt");
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String message= "Bank's Name: "+bankName+"\nDate and Time: "+now.toString()+"\nAccount Number: "+accountNumber+"\nCurrent Account Balance:"+balance.toString()+"\nLatest Transfer Type: "+transferType+ "\nLatest Transfer Amount: "+transferAmount;
        System.out.println(message);
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("withdrawBill.txt"));
            writer.write(message);

            writer.close();
            /*FileWriter fw = new FileWriter("withdrawBill.txt");
            fw.write(message);*/

           // System.out.println("hi");
         //   fw.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void printBalanceReciept(String bankName,String balance,String transferType,String transferAmount,String accountNumber) {
        //
        String message = "Bank's Name: " + bankName +
                "\nDate and Time: " + LocalDateTime.now().toString() +
                "\nAccount Number: " + accountNumber +
                "\nCurrent Account Balance:" + balance +
                "\nLatest Transfer Type: " + transferType +
                "\nLatest Transfer Amount: " + transferAmount;
        System.out.println(message);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Balance Bill.txt"));
            writer.write(message);

            writer.close();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
