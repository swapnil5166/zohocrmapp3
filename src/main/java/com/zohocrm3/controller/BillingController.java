package com.zohocrm3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm3.entities.Bill;
import com.zohocrm3.entities.Contact;
import com.zohocrm3.services.BillService;
import com.zohocrm3.services.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillService billService;
	
	@RequestMapping("/generateBilll")
	public String viewBillinPage(@RequestParam("id")long id,Model model) {
		Contact contact=contactService.getContactById(id);
		model.addAttribute("contact", contact);
		return "generate_bill";
	}
	
	@PostMapping("/saveBill")
	public String saveOneBill(@ModelAttribute("bills")Bill bill,Model model) {
		billService.saveOneBill(bill);
		model.addAttribute("msg", "bill is saved");
		return"generate_bill";
	}

}
