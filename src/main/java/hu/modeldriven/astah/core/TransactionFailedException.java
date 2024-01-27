package hu.modeldriven.astah.core;

public class TransactionFailedException extends Exception {

    public TransactionFailedException(Exception e) {
        super(e);
    }

}
