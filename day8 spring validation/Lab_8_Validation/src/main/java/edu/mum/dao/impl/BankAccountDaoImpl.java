package edu.mum.dao.impl;

 

import org.springframework.stereotype.Repository;

import edu.mum.dao.BankAccountDao;
import edu.mum.domain.BankAccount;


@SuppressWarnings("unchecked")
@Repository
public class BankAccountDaoImpl extends GenericDaoImpl<BankAccount> implements BankAccountDao {

	public BankAccountDaoImpl() {
		super.setDaoType(BankAccount.class );
		}

 
 }