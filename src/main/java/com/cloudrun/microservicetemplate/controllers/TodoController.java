package com.cloudrun.microservicetemplate.controllers;

import com.cloudrun.microservicetemplate.entities.Todo;
import com.cloudrun.microservicetemplate.repositories.TodoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/all")
    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping("/new")
    public Todo newTodo(@RequestBody Todo todo) {
        Todo withDate = new Todo(
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );

        return todoRepository.save(withDate);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        todoRepository.deleteById(UUID.fromString(id));
    }

    @PatchMapping("/update/{id}")
    public Todo updateById(@PathVariable String id, @RequestBody Todo todo) {
        Todo toUpdate = todoRepository.findById(UUID.fromString(id)).get();

        // Only update the fields that are not null
        if (todo.getTitle() != null) {
            toUpdate.setTitle(todo.getTitle());
        }

        if (todo.getDescription() != null) {
            toUpdate.setDescription(todo.getDescription());
        }

        if (todo.isCompleted() != toUpdate.isCompleted()) {
            toUpdate.setCompleted(todo.isCompleted());
        }

        return todoRepository.save(toUpdate);
    }
}
