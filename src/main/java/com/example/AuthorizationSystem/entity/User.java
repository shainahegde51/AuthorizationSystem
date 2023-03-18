package com.example.AuthorizationSystem.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class User {
@Id
    private  String userName;
    private  String  firstName;
    private  String  lastName;
    private  String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }



    //Here we are adding many-to-many relationship between user and role entity
    //And joining these two tables (user,role) to form user_role table where we get data related to the user name and his role
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="USER_ROLE",
            joinColumns = {@JoinColumn(name= "USER_ID")},
    inverseJoinColumns = {@JoinColumn(name="ROLE_ID")
    }
    )
    private Set<Role> role;
}
