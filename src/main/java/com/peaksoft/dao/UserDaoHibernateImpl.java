package com.peaksoft.dao;

import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;



public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR(255)," +
                "last_name VARCHAR(255)," +
                "age INT2);";
        Session session = Util.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.createSQLQuery(SQL).executeUpdate();
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        session.createSQLQuery(" DROP TABLE users").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User();
            Session session = Util.getSessionFactory().openSession();
            try {
                session.beginTransaction();
                user.setName(name);
                user.setLastName(lastName);
                user.setAge(age);
            session.save(user);
            session.getTransaction().commit();
        } catch (HibernateException h) {
            h.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
        public void removeUserById ( long id) {
        Session session = Util.getSessionFactory().openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + user);
    }

        @Override
        public List<User> getAllUsers () {
            Session session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> users = session.createQuery("FROM User").getResultList();
            session.getTransaction().commit();
            session.close();
            return users;

        }
        @Override
        public void cleanUsersTable() {
                Session session = Util.getSessionFactory().openSession();
                session.beginTransaction();
                session.createSQLQuery("TRUNCATE TABLE Users").executeUpdate();
                session.getTransaction().commit();
                session.close();

            }
    }


