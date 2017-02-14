package contobancario.model;

import java.util.GregorianCalendar;

/**
 * The Class ClientRecord.
 * 
 */
public class ClientRecord implements Cloneable {

	/**
	 * Initializes a new client.
	 *
	 */
	public ClientRecord() {

	}

	/**
	 * Initializes a new client with his name, surname, birthday and residence.
	 * 
	 * @param name the client's name
	 * @param surname the client's surname
	 * @param date the client's birthday
	 * @param residence the client's residence
	 */
	public ClientRecord(String name, String surname, GregorianCalendar date, String residence) {
		this.name = name;
		this.surname = surname;
		this.birthday = date;
		this.residence = residence;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the birthday
	 */
	public GregorianCalendar getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the residence
	 */
	public String getResidence() {
		return residence;
	}

	/**
	 * @param residence the residence to set
	 */
	public void setResidence(String residence) {
		this.residence = residence;
	}

	/** 
	 * Return a string representation of the structure object.
	 * 
	 * @return string representation of the object
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" +
				"name=" + this.name + ", " +
				"surname=" + this.surname + ", " +
				"birthday=" + this.birthday + ", " +
				"residence=" + this.residence + ", " +
				"]";
	}

	/**
	 * Make a "deep" comparison between this object and another object.
	 * 
	 * @return true, if the comparated object have the same class and the same properties
	 */
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

	/**
	 * Make a "deep" copy of this object.
	 * 
	 * @return cloned, the clone of this object
	 */
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
