package com.peaksoft;


import com.peaksoft.dao.UserDaoJdbcImpl;

public class App
{
    public static void main( String[] args )
    {
        // реализуйте алгоритм здесь
        UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();
        userDaoJdbc.createUsersTable();
        userDaoJdbc.dropUsersTable();
        userDaoJdbc.removeUserById(1);
        userDaoJdbc.getAllUsers();
        userDaoJdbc.saveUser("Aizirek","Karimbaeva",(byte) 20);
        userDaoJdbc.cleanUsersTable();
    }
}
