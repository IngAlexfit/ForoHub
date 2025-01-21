package com.challenge.ForoHub.alura.service;

import com.challenge.ForoHub.alura.model.Topic;
import com.challenge.ForoHub.alura.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic save(Topic topic) {
        return topicRepository.save(topic);
    }

    public Optional<Topic> findById(Long id) {
        return topicRepository.findById(id);
    }

    public void deleteById(Long id) {
        topicRepository.deleteById(id);
    }

    public Page<Topic> findAll(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    public Optional<Topic> findByTitleAndMessage(String title, String message) {
        return topicRepository.findByTitleAndMessage(title, message);
    }
}