package com.zohocrm3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm3.dto.Email;
import com.zohocrm3.util.EmailService;

@Controller
public class EmailController {
	
	@Autowired
	 private EmailService emailservice;
   
	@RequestMapping("/sendEmail")
	public String getEmailId(@RequestParam("email")String email,Model model) {
		model.addAttribute("email", email);
		return "compose_email";
	}
	
	@PostMapping("/triggerEmail")
	public String triggerEmail(Email email,Model model) {
		emailservice.sendSimpleMail(email.getEmail(), email.getSubject(), email.getContent());
		model.addAttribute("msg", "email sent");
		return "compose_email";
	}
	}
