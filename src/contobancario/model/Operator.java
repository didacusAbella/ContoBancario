package contobancario.model;

/**
 * The class Operator.
 *
 */
public class Operator {

	/**
	 * Instantiates a new Operator.
	 * 
	 */
	public Operator() {
		this.serialNumber = null;
		this.password = null;
	}

	/**
	 * Instantiates a new Operator.
	 * 
	 */
	public Operator(String serialNumber, String password) {
		this.serialNumber = serialNumber;
		this.password = password;
	}
	
	/**
	 * Gets the operator's data in a readable format.
	 * 
	 * @return the operator's data
	 */
	public String toFormat() {
		return 
				this.serialNumber + " " +
				"psw: " + this.password;
	}

	/**
	 * Gets the serial number.
	 * 
	 * @return the serial number
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * Sets the serial number.
	 * 
	 * @param serialNumber the serial number
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +  "[" +
				"serialNumber=" + serialNumber + ", " +
				"password=" + password +
				"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operator other = (Operator) obj;
		return
				this.serialNumber.equals(other.serialNumber) &&
				this.password.equals(other.password);
	}

	@Override
	public Object clone() {
		try {
			Operator cloned = (Operator) super.clone(); 
			cloned.serialNumber = this.serialNumber;
			cloned.password = this.password;
			return cloned;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private String serialNumber;
	private String password;
}
