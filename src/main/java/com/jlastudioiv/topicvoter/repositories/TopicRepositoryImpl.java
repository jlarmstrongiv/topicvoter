package com.jlastudioiv.topicvoter.repositories;

import com.jlastudioiv.topicvoter.interfaces.TopicRepository;
import com.jlastudioiv.topicvoter.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Topic> findAll() {
        jdbcTemplate.query("SELECT * FROM topic");
        return null;
    }
}
