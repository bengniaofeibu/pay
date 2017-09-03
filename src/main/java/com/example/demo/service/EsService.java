package com.example.demo.service;

import com.example.demo.model.UserEs;
import org.springframework.stereotype.Service;

public interface EsService {

    UserEs findUser(String id);

    void save(UserEs userEs);

    Iterable<UserEs> findAll();
}