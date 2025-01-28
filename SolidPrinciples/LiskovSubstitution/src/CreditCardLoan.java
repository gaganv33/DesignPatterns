import java.util.HashMap;
import java.util.Map;

public class CreditCardLoan implements LoanPayment, LoanRequest {
    private static Long id = 1L;
    private final static Map<String, LoanDetails> creditCardDetails = new HashMap<>();

    @Override
    public void doPayment(String name, Long amount) {
        if(!creditCardDetails.containsKey(name)) {
            throw new RuntimeException("Details with " + name + " not found");
        }
        LoanDetails loanDetails = creditCardDetails.get(name);
        Long balanceAmount = loanDetails.getAmount();
        if(amount >= balanceAmount) {
            creditCardDetails.remove(name);
        } else {
            loanDetails.setAmount(balanceAmount - amount);
            creditCardDetails.replace(name, loanDetails);
        }
    }

    @Override
    public LoanDetails loanRequest(String name, Long amount) {
        if(creditCardDetails.containsKey(name)) {
            throw new RuntimeException("Details with " + name + " already exists");
        }
        LoanDetails loanDetails = new LoanDetails(id, amount);
        creditCardDetails.put(name, loanDetails);
        id += 1L;
        return loanDetails;
    }

    @Override
    public void printLoanDetails() {
        System.out.println(creditCardDetails);
    }
}
