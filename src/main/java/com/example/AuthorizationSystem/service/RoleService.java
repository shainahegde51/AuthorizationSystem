package com.example.AuthorizationSystem.service;


import com.example.AuthorizationSystem.dao.RoleDao;
import com.example.AuthorizationSystem.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;


    public Role createNewRole(Role role){
        return roleDao.save(role);   //saves whatever role we have entered and return us the record
    }
}
