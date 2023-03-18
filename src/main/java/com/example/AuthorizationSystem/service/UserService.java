package com.example.AuthorizationSystem.service;

import com.example.AuthorizationSystem.dao.RoleDao;
import com.example.AuthorizationSystem.dao.UserDao;
import com.example.AuthorizationSystem.entity.Role;
import com.example.AuthorizationSystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){
        return userDao.save(user);
    }

    //Logic to enter 2 roles into the table & 2 users into the table(We are using this because ,when ever we run the application the table gets deleted and to avoid this we are using this method.)
    public void initRoleAndUser(){
        Role adminRole=new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        Role userRole=new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly create record");
        roleDao.save(userRole);


        User adminUser=new User();
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setUserName("admin");
        adminUser.setPassword("admin@123");
        Set<Role> adminRoles =new HashSet<>();
        adminRoles.add(adminRole);
        userDao.save(adminUser);

        User user=new User();
        user.setFirstName("shaina");
        user.setLastName("hegde");
        user.setUserName("shaina");
        user.setPassword("shaina@123");
        Set<Role> userRoles =new HashSet<>();
        userRoles.add(userRole);
        userDao.save(user);

    }
}
