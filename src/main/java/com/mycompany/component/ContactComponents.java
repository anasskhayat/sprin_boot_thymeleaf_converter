package com.mycompany.component;

import org.springframework.stereotype.Component;

import com.mycompany.entity.Contact;
import com.mycompany.model.ContactModel;

@Component("contactComponents")
public class ContactComponents {
	
	public ContactModel  entity2model (Contact contact) {
		
		ContactModel contactModel = new ContactModel();
		contactModel.setCity(contact.getCity());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setId(contact.getId());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		
		return contactModel ;
	}
	public Contact model2entity (ContactModel contactModel) {
		 
		Contact contact = new Contact();
		
		contact.setCity(contactModel.getCity());
		contact.setFirstname(contactModel.getFirstname());
		contact.setId(contactModel.getId());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		
		return contact;
		}

}
