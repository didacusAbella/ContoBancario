package contobancario.model;

public class Operatore implements Cloneable {
	
	/**
	 * Istanzia un nuovo operatore.
	 */
	public Operatore() {
		
	}
	/**
	 * Istanzia un nuovo operatore con la rispettiva matricola.
	 * @param matricola la matricola.
	 */
	public Operatore(String matricola) {
		this.matricola = matricola;
	}
	
	/**
	 * 
	 * @return matricola
	 */
	public String getMatricola() {
		return matricola;
	}
	
	/**
	 * 
	 * @param matricola
	 */
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
			
	@Override
	public String toString() {
		return "Operatore [matricola=" + matricola + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operatore other = (Operatore) obj;
		if (matricola == null) {
			if (other.matricola != null)
				return false;
		} else if (!matricola.equals(other.matricola))
			return false;
		return true;
	}
	
	@Override
	public Object clone() {
		try {
			Operatore cloned = (Operatore) super.clone();

			cloned.matricola = this.matricola;

			return cloned;
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private String matricola;
}
