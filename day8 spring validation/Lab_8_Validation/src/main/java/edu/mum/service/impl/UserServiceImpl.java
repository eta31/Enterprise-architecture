package edu.mum.service.impl;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;
import edu.mum.exception.ValidationExceptionGroup;
import edu.mum.validation.ServiceValidation;

@Service
@Transactional 
public class UserServiceImpl implements edu.mum.service.UserService {
	
 	@Autowired
	private UserDao userDao;

// 	@PreAuthorize("hasAuthority('create') && hasRole('ROLE_ADMIN')")
 	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ServiceValidation
     public void save( User user) {  		
  		userDao.save(user);
 	}
  	
 	
  	@Override
	@PreAuthorize("hasAuthority('list')")
 	public List<User> findAll() {
		return userDao.findAll();
	}
  	
  	@Override
	@PreAuthorize("hasAuthority('read')")
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
  	
//	@PreAuthorize("hasAuthority('update')")
  	@PreAuthorize("hasRole('ROLE_SUPER')")
  	@ServiceValidation
  	public User update(User user) {
		 return userDao.update(user);

	}

	
 	@Override
	public User testRefresh(User user) {
		user.setEmail("Lotta@Doe.com");
		  userDao.save(user);
		
		  return user;
	}


	@Override
 	public User findOne(Long id) {
		 
		return userDao.findOne(id);
	}
 

	
	public Boolean validate(User user, Class<?> group) {
    	// Using Hibernate validator...
        javax.validation.Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();      	
        Set<ConstraintViolation<Object>> errors = validator.validate(user, group);
        Boolean validationSuccess = errors.size() == 0 ? true : false;       
        if (!validationSuccess) throw new ValidationExceptionGroup(errors);
  	  
        /* 
          for (ConstraintViolation<User> error : errors)  
          	System.out.println(error.getPropertyPath() + " " +error.getMessage());
         */ 
        return validationSuccess;
	}
	
	
}
