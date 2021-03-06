package com.example.controller;

import com.example.entity.Lesson;
import com.example.entity.LessonRepository;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Kevin Clark.
 */
@RestController
@RequestMapping("/lessons")
public class LessonsController {

    private final LessonRepository repository;

    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @GetMapping("/{id}")
    public Lesson getLessonById(@PathVariable long id) {
        return this.repository.findOne(id);
    }

    @PatchMapping("/{id}")
    public Lesson updateLessonById(@PathVariable long id, @RequestBody Lesson lesson) {
        return  this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void deleteLessonById(@PathVariable long id) {
        this.repository.delete(id);
        return;
    }

    @GetMapping("/movies/{title}")
    public Lesson getMoviesByTitle(@PathVariable String title) {
        return this.repository.findByTitle(title);
    }

    @GetMapping("/movies/count")
    public long getCountofLessons() {
        return this.repository.count();
    }



}
