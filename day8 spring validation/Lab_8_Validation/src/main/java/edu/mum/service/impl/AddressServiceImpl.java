package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	
	
 	@Autowired
	private AddressDao addressDao;

    @Override
	public void save( Address address) {  		
		addressDao.save(address);
	}
	
	
    @Override
	public void update( Address address) {  		
		addressDao.update(address);
	}
	
	
	@Override
	public List<Address> findAll() {
		return addressDao.findAll();
	}

 	@Override
	public Address findOne(Long id) {
		return addressDao.findOne(id);
	}


	
 
}
