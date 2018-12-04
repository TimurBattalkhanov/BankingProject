import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> account = new LinkedList<>();
//Reading data from utilities.CSV.read method
        String file = "D:\\NewBankAccounts.csv";
        List<String[]> newAccounts = utilities.CSV.read(file);
        for (String[] accounts : newAccounts) {
            String name = accounts[0];
            String sSN = accounts[1];
            String accountType = accounts[2];
            double balance = new Double(accounts[3]);
            if (accountType.equals("Savings")) {
                account.add(new Savings(name, sSN, balance));
            } else if (accountType.equals("Checking")) {
                account.add(new Checking(name, sSN, balance));
            } else {
                System.out.println("TYPE ACCOUNT ERROR");
            }
        }
        for (Account accountReader: account){
            accountReader.showInfo();
        }
    }
}
