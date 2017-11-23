package com.mycompany.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.constant.ViewConstant;
import com.mycompany.model.ContactModel;
import com.mycompany.service.ContactService;

@Controller
@RequestMapping("/contacts")


public class ContactController {
	
	@Autowired
	@Qualifier("contactServiceImpl")
	
	private ContactService contactService ;
	
	private static final Log LOG=LogFactory.getLog(ContactController.class);	
	
	@GetMapping("/contactform")
	public String contactForm(@RequestParam (name="id",required=false) int id,
			Model model) {
		ContactModel contact= new ContactModel() ;
		if(id != 0) {
		
			contact=contactService.findContactModelById(id);
		}
		model.addAttribute("contactModel", contact);
		LOG.info("method  : contactform ");
		return ViewConstant.Contact_form;
	}

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contacts/showcontacts";
	}
	
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts() {
		
		ModelAndView mav=new ModelAndView(ViewConstant.Contacts);
		mav.addObject("contacts",contactService.listAllContacts());
		
		return mav;
	}
	
    @PostMapping("/addcontact")
    
    public String addcontact (@ModelAttribute (name="contactModel") ContactModel contactModel ,
    		Model model) {
    	LOG.info("Method :addcontact  ---pram------: contactModel"+ contactModel.toString() );
    	
    	if (contactService.addContact(contactModel) != null) {
    		model.addAttribute("result", 1);
    	}else {
    		model.addAttribute("result", 0);
    	}
    	return "redirect:/contacts/showcontacts";
    }
    
    @GetMapping("/removecontact")
    
   public ModelAndView removeContact(@RequestParam (name="id" ,required=true) int id) {
    	contactService.removeContact(id);
    	return showContacts();
    	}
    
    
}
