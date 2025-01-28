public interface LoanRequest {
    LoanDetails loanRequest(String name, Long amount);
    void printLoanDetails();
}
