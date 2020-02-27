package com.alita.service;
import com.alita.po.User;

public interface UserService {

    User checkUser(String username, String password);
}
