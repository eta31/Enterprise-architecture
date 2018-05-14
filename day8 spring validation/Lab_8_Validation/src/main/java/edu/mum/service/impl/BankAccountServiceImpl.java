package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.BankAccountDao;
import edu.mum.domain.BankAccount;
import edu.mum.service.BankAccountService;

@Service
@Transactional 
public class BankAccountServiceImpl implements BankAccountService {
	
	
 	@Autowired
	private BankAccountDao bankAccountDao;

    @Override
	public void save( BankAccount bankAccount) {  		
		bankAccountDao.save(bankAccount);
	}
	
	
    @Override
	public void update( BankAccount bankAccount) {  		
		bankAccountDao.update(bankAccount);
	}
	
	
	@Override
	public List<BankAccount> findAll() {
		return bankAccountDao.findAll();
	}

 	@Override
	public BankAccount findOne(Long id) {
		return bankAccountDao.findOne(id);
	}


	
 
}
