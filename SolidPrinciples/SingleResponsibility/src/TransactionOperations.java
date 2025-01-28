public class TransactionOperations {
    public void addBalance(Long balance, Account account) {
        account.setBalance(account.getBalance() + balance);
    }

    public void reduceBalance(Long balance, Account account) {
        Long inAccountBalance = account.getBalance();
        if(inAccountBalance < balance) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(inAccountBalance - balance);
    }
}
