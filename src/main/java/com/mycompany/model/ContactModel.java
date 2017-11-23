package com.mycompany.model;

public class ContactModel {

	private int id;
	private String firstname;
	private String lastname;
	private int telephone;
	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ContactModel(int id, String firstname, String lastname, int telephone, String city) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.telephone = telephone;
		this.city = city;
	}

	public ContactModel() {

	}

	@Override
	public String toString() {
		return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone="
				+ telephone + ", city=" + city + "]";
	}
	
	
}
