package com.blibli.future.todolist.controller;


import com.blibli.future.todolist.exception.ResourceNotFoundException;
import com.blibli.future.todolist.model.Todo;
import com.blibli.future.todolist.repository.TodoRepository;
import com.blibli.future.todolist.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{userId}/todo")
    public List<Todo> getItemByUserId(@PathVariable Long userId) {
        return todoRepository.findAllByUserId(userId);
    }

    @PostMapping("/user/{userId}/todo")
    public Todo addItem(@PathVariable Long userId,
                            @Valid @RequestBody Todo todoItem) {
        return userRepository.findById(userId)
                .map(user -> {

                    todoItem.setUser(user);
                    return todoRepository.save(todoItem);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }

    @PutMapping("/user/{userId}/todo/{itemId}")
    public Todo updateItem(@PathVariable Long userId,
                               @PathVariable Long itemId,
                               @Valid @RequestBody Todo ItemRequest) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }

        return todoRepository.findById(itemId)
                .map(todoItem -> {
                    todoItem.setItemDescription(ItemRequest.getItemDescription());
                    return todoRepository.save(todoItem);
                }).orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + itemId));
    }

    @DeleteMapping("/user/{userId}/todo/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable Long userId,
                                        @PathVariable Long itemId) {
        if(!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("User not found with id " + userId);
        }

        return todoRepository.findById(itemId)
                .map(todoItem -> {
                    todoRepository.delete(todoItem);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + itemId));

    }
}

