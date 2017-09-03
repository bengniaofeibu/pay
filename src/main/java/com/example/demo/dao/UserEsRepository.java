package com.example.demo.dao;

import com.example.demo.model.UserEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserEsRepository extends ElasticsearchRepository<UserEs, String> {
}
