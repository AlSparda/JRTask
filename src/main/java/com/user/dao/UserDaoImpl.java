package com.user.dao;

import com.user.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void updateUser(User user) {
        if (user.getId() == null) {
            this.em.persist(user);
        } else {
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
        return em.createQuery("from user ").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> filteredUsers(String type) {
        return em.createQuery(
                "SELECT user FROM user user WHERE user.isAdmin = :done ORDER BY user.name")
                .setParameter("done", type.equals("done"))
                .getResultList();
    }

    @Override
    @Transactional
    public void fillUsers() {
        Random random = new Random();
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setIsAdmin(random.nextBoolean());
            user.setName((random.nextBoolean() ? "Important " : "Useless ") + "deed #" + i);

            addUser(user);
        }
    }
}
