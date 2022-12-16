package com.zohocrm3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm3.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
