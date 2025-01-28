
public class Main {
    public static void main(String[] args) {
        AccountOperations accountOperations = new AccountOperations();
        TransactionOperations transactionOperations = new TransactionOperations();

        accountOperations.addAccount("name 1", 10L);
        accountOperations.addAccount("name 2", 15L);

        System.out.println(accountOperations.getAccount("name 1"));
        System.out.println(accountOperations.getAccount("name 2"));

        transactionOperations.addBalance(10L, accountOperations.getAccount("name 1"));
        transactionOperations.reduceBalance(10L, accountOperations.getAccount("name 2"));

        System.out.println(accountOperations.getAccount("name 1"));
        System.out.println(accountOperations.getAccount("name 2"));
    }
}