package com.peaksoft;


import com.peaksoft.dao.UserDao;
import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.model.User;
import com.peaksoft.util.Util;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class App
{

    public static void main(String[] args )
    {
        // реализуйте алгоритм здесь
        UserDao userDaoHibernate = new UserDaoHibernateImpl();
        userDaoHibernate.createUsersTable();
        userDaoHibernate.dropUsersTable();
        userDaoHibernate.saveUser("Ais","Melisova",(byte)20);
        userDaoHibernate.removeUserById(1);
        System.out.println(userDaoHibernate.getAllUsers());
        userDaoHibernate.cleanUsersTable();






    }

}
