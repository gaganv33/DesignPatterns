import account.AccountFactory;
import account.AccountType;
import account.BankAccount;

public class Main {
    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory(AccountType.PERSONAL, "bank name 1", "123456789", 1000L);
        BankAccount personalAccount = accountFactory.getBankAccount();
        accountFactory.cleanUp();

        accountFactory.createBankAccount(AccountType.BUSINESS, "bank name 2", "987654321", 10000L);
        BankAccount businessAccount = accountFactory.getBankAccount();
        accountFactory.cleanUp();

        System.out.println("---Personal Account---");
        if(personalAccount != null) {
            System.out.println(personalAccount.withDraw(150L));
            personalAccount.deposit(6000L);
            System.out.println(personalAccount);
        } else {
            System.out.println("Personal account is null");
        }


        System.out.println("---Business Account---");
        if(businessAccount != null) {
            System.out.println(businessAccount.withDraw(1500L));
            businessAccount.deposit(8000L);
            System.out.println(businessAccount);
        } else {
            System.out.println("Business account is null");
        }
    }
}