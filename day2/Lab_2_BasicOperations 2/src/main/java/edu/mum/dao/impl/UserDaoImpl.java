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
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    User user;
    List<User> users;

    @Override
    public User findByEmail(String email) {

        Query query = entityManager.createQuery("select u from User u  where u.email =:email");
        return (User) query.setParameter("email", email).getSingleResult();

    }

    @Override
    public User update(User user) {
        this.user = user;
        return this.user;
    }

    @Override
    public void save(User user) {
        this.user = user;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findOne(Long id) {

        Query query = entityManager.createQuery("select u from User u  where u.id =:id");
        return (User) query.setParameter("id", id).getSingleResult();
    }

    @Override
    public void delete(Long id){

    }

}