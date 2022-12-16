package com.zohocrm3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zohocrm3.entities.Contact;
import com.zohocrm3.services.ContactService;


@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/listAllContact")
	public String listAllContact(Model model) {
		List<Contact> contacts = contactService.findAllContact();
		model.addAttribute("contacts", contacts);
		
		return "list_contact";
		
	}
}
