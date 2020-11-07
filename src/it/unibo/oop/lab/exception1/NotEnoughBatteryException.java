package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException{

	private static final long serialVersionUID = 1L;
	
	private final double batteryLevel;
	private final double batteryRequire;
	
	/**
	 * 
	 * @param batteryLevel
	 * 				current battery level
	 * @param batteryRequired
	 * 				level required for moving
	 */
	public NotEnoughBatteryException(final double batteryLevel, 
			final double batteryRequired) {
		super();
		this.batteryLevel = batteryLevel;
		this.batteryRequire = batteryRequired;
	}

	/**
	 * @return String representation of this exception 
	 */
	public String toString() {
		return "Not enough battery for moving. Battery level is " + batteryLevel + 
				", battery required is " + batteryRequire;
	}
	
	/**
	 * @return String representation of this exception 
	 */
	public String getMessage() {
		return this.toString();
	}
	
}
