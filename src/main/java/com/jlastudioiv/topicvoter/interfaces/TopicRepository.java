package com.jlastudioiv.topicvoter.interfaces;

import com.jlastudioiv.topicvoter.models.Topic;

import java.util.List;

public interface TopicRepository {
    List<Topic> findAll();
}
