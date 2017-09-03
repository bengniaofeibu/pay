package com.example.demo.service;

import com.example.demo.dao.UserEsRepository;
import com.example.demo.model.UserEs;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsServiceImpl implements EsService {
    @Autowired
    private UserEsRepository userEsRepository;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EsServiceImpl.class);

    @Override
    public UserEs findUser(String id) {
        UserEs user = new UserEs();
        user.setId(1);
        user.setNickName("test User");
        user.setUserName("User Name");
        userEsRepository.save(user);
        UserEs userEs = userEsRepository.findOne(id);
        logger.info("Get user by id {} is {}", id, userEs);
        return userEs;
    }

    @Override
    public void save(UserEs userEs) {
        userEsRepository.save(userEs);
    }

    @Override
    public Iterable<UserEs> findAll() {
        return userEsRepository.findAll();
    }
}
