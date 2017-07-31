package com.jlastudioiv.topicvoter.repositories;

import com.jlastudioiv.topicvoter.interfaces.TopicRepository;
import com.jlastudioiv.topicvoter.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TopicRepositoryImpl implements TopicRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Topic> findAll() {
        return jdbcTemplate.query("SELECT * FROM topic", new TopicMapper());
    }

    @Override
    public void add(String title, String description) {
        jdbcTemplate.update("INSERT INTO topic (title, description) VALUES (?, ?)", title, description);
    }

    @Override
    public void delete(long id) {
        jdbcTemplate.update("DELETE FROM topic WHERE id = ?", id);
//        always run your deletes as select first
    }

    private static class TopicMapper implements RowMapper<Topic> {
        @Override
        public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
            Topic topic = new Topic(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"));
            return topic;
        }
    }

}
