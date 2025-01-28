public class LoanDetails {
    private Long id;
    private Long amount;

    public LoanDetails(Long id, Long amount) {
        this.id = id;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "id=" + id +
                ", amount=" + amount +
                '}';
    }

    public LoanDetails() {

    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
