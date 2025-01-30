package account;

public class AccountFactory {
    private BankAccount bankAccount;

    public AccountFactory(AccountType type, String bankName, String accountNumber, Long balance) {
        createBankAccount(type, bankName, accountNumber, balance);
    }

    public void cleanUp() {
        if(bankAccount != null) {
            bankAccount = null;
        }
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void createBankAccount(AccountType type, String bankName, String accountNumber, Long balance) {
        if(type.equals(AccountType.PERSONAL)) {
            bankAccount = new PersonalAccount(bankName, accountNumber, balance);
        } else if(type.equals(AccountType.BUSINESS)) {
            bankAccount = new BusinessAccount(bankName, accountNumber, balance);
        } else {
            bankAccount = null;
        }
    }
}
