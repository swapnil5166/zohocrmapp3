package com.zohocrm3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zohocrm3.entities.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
