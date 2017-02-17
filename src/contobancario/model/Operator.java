package contobancario.model;

public class Operator {

	public Operator() {
		
	}

	public Operator(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}

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
