package com.user.dao;

import com.user.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by aleksandr.tarasyuk on 25.06.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Transactional
    @Override
    public void updateUser(User user, Date date) {
        if (user.getId() == null) {
            this.em.persist(user);
        } else {
            user.setCreatedDate(date);
            this.em.merge(user);
        }
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        return em.createQuery("from users ").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findUsers(String type) {
        return em.createQuery(
                "SELECT user FROM users user WHERE user.name = :x")
                .setParameter("x", type)
                .getResultList();
    }



    @Override
    @Transactional
    public void findUsers() {
        Random random = new Random();
        String[] randomName = {"Alex","John","Ilya","Tanya","Oksana","Max","Lescha","Kevin","Lisa","Vika","Dasha","Jack"};
        for (int i=0; i<5; i++) {
            User user = new User();
            user.setIsAdmin(random.nextBoolean());
            user.setName(randomName[(int)(Math.random()*12)]);
            user.setAge((int)(Math.random()*35)+1);

            addUser(user);
        }
    }
}
