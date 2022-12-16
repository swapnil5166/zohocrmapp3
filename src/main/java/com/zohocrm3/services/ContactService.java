package com.zohocrm3.services;

import java.util.List;

import com.zohocrm3.entities.Contact;

public interface ContactService {

	public void saveContact(Contact contact);

	public List<Contact> findAllContact();



	public Contact getContactById(long id);

}
