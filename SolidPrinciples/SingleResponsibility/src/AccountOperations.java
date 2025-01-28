import java.util.HashMap;
import java.util.Map;

public class AccountOperations {
    private static Long accountNumber = 1L;
    private static final Map<String, Account> accountMap = new HashMap<>();

    public void addAccount(String name, Long balance) {
        if(accountMap.containsKey(name)) {
            throw new RuntimeException("Account with name already registered.");
        }
        Account account = new Account(accountNumber, balance);
        accountNumber += 1L;
        accountMap.put(name, account);
    }

    public Account getAccount(String name) {
        if(!accountMap.containsKey(name)) {
            throw new RuntimeException("Account with name not found");
        }
        return accountMap.get(name);
    }
}
