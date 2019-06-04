package library.ledger;

import library.persons.Patron;

public class BookLedger {

    private Long ledgerId;
    private Patron patron;
    private Long patronId;
    private Transaction transaction;
    private Long transactionId;

    public BookLedger(Long ledgerId, Patron patron, Transaction transaction) {
        this.ledgerId = ledgerId;
        this.patron = patron;
        this.patronId = patron.getPatronId();
        this.transaction = transaction;
        this.transactionId = transaction.getTransactionId();
    }

    public Long getLedgerId() {
        return ledgerId;
    }

    public Long getPatronId() {
        return patronId;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }
}
