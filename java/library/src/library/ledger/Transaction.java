package library.ledger;

public enum Transaction {

    LOAN(new Long(1),"Loan"),
    RETURN(new Long(2),"Return"),
    CREDIT(new Long(3),"Credit"),
    DEBIT(new Long(4),"Debit");

    private final Long transactionId;
    private final String type;

    Transaction(Long transactionId,String type) {
        this.transactionId = transactionId;
        this.type = type;
    }


    public String getType() {
        return this.type;
    }

    public Long getTransactionId() {
        return this.transactionId;
    }

    @Override
    public String toString() {
        return this.transactionId + ": " + this.type;
    }

}

