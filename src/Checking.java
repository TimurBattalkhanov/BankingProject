import java.sql.SQLOutput;

public class Checking extends Account {

    private long debitCardNumber;
    private int debitCardPIN;

    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    @Override
    public void setRate() {
        rate = getBaseRate() * 0.15;

    }

    private void setDebitCard() {
        debitCardNumber = (long) (Math.random() * Math.pow(10, 12));
        debitCardPIN = (int) (Math.random() * 10000);
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Your Checking Account Features: " +
                "\nDebit Card Number: " + debitCardNumber +
                "\nDebit Card PIN: " + debitCardPIN);
    }
}
