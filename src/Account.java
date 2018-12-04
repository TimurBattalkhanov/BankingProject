public abstract class Account implements IBaseRate{
//Paramaters to new Accounts
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
    //Adding some amount to deposit
    public void deposit(double amount){
        balance = balance + amount;
        System.out.println(balance);
    }
    //Withdraw some amount from balance
    public void withdraw(double amount){
        balance = balance - amount;
        System.out.println(balance);
    }
    //Method to transfer money from balance to some destination
    public void transfer(String toWhere, double amount){
        balance = balance - amount;
        System.out.println("Transfering $" + amount + " to " + toWhere);
        System.out.println(balance);
    }
    //set account number consists of 2 digit of SSN + 4 digit ID with incrementation by 1 + random 3 digits 
    private String setAccountNumber(){
        String lastTwoNumbersOfSSN = sSN.substring(sSN.length()-2,sSN.length());
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * 1000);
        String accNumber = lastTwoNumbersOfSSN + uniqueID + randomNumber;
        return accNumber;
    }
//method adds interest to balance
    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
    }
    //Method shows account info
    public void showInfo(){
        System.out.println("Name: " + name +
                "\nSSN: " + sSN +
                "\nBalance: " + balance +
                "\nAccount Number: " + accountNumber +
                "\nRate: " + rate + "%");
    }
}
