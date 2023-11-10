import java.util.Date;

class Transaction {
    private String description;
    private double amount;
    private Date date;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
        this.date = new Date();
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}