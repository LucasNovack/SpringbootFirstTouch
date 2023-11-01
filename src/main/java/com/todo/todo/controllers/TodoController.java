package com.todo.todo.controllers;

import com.todo.todo.dtos.TodoRecordDTO;
import com.todo.todo.models.TodoModel;
import com.todo.todo.repositories.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/todo")
    public ResponseEntity<TodoModel> saveTodo(@RequestBody @Valid TodoRecordDTO todoRecordDTO){
        var todoModel = new TodoModel();
        BeanUtils.copyProperties(todoRecordDTO, todoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todoModel));
    }

    @GetMapping("/todo")
    public ResponseEntity<List<TodoModel>> getAllTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todoRepository.findAll());
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Object> getOneTodo(@PathVariable(value = "id") UUID id){
        Optional<TodoModel> todo0 = todoRepository.findById(id);
        if(todo0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(todo0.get());
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Object> updateTodo(@PathVariable(value = "id") UUID id,
                                             @RequestBody @Valid TodoRecordDTO todoRecordDTO){

        Optional<TodoModel> todo0 = todoRepository.findById(id);
        if (todo0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo to be deleted not found");
        }
        var todoModel = todo0.get();
        BeanUtils.copyProperties(todoRecordDTO, todoModel);
        return ResponseEntity.status(HttpStatus.OK).body(todoRepository.save(todoModel));
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<Object> deleteOneTodo(@PathVariable(value = "id") UUID id){
        Optional<TodoModel> todo0 = todoRepository.findById(id);
        if (todo0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo to be deleted not found");
        }
        todoRepository.delete(todo0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted");
    }

}
