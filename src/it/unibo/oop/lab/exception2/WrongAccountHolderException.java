package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException {

	private static final long serialVersionUID = 7190620326792084901L;
	private final int currentId;
	
	public WrongAccountHolderException(final int currentId) {
		this.currentId = currentId;
	}

	public String toString() {
		return "Operation failed: your id (" + this.currentId + ") is not "
				+ "authorized!";
	}
	
	public String getMessage() {
		return this.toString();
	}

}
