package contobancario.model;

import java.util.GregorianCalendar;

public class ClientRecord implements Cloneable {
	/**
	 * Initialize a new client.
	 *
	 */
	public ClientRecord(){
		
	}
	
	/**
	 * Inizialize a new client with his name, surname, birthday and residence.
	 * 
	 * @param name
	 * @param surname
	 * @param date
	 * @param residence
	 */
	public ClientRecord(String name, String surname, GregorianCalendar date, String residence){
		this.name = name;
		this.surname = surname;
		this.birthday = date;
		this.residence = residence;
	}

	/**
	 * 
	 * @return the name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */
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
		return "ClientRecord [name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", residence="
				+ residence + "]";
	}
	
	



	private String name;
	private String surname;
	private GregorianCalendar birthday;
	private String residence;
}
