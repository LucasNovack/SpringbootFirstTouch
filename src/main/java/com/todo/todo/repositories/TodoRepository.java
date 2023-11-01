package com.todo.todo.repositories;

import com.todo.todo.models.TodoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<TodoModel, UUID> {

}
