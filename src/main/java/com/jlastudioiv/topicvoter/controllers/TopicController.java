package com.jlastudioiv.topicvoter.controllers;

import com.jlastudioiv.topicvoter.models.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TopicController {
    @RequestMapping("/")
    public String index(Model model) {
        Topic first = new Topic(1, "Java Spring", "How Spring Works");
        Topic second = new Topic(1, "Backend Fundamentals", "How Node Works");
        Topic third = new Topic(1, "React Redux", "How Single Page Apps Work");
        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(first);
        topics.add(second);
        topics.add(third);
        model.addAttribute("topics", topics);
        return "index";
    }
}
