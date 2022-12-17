/*
 @author: lateef
 @project: digitalashram
 @created: 16/12/2022 - 7:47 pm
 */
package com.digitalashram.users.service.implementation;

import com.digitalashram.core.enums.StatusType;
import com.digitalashram.users.entity.User;
import com.digitalashram.users.model.CreateUser;
import com.digitalashram.users.repository.UserRepository;
import com.digitalashram.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalashram.core.util.CommonUtil;

import java.util.Date;
import java.util.Random;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CommonUtil commonUtil;

    @Override
    public User createUser(CreateUser userBean) {
        User user= new User();
        user.setUserName(userBean.getEmailId());
        user.setCreatedBy(1l);
        user.setCreatedTime(new Date());
        user.setModifiedBy(1l);
        user.setModifiedTime(new Date());
        user.setStatus(StatusType.ONLINE);
        String randomStr = commonUtil.generateRandomString();
        user.setPassword(randomStr);
        return userRepository.save(user);
    }

}
