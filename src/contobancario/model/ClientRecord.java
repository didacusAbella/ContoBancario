package contobancario.model;

import java.util.GregorianCalendar;

/**
 * The class ClientRecord.
 *
 */
public class ClientRecord implements Cloneable {

	/**
	 * Instantiates a new ClientRecord.
	 */
	public ClientRecord() {
		this.name = null;
		this.surname = null;
		this.birthday = null;
		this.residence = null;
	}

	/**
	 * Instantiates a new ClientRecord.
	 * 
	 * @param name the name
	 * @param surname the surname
	 * @param date the birthday
	 * @param residence the residence
	 */
	public ClientRecord(String name, String surname, GregorianCalendar date, String residence) {
		this.name = name;
		this.surname = surname;
		this.birthday = date;
		this.residence = residence;
	}

	/**
	 * Gets the client's data in a readable format.
	 * 
	 * @return the client's data
	 */
	public String toFormat() {
		return
				this.name + " " +
				this.surname + "\t\t" +
				this.birthday.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
				(this.birthday.get(GregorianCalendar.MONTH) + 1) + "/" +
				this.birthday.get(GregorianCalendar.YEAR) + "\t" +
				this.residence;
	}

	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the surname.
	 * 
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 * 
	 * @param surname the surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public GregorianCalendar getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * 
	 * @param birthday the birthday
	 */
	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the residence.
	 * 
	 * @return the residence
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * Sets the residence.
	 * 
	 * @param residence the residence
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" +
				"name=" + this.name + ", " +
				"surname=" + this.surname + ", " +
				"birthday=" + this.birthday.getTime() + ", " +
				"residence=" + this.residence +
				"]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientRecord other = (ClientRecord) obj;
		return 
				this.name.equals(other.name) &&
				this.surname.equals(other.surname) &&
				this.birthday.equals(other.birthday) &&
				this.residence.equals(other.residence);
	}

	@Override
	public Object clone() {
		try {
			ClientRecord cloned = (ClientRecord) super.clone(); 
			cloned.name = this.name; 
			cloned.surname = this.surname;
			cloned.birthday = (GregorianCalendar) this.birthday.clone();
			cloned.residence = this.residence;
			return cloned; 
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}

	private String name;
	private String surname;
	private GregorianCalendar birthday;
	private String residence;
}
