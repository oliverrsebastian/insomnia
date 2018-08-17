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
    public List<Todo> getItemByUserId(@PathVariable String userName) {
        return todoRepository.findAllByUserUserName(userName);
    }

    @PostMapping("/user/{userName}/todo/insert")
    public Todo addItem(@PathVariable String userName,
                            @Valid @RequestBody Todo todoItem) {
        return userRepository.findById(userName)
                .map(user -> {

                    todoItem.setUser(user);
                    return todoRepository.save(todoItem);
                }).orElseThrow(() -> new ResourceNotFoundException("User not found with username " + userName));
    }

    @PutMapping("/user/{userName}/todo/{itemId}/update")
    public Todo updateItem(@PathVariable String userName,
                               @PathVariable Long itemId,
                               @Valid @RequestBody Todo ItemRequest) {
        if(!userRepository.existsById(userName)) {
            throw new ResourceNotFoundException("User not found with username " + userName);
        }

        return todoRepository.findById(itemId)
                .map(todoItem -> {
                    todoItem.setItemDescription(ItemRequest.getItemDescription());
                    return todoRepository.save(todoItem);
                }).orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + itemId));
    }

    @DeleteMapping("/user/{userId}/todo/{itemId}/delete")
    public ResponseEntity<?> deleteItem(@PathVariable String userName,
                                        @PathVariable Long itemId) {
        if(!userRepository.existsById(userName)) {
            throw new ResourceNotFoundException("User not found with username " + userName);
        }

        return todoRepository.findById(itemId)
                .map(todoItem -> {
                    todoRepository.delete(todoItem);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + itemId));

    }
}

