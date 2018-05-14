package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.CreditCardDao;
import edu.mum.domain.CreditCard;
import edu.mum.service.CreditCardService;

@Service
@Transactional 
public class CreditCardServiceImpl implements CreditCardService {
	
	
 	@Autowired
	private CreditCardDao CreditCardDao;

    @Override
	public void save( CreditCard CreditCard) {  		
		CreditCardDao.save(CreditCard);
	}
	
	
    @Override
	public void update( CreditCard CreditCard) {  		
		CreditCardDao.update(CreditCard);
	}
	
	
	@Override
	public List<CreditCard> findAll() {
		return CreditCardDao.findAll();
	}

 	@Override
	public CreditCard findOne(Long id) {
		return CreditCardDao.findOne(id);
	}


	
 
}
