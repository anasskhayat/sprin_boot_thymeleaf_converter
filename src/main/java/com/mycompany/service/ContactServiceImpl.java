package com.mycompany.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.mycompany.component.ContactComponents;
import com.mycompany.entity.Contact;
import com.mycompany.model.ContactModel;
import com.mycompany.repository.ContactRepository;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	@Qualifier("contactRepository")
	 private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactComponents")
	private ContactComponents contactComponents;
	

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact= contactRepository.save(contactComponents.model2entity(contactModel));
		return contactComponents.entity2model(contact);
	}


	@Override
	public List<ContactModel> listAllContacts() {
		
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactModel= new ArrayList<ContactModel>();
		for(Contact contact : contacts ) {
			contactModel.add(contactComponents.entity2model(contact));
		}
		
		return contactModel;
	}


	@Override
	public Contact findContactbyId(int id) {
		
		return contactRepository.findByid(id);
	}


	@Override
	public void removeContact(int id) {
		Contact contact = findContactbyId( id) ;
		if (contact != null) {
		contactRepository.delete(contact);
		}
	}


	@Override
	public ContactModel findContactModelById(int id) {
	 
	return	contactComponents.entity2model(findContactbyId( id));

	}

}
