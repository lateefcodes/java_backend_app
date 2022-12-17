package com.digitalashram.users.service;

import com.digitalashram.users.entity.User;
import com.digitalashram.users.model.CreateUser;

public interface UserService {

    User createUser(CreateUser user);
}
