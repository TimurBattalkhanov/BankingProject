import java.sql.SQLOutput;

public class Checking extends Account {
    //Specific parameters to Checking account type
    private long debitCardNumber;
    private int debitCardPIN;

    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        //first digit in account number shows type of account (2 is Checking)
        accountNumber = "2" + accountNumber; 
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;

    }
//Randomly set 12 digit number to new account and 4 digit number to PIN code
    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * 10000);
    }
//Method shows specific info to Checking accounts + common Account info
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Your Checking Account Features: " +
                "\nDebit Card Number: " + debitCardNumber +
                "\nDebit Card PIN: " + debitCardPIN);
    }
}
