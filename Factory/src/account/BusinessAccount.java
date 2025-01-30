package account;

public class BusinessAccount extends BankAccount {
    public BusinessAccount(String bankName, String accountNumber, Long balance) {
        super(bankName, accountNumber, balance);
    }

    @Override
    public Long withDraw(Long amount) {
        System.out.println("Business account withdraw");
        if(this.getBalance() < amount) {
            return 0L;
        }
        Long finalBalance = this.getBalance() - amount;
        this.setBalance(finalBalance);
        return finalBalance;
    }

    @Override
    public void deposit(Long amount) {
        System.out.println("Business account deposit");
        Long finalBalance = this.getBalance() + amount;
        this.setBalance(finalBalance);
    }
}
