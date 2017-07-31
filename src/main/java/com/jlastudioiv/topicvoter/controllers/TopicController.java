package com.jlastudioiv.topicvoter.controllers;

import com.jlastudioiv.topicvoter.interfaces.TopicRepository;
import com.jlastudioiv.topicvoter.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TopicController {

    @Autowired
    private TopicRepository repo;

    @RequestMapping("/")
    public String index(Model model) {
        List<Topic> allTopics = repo.findAll();
        model.addAttribute("topics", allTopics);
        return "index";
    }
//    public String index(Model model) {
//        Topic first = new Topic(1, "Java Spring", "How Spring Works");
//        Topic second = new Topic(1, "Backend Fundamentals", "How Node Works");
//        Topic third = new Topic(1, "React Redux", "How Single Page Apps Work");
//        ArrayList<Topic> topics = new ArrayList<>();
//        topics.add(first);
//        topics.add(second);
//        topics.add(third);
//        model.addAttribute("topics", topics);
//        return "index";
//    }
    @RequestMapping(value = "/createTopic", method = RequestMethod.POST)
    public  String createTopic(@RequestParam("title") String title,
                               @RequestParam("description") String description) {
        repo.add(title, description);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteTopic", method = RequestMethod.POST)
    public String deleteTopic(@RequestParam("id") long id) {
        repo.delete(id);
        return "redirect:/";
    }

}
