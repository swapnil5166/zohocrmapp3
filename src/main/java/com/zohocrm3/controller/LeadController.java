package com.zohocrm3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm3.entities.Contact;
import com.zohocrm3.entities.Lead;
import com.zohocrm3.services.ContactService;
import com.zohocrm3.services.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/viewCreateLeadPage")
    public String viewCreateLeadPage() {
    	 return "create_new_lead";
     }
	
	@PostMapping("/saveLead")
	public String saveOneLead(@ModelAttribute("leads")Lead lead,Model model) {
		leadService.saveOneLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		Contact contact = new Contact();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContact(contact);
		leadService.deleteLeadById(id);
		List<Contact> contacts = contactService.findAllContact();
		model.addAttribute("contacts", contacts);
		return "list_contact";
		
	}
	
	@RequestMapping("/listAllLead")
	public String listallLead(Model model) {
		List<Lead> leads = leadService.findAllLeads();
		model.addAttribute("leads", leads);
		return "list_lead";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id")long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
