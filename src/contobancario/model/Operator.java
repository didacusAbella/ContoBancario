package contobancario.model;

/**
 * The Class Operator.
 *
 */
public class Operator {

	/**
	 * Initialize a new operator.
	 * 
	 */
	public Operator() {
		
	}
	
	/**
	 * Initialize a new operator
	 * 
	 * @param serialNumber
	 */
	public Operator(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	
	/**
	 * @return the serialNumber
	 */
	public String getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() +  "[" +
				"serialNumber=" + serialNumber + 
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
				this.serialNumber.equals(other.serialNumber);
	}
	
	@Override
	public Object clone() {
		try {
			Operator cloned = (Operator) super.clone(); 
			cloned.serialNumber = this.serialNumber;
			return cloned;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private String serialNumber;
}
