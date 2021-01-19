package com.example.LibraryManagementSystem.services;

import com.example.LibraryManagementSystem.models.User;

import java.util.Optional;

public interface IUserService {
    User getUserById(long id);
    User findByUserName(String userName);
}
