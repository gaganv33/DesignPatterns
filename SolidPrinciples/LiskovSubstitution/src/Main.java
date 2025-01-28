public class Main {
    public static void main(String[] args) {
        CreditCardLoan creditCardLoan = new CreditCardLoan();
        HomeLoan homeLoan = new HomeLoan();

        creditCardLoan.loanRequest("name 1", 1000L);
        creditCardLoan.doPayment("name 1", 500L);
        creditCardLoan.printLoanDetails();
        creditCardLoan.doPayment("name 1", 1000L);
        creditCardLoan.printLoanDetails();

        homeLoan.loanRequest("name 2", 2000L);
        homeLoan.doPayment("name 2", 1000L);
        homeLoan.printLoanDetails();
        homeLoan.foreCloseLoan("name 2");
        homeLoan.printLoanDetails();
    }
}