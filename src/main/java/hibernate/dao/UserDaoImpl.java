package hibernate.dao;

import org.springframework.stereotype.Repository;
import hibernate.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> allUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
//        User managedUser = entityManager.find(User.class, user.getId());
//        entityManager.remove(managedUser);
    }

    @Override
    @Transactional(readOnly = true)
    public User getById(Integer id) {
        return entityManager.find(User.class, id);
    }
}
