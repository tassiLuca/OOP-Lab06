package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException{

	private static final long serialVersionUID = -5186015990336694793L;

	public String toString() {
		return "ATM transactions over the maximum allowed";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
