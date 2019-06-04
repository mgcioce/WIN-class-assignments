package library.ledger;

import library.persons.Patron;

public class AccountLedger {

    private Patron patron;
    private Long patronId;
    private Transaction transaction;
    private Long transactionId;
    private double amount;

    public AccountLedger(Patron patron, Transaction transaction, double amount) {
        this.patron = patron;
        this.patronId = patron.getPatronId();
        this.transaction = transaction;
        this.transactionId = transaction.getTransactionId();
        this.amount = amount;
    }

    public Patron getPatron() {
        return patron;
    }

    public Long getPatronId() {
        return patronId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
