public abstract class Account implements IBaseRate{

    private String name;
    private String sSN;
    private double balance;
    private static int index = 10000;

    protected String accountNumber;
    protected double rate;

    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;
        index++;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    public void deposit(double amount){
        balance = balance + amount;
        System.out.println(balance);
    }
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println(balance);
    }
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        System.out.println(balance);
    }

    private String setAccountNumber(){
        String lastTwoNumbersOfSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * 1000);
        String accNumber = lastTwoNumbersOfSSN + uniqueID + randomNumber;
        return accNumber;
    }

    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
    }

    public void showInfo(){
        System.out.println("Name: " + name +
                "\nSSN: " + sSN +
                "\nBalance: " + balance +
                "\nAccount Number: " + accountNumber +
                "\nRate: " + rate + "%");
    }
}
