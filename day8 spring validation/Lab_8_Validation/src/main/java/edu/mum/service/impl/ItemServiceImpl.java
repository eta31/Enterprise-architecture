package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.ItemDao;
import edu.mum.domain.Item;
import edu.mum.domain.User;
import edu.mum.service.ItemService;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService {
	
	
 	@Autowired
	private ItemDao itemDao;

    @Override
	public void save( Item Item) {  		
		itemDao.save(Item);
	}
	
	
    @Override
	public Item update( Item Item) {  		
		return itemDao.update(Item);
	}
	
	
	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

 	@Override
	public Item findOne(Long id) {
		return itemDao.findOne(id);
	}


	@Override
	public List<Item> findBySellerOrBuyer(Integer price, User buyer, User seller) {
		 
		return itemDao.findBySellerOrBuyer(price, buyer, seller);
	}

	@Override
	public List<Item> findByCategoryName(String categoryName) {
		return itemDao.findByCategoryName(categoryName);
	}
	
	@Override
	public List<Item> findItemCriteria(Integer initialPrice, User buyer, User seller) {
		return itemDao.findItemCriteria(initialPrice,buyer,seller);
	}
}
