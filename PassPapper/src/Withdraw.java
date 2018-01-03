public class Withdraw {
    User withdrawer;
    Double miximumWithDraw;

    public Withdraw(User withdrawer, Double miximumWithDraw) {
        this.withdrawer = withdrawer;
        this.miximumWithDraw = miximumWithDraw;
    }

    public void getMoney(Double amount)
    {
        withdrawer.account.balance-=amount;
        System.out.println("withdraw is success, your current balance is "+withdrawer.account.balance);

    }

}
