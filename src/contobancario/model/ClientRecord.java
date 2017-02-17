package contobancario.model;

import java.util.GregorianCalendar;

public class ClientRecord implements Cloneable {

	public ClientRecord() {

	}

	public ClientRecord(String name, String surname, GregorianCalendar date, String residence) {
		this.name = name;
		this.surname = surname;
		this.birthday = date;
		this.residence = residence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public GregorianCalendar getBirthday() {
		return birthday;
	}

	public void setBirthday(GregorianCalendar birthday) {
		this.birthday = birthday;
	}

	public String getResidence() {
		return residence;
	}

	public void setResidence(String residence) {
		this.residence = residence;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "[" +
				"name=" + this.name + ", " +
				"surname=" + this.surname + ", " +
				"birthday=" + this.birthday + ", " +
				"residence=" + this.residence + ", " +
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
