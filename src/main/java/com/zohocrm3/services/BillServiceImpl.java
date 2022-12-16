package com.zohocrm3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zohocrm3.entities.Bill;
import com.zohocrm3.repository.BillRepository;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillRepository billRepo;

	@Override
	public void saveOneBill(Bill bill) {
		billRepo.save(bill);
		
	}

}
