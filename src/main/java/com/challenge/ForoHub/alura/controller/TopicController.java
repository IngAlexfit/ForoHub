package com.challenge.ForoHub.alura.controller;

import com.challenge.ForoHub.alura.dto.TopicResponseDTO;
import com.challenge.ForoHub.alura.model.Category;
import com.challenge.ForoHub.alura.model.Topic;
import com.challenge.ForoHub.alura.model.User;
import com.challenge.ForoHub.alura.security.UserPrincipal;
import com.challenge.ForoHub.alura.service.TopicService;
import com.challenge.ForoHub.alura.service.UserService;
import com.challenge.ForoHub.alura.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<TopicResponseDTO>> listAll(Pageable pageable) {
        Page<Topic> topics = topicService.findAll(pageable);
        Page<TopicResponseDTO> responseDTOs = topics.map(this::convertToDTO);
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicResponseDTO> getById(@PathVariable Long id) {
        Optional<Topic> topic = topicService.findById(id);
        return topic.map(value -> ResponseEntity.ok(convertToDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, Object> payload) {
        String title = (String) payload.get("title");
        String message = (String) payload.get("message");
        Number categoryIdNumber = (Number) payload.get("categoryId");

        if (title == null || message == null || categoryIdNumber == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        Long categoryId = categoryIdNumber.longValue();
        Category category = categoryService.findById(categoryId).orElse(null);

        if (category == null) {
            return ResponseEntity.badRequest().body("Invalid category ID: Category does not exist");
        }

        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long authorId = userPrincipal.getAuthorId();
        User author = userService.findById(authorId).orElseThrow(() -> new IllegalArgumentException("Invalid author ID"));

        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setMessage(message);
        topic.setAuthor(author);
        topic.setCategory(category);

        Topic savedTopic = topicService.save(topic);
        return ResponseEntity.ok(convertToDTO(savedTopic));
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        Optional<Topic> topicOptional = topicService.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();

            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long authorId = userPrincipal.getAuthorId();

            if (!topic.getAuthor().getId().equals(authorId)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not the author of this topic. Your ID: " + authorId);
            }

            String title = (String) payload.get("title");
            String message = (String) payload.get("message");
            Number categoryIdNumber = (Number) payload.get("categoryId");

            if (title == null || message == null || categoryIdNumber == null) {
                return ResponseEntity.badRequest().body("Missing required fields");
            }

            Long categoryId = categoryIdNumber.longValue();
            Category category = categoryService.findById(categoryId).orElse(null);
            if (category == null) {
                return ResponseEntity.badRequest().body("Invalid category ID: Category does not exist");
            }

            topic.setTitle(title);
            topic.setMessage(message);
            topic.setCategory(category);

            Topic updatedTopic = topicService.save(topic);
            return ResponseEntity.ok(convertToDTO(updatedTopic));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Topic> topicOptional = topicService.findById(id);
        if (topicOptional.isPresent()) {
            Topic topic = topicOptional.get();

            UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Long authorId = userPrincipal.getAuthorId();

            if (!topic.getAuthor().getId().equals(authorId)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You are not the author of this topic. Your ID: " + authorId);
            }

            topicService.deleteById(id);
            return ResponseEntity.ok().body("Topic deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private TopicResponseDTO convertToDTO(Topic topic) {
        TopicResponseDTO responseDTO = new TopicResponseDTO();
        responseDTO.setId(topic.getId());
        responseDTO.setTitle(topic.getTitle());
        responseDTO.setMessage(topic.getMessage());
        responseDTO.setCreationDate(topic.getCreationDate());
        responseDTO.setCategory(topic.getCategory());

        TopicResponseDTO.UserResponseDTO authorDTO = new TopicResponseDTO.UserResponseDTO();
        authorDTO.setId(topic.getAuthor().getId());
        authorDTO.setNombre(topic.getAuthor().getNombre());
        authorDTO.setCorreoElectronico(topic.getAuthor().getCorreoElectronico());
        responseDTO.setAuthor(authorDTO);

        return responseDTO;
    }
}