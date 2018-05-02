package edu.mum.dao.impl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.UserDao;
import edu.mum.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super.setDaoType(User.class);
    }

    @Override
    public User findByEmail(String email) {

        Query query = entityManager.createQuery("select u from USERS u  where u.email =:email");
        return (User) query.setParameter("email", email).getSingleResult();

    }
}