import java.util.HashMap;
import java.util.Map;

public class HomeLoan implements SecureLoanPayment, LoanRequest {
    private static Long id = 1L;
    private final static Map<String, LoanDetails> homeLoanDetails = new HashMap<>();

    @Override
    public void doPayment(String name, Long amount) {
        if(!homeLoanDetails.containsKey(name)) {
            throw new RuntimeException("Details with " + name + " not found");
        }
        LoanDetails loanDetails = homeLoanDetails.get(name);
        Long balanceAmount = loanDetails.getAmount();
        if(amount >= balanceAmount) {
            foreCloseLoan(name);
        } else {
            loanDetails.setAmount(balanceAmount - amount);
            homeLoanDetails.replace(name, loanDetails);
        }
    }

    @Override
    public void foreCloseLoan(String name) {
        if(!homeLoanDetails.containsKey(name)) {
            throw new RuntimeException("Details with " + name + " not found");
        }
        homeLoanDetails.remove(name);
    }

    @Override
    public LoanDetails loanRequest(String name, Long amount) {
        if(homeLoanDetails.containsKey(name)) {
            throw new RuntimeException("Details with " + name + " already exists");
        }
        LoanDetails loanDetails = new LoanDetails(id, amount);
        homeLoanDetails.put(name, loanDetails);
        id += 1L;
        return loanDetails;
    }

    @Override
    public void printLoanDetails() {
        System.out.println(homeLoanDetails);
    }
}
