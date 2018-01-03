public class User {
    private String pinNo;
    Account account;

    public User(String pinNo,Account account) {
        this.pinNo = pinNo;
        this.account=account;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public boolean validatePin(String pin)
    {
       return pin.equals(this.pinNo);
    }
}
