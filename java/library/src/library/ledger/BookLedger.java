package library.ledger;

import library.persons.Patron;

import java.time.LocalDateTime;

public class BookLedger {

    private Long ledgerId;
    private Patron patron;
    private Long patronId;
    private Transaction transaction;
    private Long transactionId;
    private LocalDateTime date;

    public BookLedger(Long ledgerId, Patron patron, Transaction transaction) {
        this.ledgerId = ledgerId;
        this.patron = patron;
        this.patronId = patron.getPatronId();
        this.transaction = transaction;
        this.transactionId = transaction.getTransactionId();
        this.date = LocalDateTime.now();
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

    public LocalDateTime getDate() {
        return date;
    }
}
