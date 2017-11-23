package com.mycompany.service;

import java.util.List;

import com.mycompany.entity.Contact;
import com.mycompany.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact  findContactbyId(int id);
	public abstract void removeContact(int id);
	
	public abstract ContactModel findContactModelById(int id);

}
